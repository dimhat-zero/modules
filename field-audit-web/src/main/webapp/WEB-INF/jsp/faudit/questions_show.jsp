<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>自验单填写</title>
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
    <h1>自验单填写</h1>
    <hr>
    <div class="form-horizontal">
        <input type="hidden" v-model="serviceId" value="${serviceId}">
        <input type="hidden" v-model="fauditId" value="${fauditId}">
        <!--问题-->
        <template  v-if="questions.length>0">
            <template v-for="(index,question) in questions">
            <div class="form-group">
                <label class="control-label col-md-2">问题{{index+1}}</label>
                <div class="col-md-10">
                    <p class="form-control-static">{{question.content}}</p>
                </div>
                <label class="control-label col-md-2">选项</label>
                <div class="col-md-10">
                    <!--radio-->
                    <template v-if="question.type.code==0">
                        <div class="radio" v-for="option in question.options">
                            <label v-if="option.content==''">
                                    <input type="radio" name="question{{index}}" v-bind:value="option.id" v-model="question.radioId">其他
                                    <input type="text" v-model="question.other">
                            </label>
                            <label v-else>
                                <input type="radio" name="question{{index}}" v-bind:value="option.id" v-model="question.radioId">{{option.content}}
                            </label>
                        </div>
                    </template>
                    <!--checkbox-->
                    <template v-if="question.type.code==1">
                        <div class="checkbox" v-for="option in question.options">
                            <label v-if="option.content==''">
                                <input type="checkbox" name="question{{index}}" v-bind:value="option.id" v-model="question.checkIds">其他
                                <input type="text" v-model="question.other">
                            </label>
                            <label v-else>
                                <input type="checkbox" name="question{{index}}" v-bind:value="option.id" v-model="question.checkIds">{{option.content}}
                            </label>

                        </div>
                    </template>
                    <!--wenda-->
                    <template v-if="question.type.code==2">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" class="form-control" v-model="question.other">
                            </div>
                        </div>
                    </template>
                </div>
                <div class="col-md-10 col-md-offset-2">
                    <p class="form-control-static  bg-danger" v-if="question.errorMessage">{{question.errorMessage}}</p>
                </div>
            </div>
            <hr>
            </template>
            <div class="form-group">
                <div class="col-md-offset-2"><button class="btn btn-primary" @click="submit">提交</button></div>
            </div>
        </template>
        <!--问题-->
        <template v-if="questions.length<=0">
            没有题目
        </template>
    </div>

</div>
<script src="/js/vue.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/notie.min.js"></script>
<script src="/js/components/vue.page.js"></script>
<script src="/js/faudit/questions_show.js"></script>
</body>
</html>
