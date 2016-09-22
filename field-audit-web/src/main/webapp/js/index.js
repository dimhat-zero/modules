new Vue({
    el:"#app",
    data:{
        message:'Hello world',
        todos:[
            {text:'Learn Javascript'},
            {text:'Learn Vue.js'},
            {text:'Build Something awesome'}
        ]
    },

    methods:{
        reverseMessage:function(){
            this.message = this.message.split(' ').reverse().join(' ');
        }
    }

});
new Vue({
    el:"#app2",
    data:{
        newTodo:'',
        todos:[
            {text:'Add some todo'}
        ]
    },

    methods:{
        addTodo:function(){
            var text = this.newTodo.trim();
            if(text){
                this.todos.push({text:text});
            }
        },
        removeTodo:function(index){
            this.todos.splice(index,1);
        }
    }
});
