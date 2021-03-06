<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>题库</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/notie.css">
    <link rel="stylesheet" href="/css/faudit/index.css">
    <link rel="stylesheet" href="/css/page.css">
    <style>
        .container {
            padding-top: 1.5rem;
        }
    </style>
</head>
<body>
<div class="container" id="main" v-cloak>
    <div class="form-group">
        <div class="col-sm-2">
            <a class="btn btn-success" target="_blank" href="/question/add">添加题目</a>
        </div>
        <div class="col-md-6">
            <input class="form-control" type="text" v-model="content" v-on:keyup.enter="findQuestions" placeholder="回车检索问题">
        </div>
    </div>
    <br>
    <template v-if="questions.length>0" >
    <table class="table table-hover">
        <thead>
        <tr>
            <th>题目</th>
            <th class="collapsing">类型</th>
            <th>选项</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(index,question) in questions" transition="expand">
            <td>
                {{question.content}}
            </td>
            <td class="collapsing">{{question.type.name}}</td>
            <td>
                <template v-for="option in question.options">
                    [{{option.content==''?'其他':option.content}}]
                </template>
            </td>
            <td>
                <a href="/question/{{question.id}}/edit" target="_blank" class="btn btn-sm btn-info">修改</a>
                <button class="btn btn-sm btn-danger" @click="deleteQuestion(index,question)">删除</button>
            </td>
        </tr>
        </tbody>
    </table>
        <page :start="pageNo" :total="totalPages" @page-click="onPageClick"></page>
    </template>
    <div class="form-group" v-else>
        <p class="form-control-static">题库中没有题目</p>
    </div>

</div>
<script src="/js/vue.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/notie.min.js"></script>
<script src="/js/components/vue.page.js"></script>
<script src="/js/faudit/question.js"></script>
</body>
</html>
