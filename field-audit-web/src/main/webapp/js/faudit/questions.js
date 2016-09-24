var vm = new Vue({
    el: '#main',
    data: {
        questions: [],
        pageNo : 1,
        pageSize : 10,
        totalPages : 1,
        content:""
    },
    ready: function () {
        this.findQuestions();
    },
    methods:{
        onPageClick:function (page) {//分页点击
            this.pageNo = page;
            this.findQuestions();
        },
        findQuestions:function () {//查询列表
            var self = this;
            self.questions = [];
            $.get('/question/data',"pageNo="+self.pageNo+"&content="+self.content,function (json) {
                if(typeof(json)!="object") json=JSON.parse(json);
                if(json && json.success){
                    self.questions = json.data.result;
                    self.pageNo = json.data.pageNo;
                    self.totalPages = json.data.totalPages;
                }else{
                    alert(self.msg);
                }
            });
        },
        deleteQuestion:function (index) {
            var self = this;
            var question = self.questions[index];
            if(confirm("是否确定删除问题【"+question.content+"】？")){
                $.post("/question/"+question.id+"/delete",function (json) {
                    if(typeof(json)!="object") json=JSON.parse(json);
                    if(json && json.success){
                        self.findQuestions();
                    }else{
                        alert(json.msg);
                    }
                });
            }
        }
    }
});
