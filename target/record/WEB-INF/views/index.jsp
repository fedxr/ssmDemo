<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Record</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>

<body>
<header>
    <h2>记录平台</h2>
</header>
<ul class="list-btn" id="tabs">
    <li class="ac transition" id="all">全体</li>
    <li class="transition" id="ind">本人</li>
</ul>
<div class="container">
    <div class="cat-pad">
        <div class="new-note">
            <div class="btn-wrapper">
                <a href="javascript:;" id="add">新增</a>
                <a href="javascript:;" id="submit">确定</a>
                <a href="javascript:;" id="cancel">取消</a>
            </div>
            <div class="work-note">
                <div class="inline-t note">
                    <b class="inline-t">本周计划：</b>
                    <textarea name="" id="newJob"></textarea>
                    <hr>
                    <b class="inline-t">上周工作：</b>
                    <textarea name="" id="job"></textarea>
                </div>
            </div>
        </div>
        <div id="catPad"></div>
    </div>

</div>
<input type="hidden" value="${USER.userId}" name="userId" id="userId">
<input type="hidden" value="${USER.nickname}" name="userName" id="userName">
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/main.js"></script>
</body>

</html>