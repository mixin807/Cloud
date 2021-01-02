<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="fullscreen-bg">

<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script>
        function validate() {
            var password = document.getElementById("password");
            //验证password
            if (password.value == "") {
                alert("密码不能为空！");
                return false;
            } else if (password.value.length != 6) {
                alert("密码长度不符合要求，请输入6位数密码!");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <div class="vertical-align-wrap">
        <div class="vertical-align-middle">
            <div class="auth-box ">
                <div class="left">
                    <div class="content">
                        <div class="header">
                            <p class="lead">请注册你想要的角色账户-->Register</p>
                            <div class="logo text-center"><img src="assets/img/logo-dark.png"></div>
                        </div>
                        <form class="form-auth-small" action="/educationsystem/ManagerRegister" method="get" onsubmit="validate()">
                            <div class="form-group">
                                <label for="signin-email" class="control-label sr-only">Email</label>
                                <input type="text" class="form-control" id="signin-email" value="" name="name"
                                       placeholder="请输入用户名" onblur="validateEmail()"/>

                            </div>
                            <div class="form-group">
                                <label for="signin-password" class="control-label sr-only">Password</label>
                                <input type="password" class="form-control" id="signin-password" value=""
                                       name="password" placeholder="请输入密码">
                                <label id="info" style="color: #529fe3;margin-top: 10px"></label>
                            </div>
                            <font style="color: red;">${message}</font>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
                        </form>
                    </div>
                </div>
                <div class="right">
                    <div class="overlay"></div>
                    <div class="content text">
                        <h1 class="heading">Welcome to 吉大教务系统</h1>
                        <h3>凤飞千仞 薪传八方</h3>
                        <h3>以人名校 以业报国</h3>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!-- END WRAPPER -->

</body>

</html>
