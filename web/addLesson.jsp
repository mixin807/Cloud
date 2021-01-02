<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>管理员-添加课程信息界面</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet"
          href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link
            href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
            rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76"
          href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96"
          href="assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index.html"><img src="assets/img/logo-dark.png"
                                      alt="Klorofil Logo" class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth">
                    <i class="lnr lnr-arrow-left-circle"></i>
                </button>
            </div>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#"
                                            class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
                            class="lnr lnr-alarm"></i> <span class="badge bg-danger">5</span>
                    </a>
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-warning"></span>System space is almost full</a></li>
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-success"></span>Monthly report is available</a></li>
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                            <li><a href="#" class="notification-item"><span
                                    class="dot bg-success"></span>Your request has been approved</a></li>
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
                        <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Basic Use</a></li>
                            <li><a href="#">Working With Data</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Troubleshooting</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown"><img src="assets/img/user.png"
                                                                        class="img-circle" alt="Avatar">
                        <span>${login_manager.e_name}</span>
                        <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My
										Profile</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
                            <li><a href="/educationsystem/ManagerLogOut"><i
                                    class="lnr lnr-exit"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="#substu" data-toggle="collapse" class="collapsed"><i
                            class="lnr lnr-home"></i> <span>学生管理</span> <i
                            class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="substu" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/CheckAllStudent" class="">显示学生信息</a></li>
                                <li><a href="/educationsystem/addStudent.jsp" class="">添加学生</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="#subles" data-toggle="collapse" class="collapsed"><i
                            class="lnr lnr-code"></i> <span>课程管理</span> <i
                            class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subles" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/LessonQuery" class="">显示课程信息</a></li>
                                <li><a href="/educationsystem/addLesson.jsp" class="">添加课程</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="#subsub" data-toggle="collapse" class="collapsed"><i
                            class="lnr lnr-cog"></i> <span>教师管理</span> <i
                            class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subsub" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/TeacherQuery" class="">显示教师信息</a></li>
                                <li><a href="/educationsystem/addTeacher.jsp" class="">添加教师</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="#subman" data-toggle="collapse" class="collapsed"><i
                            class="lnr lnr-alarm"></i> <span>教务管理员</span> <i
                            class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subman" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/ManagerQuery" class="">显示管理员信息</a></li>
                                <li><a href="/educationsystem/addManager.jsp" class="">添加管理员</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">课程管理模块</h3>
                <div class="row">
                    <!-- INPUTS -->
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">添加课程信息</h3>
                        </div>
                        <!-- 表单用于提交数据  action="/educationsystem/insertStudent" -->
                        <form action="/educationsystem/LessonInsert">
                            <div class="panel-body">
                                课程名：<input type="text" name="l_name" class="form-control"
                                           placeholder="请输入课程名">
                                <br> 课程时间：<input type="text"
                                                 name="l_time" class="form-control"
                                                 placeholder="请输入课程时间">
                                <br> 授课教师：
                                <input name="t_name" class="form-control"
                                          placeholder="textarea">
                                <br> 课程描述：
                                <textarea type="text" name="l_describe"
                                       class="form-control" placeholder="请输入课程描述" rows="3"></textarea>
                                <br>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>

                                <div class="col-md-4">
                                    <button type="submit" class="btn btn-success btn-block">提交</button>
                                </div>

                                <div class="col-md-4">
                                    <button type="reset" class="btn btn-danger btn-block">重置</button>
                                </div>
                                <div class="col-md-2"></div>
                            </div>
                    </div>
                    <!-- END INPUTS -->
                    </form>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>
</body>

</html>