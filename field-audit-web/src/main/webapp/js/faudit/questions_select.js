var vm = new Vue({
    el: '#main',
    data: {
        serviceId:null,
        questions: [],
        pageNo: 1,
        pageSize: 10,
        totalPages: 1,
        content: "",
        selectedQuestions:[]
    },
    ready: function () {
        if(this.serviceId){
            var self = this;
            $.get('/service/data/'+this.serviceId+'/questions',function (json) {
                if (typeof(json) != "object") json = JSON.parse(json);
                if (json && json.success) {
                    self.selectedQuestions = json.data;
                } else {
                    alert(self.msg);
                }
            })
        }

        this.findQuestions();
    },
    computed:{
        selectedCount:function () {
            return this.selectedQuestions.length;
        },
        selectedQuestionIds:function () {
            var ids = [];
            var questions = this.selectedQuestions;
            for(var i=0,len=questions.length;i<len;i++){
                ids.push(questions[i].id);
            }
            return ids;
        }
    },
    methods: {
        onPageClick: function (page) {//分页点击
            this.pageNo = page;
            this.findQuestions();
        },
        findQuestions: function () {//查询列表
            var self = this;
            self.questions = [];
            $.get('/question/data', "pageNo=" + self.pageNo + "&content=" + self.content, function (json) {
                if (typeof(json) != "object") json = JSON.parse(json);
                if (json && json.success) {
                    self.questions = json.data.result;
                    self.pageNo = json.data.pageNo;
                    self.totalPages = json.data.totalPages;
                } else {
                    alert(self.msg);
                }
            });
        },
        selectQuestion:function (index, question) {
            var questions = this.selectedQuestions;
            for(var i=0,len=questions.length;i<len;i++){
                if(questions[i].id===question.id){
                    notie.alert('error','不能重复选择问题',2);
                    return;
                }
            }
            this.selectedQuestions.push(question);
        },
        unSelectQuestion:function (index, question) {
            this.selectedQuestions.splice(index,1);
        },
        saveSelectedQuestions:function () {
            var self= this;
            $.ajax({
                type:'POST',
                dataType:'json',
                contentType:'application/json',
                data:JSON.stringify({
                    questionIds:self.selectedQuestionIds
                }),
                success:function (json) {
                    if(typeof(json)!="object") json=JSON.parse(json);
                    if(json && json.success){
                        notie.alert('success','保存成功',1);
                    }else{
                        notie.alert('error',json.msg);
                    }
                }
            })
        }
    }
})