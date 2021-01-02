<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="fullscreen-bg">

<head>
    <title>管理员端口-Login</title>
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
                            <div class="logo text-center"><img src="assets/img/logo-dark.png" alt="Klorofil Logo"></div>
                            <p class="lead">Login to your account</p>
                            <span class="helper-textright"><a href="stumanagerLogin.jsp">学生端登录login</a></span>
                            <span class="helper-textright"><a href="teacherLogin.jsp">教师端登录login</a></span>
                        </div>
                        <form class="form-auth-small" action="/educationsystem/ManagerLogin">
                            <div class="form-group">
                                <label for="signin-email" class="control-label sr-only">Email</label>
                                <input type="text" class="form-control" id="signin-email" value="" name="name"
                                       placeholder="请输入用户名">
                            </div>
                            <div class="form-group">
                                <label for="signin-password" class="control-label sr-only">Password</label>
                                <input type="password" class="form-control" id="signin-password" value=""
                                       name="password" placeholder="请输入密码">
                            </div>
                            <font style="color: red;">${message}</font>
<%--                            <div class="form-group clearfix">--%>
<%--                                <label class="fancy-checkbox element-left">--%>
<%--                                    <input type="checkbox">--%>
<%--                                    <span>Remember me</span>--%>
<%--                                </label>--%>
<%--                            </div>--%>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">LOGIN</button>
                            <div class="bottom">
                                <p class="login-count"></br></br>在线人数：${applicationScope.count}</p>
                                <span class="helper-textright"><a href="stumanagerRegister.jsp">StudentRegister</a></span>
                                <span class="helper-textright"><a href="teacherRegister.jsp">TeacherRegister</a></span>
                            </div>
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
