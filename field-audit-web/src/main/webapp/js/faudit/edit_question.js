var vm = new Vue({
    el:'html',
    data:{
        id:null,
        content:"",
        type:0,
        options:[],
        errorMessage:'',
        saving:true,
        title:'新增题目',
        postUrl:'/question/add'
    },
    ready:function () {
        var self= this;
        if(self.id){//update
            self.title='修改题目';
            self.postUrl='/question/'+self.id+"/edit";
            $.get('/question/data/'+self.id,function (json) {
                if(typeof(json)!="object") json = JSON.parse(json);
                if(json && json.success){
                    self.content = json.data.content;
                    var options = [];
                    $.each(json.data.options,function (i, item) {
                        options.push(item.content);
                    })
                    self.options = options;
                    self.type = json.data.type.code;
                }else{
                    notice.alert('error',json.msg);
                }
            });
        }
        self.saving=false;
    },
    computed:{
        showOptions:function () {
            var self = this;
            if(self.type == 2){//问答
                self.options = [];
                return false;
            }
            return true;
        }
    },
    methods:{
        addOption:function () {
            this.options.push('');
        },
        deleteOption:function (index, option) {
            this.options.splice(index,1);
        },
        reset:function () {
            this.content = "",this.type=0,this.options=[];
        },
        submit:function () {
            var self=  this;
            if(self.saving) return;//防止重复提交
            if(self.content==''){
                self.errorMessage='题目内容不能为空';
                return;
            }
            var count=0;
            var options = self.options;
            for(var i = 0,len=options.length;i<len;i++){
                if(options[i]=='') count++;
            }
            if(count>1){
                this.errorMessage = '不能有多个其他选项';
                return;
            }
            self.errorMessage = '';
            self.saving = true;
            console.debug("保存中...")
            $.ajax({
                type:'POST',
                url:self.postUrl,
                dataType:'json',
                contentType:'application/json',
                data:JSON.stringify({
                    id:self.id,
                    content: self.content,
                    type:self.type,
                    options: self.options
                }),
                success:function (json) {
                    if(typeof(json)!="object") json=JSON.parse(json);
                    self.saving = false;
                    if(json && json.success){
                        notie.alert('success', '保存成功!');
                    }else{
                        self.errorMessage = json.msg;
                    }
                }
            });
        }
    }
})