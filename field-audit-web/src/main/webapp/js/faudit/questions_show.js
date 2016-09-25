var vm = new Vue({
    el: '#main',
    data: {
        id:null,
        questions: [],
        serviceId : null,
        fauditId : null,
        saved:false
    },
    ready: function () {
        var self = this;
        if(self.serviceId){
            $.get('/service/data/'+self.serviceId+"/questions",function (json) {
                if(typeof(json)!="object") json=JSON.parse(json);
                if(json && json.success){
                    var questions = json.data;
                    for(var i=0,len=questions.length;i<len;i++){
                        questions[i].errorMessage='';
                        if(questions[i].type.code==0) questions[i].radioId = null;
                        else if(questions[i].type.code==1) questions[i].checkIds = [];
                        else questions[i].other='';
                    }
                    self.questions = questions;
                }else{
                    notie.alert('error',json.msg);
                }
            })
        }
    },
    methods:{
        submit:function () {
            var self = this;
            if(self.saved){
                notie.alert('warning',"已经提交过",2);
                return;
            }
            var questions = self.questions;
            var pass=true;
            for(var i=0,len=questions.length;i<len;i++){
                questions[i].errorMessage='';
                if(questions[i].type.code==0){
                    if(!questions[i].radioId){
                        questions[i].errorMessage='未回答';
                        pass=false;
                    }
                }
                else if(questions[i].type.code==1){
                    if(!questions[i].checkIds || questions[i].checkIds.length<=0){
                        questions[i].errorMessage='未回答';
                        pass=false;
                    }
                }
                else if(questions[i].type.code==2){
                    if(!questions[i].other){//! undefined or ''
                        questions[i].errorMessage='未回答';
                        pass=false;
                    }
                }
            }
            if(pass){
                self.saved=true;
                $.ajax({
                    url:'/answer/submit',
                    type:'POST',
                    dataType:'json',
                    contentType:'application/json',
                    data:JSON.stringify({
                        id:self.id,
                        fauditId:self.fauditId,
                        questions:self.questions
                    }),
                    success:function (json) {
                        if(typeof(json)!="object") json=JSON.parse(json);
                        if(json && json.success){
                            notie.alert('success','回答成功！',2);
                        }else{
                            notie.alert('error',json.msg);
                            self.saved = false;
                        }
                    }
                });
            }

        }
    }
});
