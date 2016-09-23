/*Vue.filter('date',function (timestrap, format) {
    return new Date(timestrap).format(format);
});*/
//new Date(questionnaire.gmtCreate).toLocaleString()
new Vue({
    el: '#main',
    data: {
        questionnaires: []
    },
    ready: function () {
        var self = this;
        fetch('/questionnaire/data', {credentials: 'same-origin'})
            .then(function (response) {
                return response.json()
            })
            .then(function (json) {
                self.questionnaires = json.data;
            })
            .catch(function (ex) {
                console.log('parsing failed', ex)
            });
    },
    methods:{
        delete:function (index) {
            var questionnaire = this.questionnaires[index];
            if(confirm('是否确定删除【'+questionnaire.title+'】？')){
                fetch('/questionnaire/'+questionnaire.id+'/delete',{method:'delete'})
                    .then(function (response) {
                        return response.json();
                    })
                    .then(function (json) {
                        if(json.success){
                            location.reload();
                        }else{
                            self.errorMessage = json.msg;
                        }
                    });
            }
        }
    }
});