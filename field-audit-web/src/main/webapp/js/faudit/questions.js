new Vue({
    el: '#main',
    data: {
        questions: [],
        pageNo : 1,
        pageSize : 10,
        totalPages : -1,
    },
    ready: function () {
        var self = this;
        fetch('/question/data', {credentials: 'same-origin'})
            .then(function (response) {
                return response.json()
            })
            .then(function (json) {
                if(json.success){
                    self.questions = json.data.result;
                    self.pageNo = json.data.pageNo;
                    self.totalPages = json.data.totalPages;
                }

            })
            .catch(function (ex) {
                console.log('parsing failed', ex)
            });
    }
});