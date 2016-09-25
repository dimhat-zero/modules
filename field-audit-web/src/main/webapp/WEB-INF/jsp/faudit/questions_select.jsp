<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>选择问题</title>
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
    <!--已经选择的问题-->
    <h3>已选择{{selectedCount}}个问题</h3>
    <input type="hidden" value="${serviceId}" v-model="serviceId">
    <table class="table table-hober">
        <thead>
        <tr>
            <th>题目</th>
            <th class="collapsing">类型</th>
            <th>选项</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <template v-if="selectedQuestions.length>0">
        <tr v-for="(index,question) in selectedQuestions" transition="expand">
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
                <button class="btn btn-sm btn-warning" @click="unSelectQuestion(index,question)">取消选择</button>
            </td>
        </tr>
        </template>
        <tr v-else>
            <td colspan="4">
                还未选择问题
            </td>
        </tr>
        </tbody>
    </table>
    <div class="form-group">
        <div class="col-md-offset-10 col-md-2">
            <button class="btn btn-sm btn-primary" @click="saveSelectedQuestions">保存选择</button>
        </div>
    </div>
    <h3>查询问题列表</h3>
    <div class="form-group">
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
                    <button class="btn btn-sm btn-info" @click="selectQuestion(index,question)">选择</button>
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
<script src="/js/faudit/questions_select.js"></script>
</body>
</html>
