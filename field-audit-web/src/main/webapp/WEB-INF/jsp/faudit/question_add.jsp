<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加题目</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.6/semantic.min.css">
    <style>
        .ui.container {
            padding-top: 2rem;
        }
    </style>
</head>
<body>
<div class="ui container">
    <form class="ui form" method="post">
        <div class="field">
            <label for="content">题目内容</label>
            <input id="content" type="text" name="content">
        </div>
        <div class="grouped fields" method="post">
            <label>题目类型</label>

            <div class="field">

                <div class="ui radio checkbox">
                    <input type="radio" id="single" value="0" name="type">
                    <label for="single">单选</label>
                </div>
            </div>
            <div class="field">
                <div class="ui radio checkbox">
                    <input type="radio" id="multiple" name="type" value="1">
                    <label for="multiple">多选</label>
                </div>
            </div>
            <div class="field">
                <div class="ui radio checkbox">
                    <input type="radio" id="answer" name="type" value="2">
                    <label for="answer">问答</label>
                </div>
            </div>
        </div>
        <input class="ui green button" type="submit" value="添加题目"/>
    </form>
</div>
</body>
</html>
