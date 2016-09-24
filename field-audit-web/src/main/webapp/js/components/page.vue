<style xmlns:v-on="http://www.w3.org/1999/xhtml">
    ul,li{
        margin: 0px;
        padding: 0px;
    }
    li{
        list-style: none
    }
    .page-bar li:first-child>a {
        margin-left: 0px
    }
    .page-bar a{
        border: 1px solid #ddd;
        text-decoration: none;
        position: relative;
        float: left;
        padding: 6px 12px;
        margin-left: -1px;
        line-height: 1.42857143;
        color: #337ab7;
        cursor: pointer
    }
    .page-bar a:hover{
        background-color: #eee;
    }
    .page-bar .active a{
        color: #fff;
        cursor: default;
        background-color: #337ab7;
        border-color: #337ab7;
    }
    .page-bar i{
        font-style:normal;
        color: #d44950;
        margin: 0px 4px;
        font-size: 12px;
    }
</style>
<template>
    <div class="page-bar">
        <ul>
            <li v-if="showFirst"><a v-on:click="cur--">上一页</a></li>
            <li v-for="index in indexs"  v-bind:class="{ 'active': cur == index}">
                <a v-on:click="btnClick(index)">{{ index }}</a>
            </li>
            <li v-if="showLast"><a v-on:click="cur++">下一页</a></li>
            <li><a>共<i>{{all}}</i>页</a></li>
        </ul>
    </div>
</template>

<script>
var pageBar = new Vue({
    el: '.page-bar',
    data: {
        all: 20, //总页数
        cur: 1//当前页码
});
</script>