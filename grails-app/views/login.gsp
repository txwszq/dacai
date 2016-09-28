<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="UTF-8">
    <asset:stylesheet href="css/bootstrap.css"/>
    <asset:stylesheet href="css/reset.css"/>
    <asset:stylesheet href="css/login.css"/>

    <asset:javascript src="js/jquery-2.0.3.min.js"/>
    <asset:javascript src="js/bootstrap.min.js"/>
    <asset:link rel="shortcut icon" href="css/img/favicon.ico" />
    <title>登录页面</title>
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
<div class="login-logo" style=""><asset:image src="img/login-logo.png" absolute="true"/></div>

<div class="login-wrap">
    <div class="dst">
        <div class="dstc center-logo">
            &nbsp;
        </div>
        <div class="dstc login-container-wrap">
            <div class="login-container normal">
                <div class="panel" style="overflow: hidden">
                    <form id="login_form" method="post" action="j_spring_security_check">
                        <div class="login-container">
                            <div class="login-title">
                            </div>
                            <g:if test="${errorMsg}">
                                <p class="error" id="error-login">${errorMsg}</p>
                            </g:if>
                            <div class="login-body dst">
                                <div class="login-model dstc text-left" style="vertical-align: middle">
                                    <input type="hidden" name="j_psd_origin" id="j_psd_origin">
                                    <div class="control-group input-wrap has-icon">
                                        <div class="icon-before username">
                                            <input type="text" class="login-input responsive-input"
                                                   name="username" id="username"
                                                   placeholder="请输入账号名" maxlength="100"  required/>
                                        </div>
                                    </div>
                                    <div class="control-group input-wrap has-icon">
                                        <div class="icon-before password">
                                            <input type="password" class="login-input responsive-input"  id="password" name="password" placeholder="请输入密码" required>
                                        </div>
                                    </div>
                                    <div class="control-group text-center">
                                        <button type="submit" class="login-btn">登录</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>