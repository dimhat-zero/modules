var vm = new Vue({
    el: '#main',
    data: {
        questions: [],
        answerId : null
    },
    ready: function () {
        var self = this;
        if(self.answerId){
            $.get('/answer/data/'+self.answerId,function (json) {
                if(typeof(json)!="object") json=JSON.parse(json);
                if(json && json.success){
                    var questions = json.data;
                    self.questions = questions;
                }else{
                    notie.alert('error',json.msg);
                }
            })
        }
    }
});
