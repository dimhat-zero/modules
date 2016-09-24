Vue.component('page',{
    props:{
        start:{type:Number,default:1},
        total:{type:Number,default:1},
        visible:{type:Number,default:7}
    },
    template:'<div class="page-bar"><ul class="pagination">'+
    '<li v-bind:class="{\'disabled\':!showFirst}"><a v-on:click="onPageClick(prevPage)">上一页</a></li>'+
    '<li v-for="index in indexs"  v-bind:class="{ \'active\': start == index}"><a v-on:click="onPageClick(index)">{{ index }}</a></li>'+
    '<li v-bind:class="{\'disabled\':!showLast}"><a v-on:click="onPageClick(nextPage)">下一页</a></li>'+
    '<li><a>共<i>{{total}}</i>页</a></li></ul></div>',
    methods:{
        onPageClick:function (page) {
            this.$dispatch('page-click',page);
        }
    },
    computed:{
        indexs: function(){
            var left = 1;
            var right = this.total;
            var arr = [];
            var t = parseInt(this.visible/2);
            console.log(this.start+"--"+this.total);
            if(this.start<=t){
                right = this.visible;
            }else if(this.start>=this.total-t){
                left = this.total - this.visible;
            }else{
                left = this.start - t;
                right =  left + this.visible -1;
            }
            while (left <= right){
                arr.push(left++)
            }
            return arr;
        },
        prevPage : function () {
            return this.start-1<1?1:this.start-1;
        } ,
        nextPage : function(){
            return this.start+1>this.total?this.total:this.start+1;
        },
        showLast: function(){
            if(this.start >= this.total){
                return false;
            }
            return true;
        },
        showFirst: function(){
            if(this.start <= 1){
                return false;
            }
            return true;
        }
    }

});
