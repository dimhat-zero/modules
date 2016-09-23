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
        ],
        url:'hahaha'
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
var vm3 = new Vue({
    el:'#app3',
    data:{
        a:1,
        checkedNames: [],
        selected:'B',
        age:123
    },
    computed:{
        b:function () {
            return this.a+1;
        }
    }
})
var vm4 = new Vue({
    el:'#app4',
    data:{
        show:true
    },
    methods:{
        changeShow:function () {
            this.show = !this.show;
        }
    }
})

var MyComponent = Vue.extend({
    template:'<div>A custom component</div>'
});
//全局注册
Vue.component('my-component',MyComponent);
new Vue({
    el:'#example'
})