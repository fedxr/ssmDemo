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
    <%--<li class="ac transition" id="all">全体</li>--%>
    <%--<li class="transition" id="ind">本人</li>--%>
</ul>
<div class="container">
    <div class="cat-pad">
        <form action="<%=request.getContextPath()%>/login.action" class="sign-up" id="signinForm" method="post">
            <label class="label">账号：<input type="text" name="userName" id="userName"></label>
            <label class="label">密码：<input type="password" name="password" id="password"></label>
            <div class="text-c">
                <input type="submit" value="登录">
            </div>
        </form>
    </div>

</div>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugins/jquery.validate.min.js"></script>
<%--<script src="<%=request.getContextPath()%>/assets/js/login.js"></script>--%>
</body>

</html>