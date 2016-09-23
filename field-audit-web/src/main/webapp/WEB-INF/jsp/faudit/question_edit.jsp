<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑题目</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.6/semantic.min.css">
    <style>
        .ui.container {
            padding-top: 1.5rem;
        }

        .ui.container[v-cloak] {
            display: none;
        }

        .ui.form {
            margin-top: 1.5rem;
        }
    </style>
</head>
<body>
<div class="ui container" id="question" v-cloak>
    <a class="ui teal button" href="/manage/questions">返回题目列表</a>

    <div class="ui form">
        <div class="field">
            <label for="content">题目内容</label>
            <input id="content" type="text" v-model="question.content">
        </div>
        <div class="grouped fields">
            <label>题目类型</label>

            <div class="field">

                <div class="ui radio checkbox">
                    <input type="radio" id="single" value="1" name="type" v-model="question.type">
                    <label for="single">单选</label>
                </div>
            </div>
            <div class="field">
                <div class="ui radio checkbox">
                    <input type="radio" id="multiple" name="type" value="2" v-model="question.type">
                    <label for="multiple">多选</label>
                </div>
            </div>
            <div class="field">
                <div class="ui radio checkbox">
                    <input type="radio" id="answer" name="type" value="3" v-model="question.type">
                    <label for="answer">问答</label>
                </div>
            </div>
        </div>
        <div class="grouped fields" v-if="question.type!=3">
            <label>选项</label>
            <button class="ui small circular icon green button right floated" v-on:click="addOption">
                <i class="add icon"></i>
            </button>
            <p>&nbsp;</p>

            <div class="fields" v-for="(index,option) in options">
                <div class="twelve wide field">
                    <input type="text" v-model="option.content">
                </div>
                <div class="four wide field">
                    <button class="ui button" v-on:click="deleteOption(index,option)">删除</button>
                </div>
            </div>
        </div>
        <br>
        <button class="ui blue button" v-on:click="submit">保存</button>
        <button class="ui red right floated button" v-on:click="deleteQuestion">删除题目</button>
    </div>
    <div class="ui error message" v-if="errorMessage">{{errorMessage}}</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.10/vue.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fetch/0.10.1/fetch.min.js"></script>
<script src="/manage/js/notie.js"></script>
<script src="/manage/js/edit_question.js"></script>
</body>
</html>
