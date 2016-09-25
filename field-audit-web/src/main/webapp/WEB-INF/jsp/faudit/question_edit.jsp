<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>{{title}}</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/notie.css">
    <link rel="stylesheet" href="/css/faudit/index.css">
    <style>
        .container {
            padding-top: 2rem;
            width: 900px;
        }
    </style>
</head>
<body>
<div class="container" v-cloak>
    <div class="form-horizontal" role="form">
        <input type="hidden" v-model="id" name="id" value="${id}"/>
        <div class="form-group">
            <label for="content" class="control-label col-md-2">题目问题</label>
            <div class="col-md-6">
                <input id="content" v-model="content" class="form-control" type="text" name="content" placeholder="请输入题目">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">题目类型</label>
            <div class="col-md-10">
                <label class="radio-inline"><input type="radio" name="type" value="0" v-model="type">单选</label>
                <label class="radio-inline"><input type="radio" name="type" value="1" v-model="type">多选</label>
                <label class="radio-inline"><input type="radio" name="type" value="2" v-model="type">问答</label>
            </div>
        </div>
        <template v-if="showOptions">
            <div class="form-group">
                <label class="control-label col-md-2">选项</label>
                <div class="text-right col-md-6">
                    <button class="btn btn-sm btn-info" type="button" @click="addOption">添加</button>
                </div>
            </div>
            <!--选项-->
            <div class="form-group" v-for="(index,option) in options">
                <div class="col-md-3 col-md-offset-2">
                    <input type="text" class="form-control" v-model="option" placeholder="选项为空表示其他">
                </div>
                <div class="col-md-2">
                    <button class="btn btn-sm btn-danger" @click="deleteOption(index,option)">删除</button>
                </div>
            </div>
        </template>
        <div class="form-group">
            <div class="col-md-2 col-md-offset-2">
                <input class="btn btn-success btn-sm" type="button" @click="submit" value="保存题目"/>
            </div>
            <div class="col-md-2">
                <input class="btn btn-warning btn-sm" type="button" @click="reset" value="重置"/>
            </div>
        </div>
        <div class="form-group" v-if="errorMessage">
            <div class="col-md-10 col-md-offset-2">
                <p class="form-control-static  bg-danger">{{errorMessage}}</p>
            </div>
        </div>
    </div>
</div>
<script src="/js/vue.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/notie.min.js"></script>
<script src="/js/faudit/edit_question.js"></script>
</body>
</html>
