<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="fullscreen-bg">

<head>
    <title>学生端-注册界面</title>
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
                            <p class="lead">请注册学生端用户</p>
                        </div>
                        <form class="form-auth-small" action="/educationsystem/StudentRegister" method="get"
                              onsubmit="validate()">
                            <div class="form-group">
                                <label for="name" class="control-label sr-only">用户名</label>
                                <input type="text" class="form-control" id="name" value="" name="name"
                                       placeholder="请输入非数字用户名" onblur="validateEmail()"/>

                            </div>
                            <div class="form-group">
                                <label for="sex" class="control-label sr-only">性别</label>
                                <input type="text" class="form-control"  value="" id="sex"
                                       name="sex" placeholder="请请入性别">
                            </div>
                            <div class="form-group">
                                <label for="bright" class="control-label sr-only">生日</label>
                                <input type="text" class="form-control" value="" id="bright"
                                       name="bright" placeholder="请输入生日">
                            </div>
                            <div class="form-group">
                                <label for="email" class="control-label sr-only">邮箱</label>
                                <input type="text" class="form-control" value="" id="email"
                                       name="email" placeholder="请输入邮箱">
                            </div>
                            <div class="form-group">
                                <label for="phone" class="control-label sr-only">Password</label>
                                <input type="text" class="form-control" value="" id="phone"
                                       name="phone" placeholder="请输入电话">
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label sr-only">Password</label>
                                <input type="password" class="form-control" id="password" value=""
                                       name="password" placeholder="请输入六位密码">
                            </div>
                            <font style="color: red;">${message}</font>
                            <button type="submit" class="btn btn-primary btn-lg btn-block" id="rbutton">Register</button>
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

<script type="text/javascript">
    $(function () {
        $("#rbutton").attr("disabled", true);
        var psw = $("#password");
        var name = $("#name");

        //username失去焦点时，判断是否为空
        $("#name").blur(function () {
            if (name.val().length <= 0) {
                alert("用户名不能为空！");
                $("#rbutton").attr("disabled", true);
            }
        })

        //判断密码是否为空
        $("#password").blur(function () {
            if (psw.val().length <= 0) {
                alert("密码不能为空");
                $("#rbutton").attr("disabled", true);
            }
        });
    });
</script>

<script>
    $("#name").blur(function () {
        $("#rbutton").attr("disabled", true);
        var name = document.getElementById("name").value;
        console.log(name);
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/StudentRegisterServlet",
            data: {name: name},
            dataType: 'json',
            success: function (data) {
                if (data == 1) {
                    alert("用户名已被注册！");
                    $("#rbutton").attr("disabled", true);
                } else if (data == 2) {
                    alert("用户名不合法！");
                    $("#rbutton").attr("disabled", true);
                }else{
                    $("#rbutton").removeAttr("disabled");
                }
            }
        });
    });
</script>
</body>

</html>
