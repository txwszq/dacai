<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="UTF-8">
    <meta name="layout" content="main" />
    <title>登录页面</title>
    <asset:stylesheet src="signin.css"/>
    <style>
        .error{
            background-color: rgba(38, 65, 80, 0.3);
            color: red;
            height: 2rem;
            line-height: 2rem;
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container">

    <form class="form-signin" id="login_form" method="post" action="j_spring_security_check">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        <g:if test="${errorMsg}">
            <p class="error" id="error-login">${errorMsg}</p>
        </g:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div> <!-- /container -->


</body>
</html>