<%--
  Created by IntelliJ IDEA.
  User: think
  Date: 2016/9/23
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>题库</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <style>
        .ui.container {
            padding-top: 1.5rem;
        }
        .ui.container[v-cloak] {
            display: none;
        }
    </style>
</head>
<body>
<div class="container" id="main" v-cloak>
    <a class="btn btn-success" href="/manage/question/add">添加题目</a>
    <template v-if="questions.length>0">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>题目</th>
            <th class="collapsing">类型</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="question in questions">
            <td>
                <a href="/manage/question/{{question.id}}">{{question.content}}</a>
            </td>
            <td class="collapsing">{{question.type.name}}</td>
        </tr>
        </tbody>
    </table>
        <page>分页组件</page>
    </template>
    <div class="ui message" v-else>
        题库中没有题目
    </div>
</div>
<script src="/js/vue.min.js"></script>
<script src="/js/fetch.min.js"></script>
<script src="/js/faudit/questions.js"></script>
</body>
</html>
