<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>管理员端-显示管理员界面</title>
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

            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown"><img src="assets/img/user.png"
                                                                        class="img-circle" alt="Avatar">
                        <span>${login_manager.e_name}</span> <i
                                class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My
										Profile</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
                            <li><a href="/educationsystem/ManagerLogOut"><i class="lnr lnr-exit"></i>
                                <span>Logout</span></a></li>
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
                    <li>
                        <a href="#substu" data-toggle="collapse" class="collapsed"><i class="lnr lnr-home"></i> <span>学生管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="substu" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/CheckAllStudent" class="">显示学生信息</a></li>
                                <li><a href="/educationsystem/addStudent.jsp" class="">添加学生</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subles" data-toggle="collapse" class="collapsed"><i class="lnr lnr-code"></i> <span>课程管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subles" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/LessonQuery" class="">显示课程信息</a></li>
                                <li><a href="/educationsystem/addLesson.jsp" class="">添加课程</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="#subcol" data-toggle="collapse" class="collapsed"><i
                            class="lnr lnr-chart-bars"></i> <span>教师管理</span> <i
                            class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subcol" class="collapse ">
                            <ul class="nav">
                                <li><a href="/educationsystem/TeacherQuery" class="">显示教师信息</a></li>
                                <li><a href="/educationsystem/addTeacher.jsp" class="">添加新教师</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#subman" data-toggle="collapse" class="collapsed"><i class="lnr lnr-alarm"></i> <span>教务管理员</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i></a>
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
        <!-- TABLE STRIPED -->
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">当前教务管理员信息</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- 遍历集合 -->
                    <c:forEach items="${ManagerList}" var="item">
                        <tr>
                            <td>${item.e_id}</td>
                            <td>${item.e_name}</td>
                            <td>${item.e_password}</td>
                            <td>
                                <button type="button" class="btn btn-success"><a
                                        href="/educationsystem/ManagerToUpdate?e_id=${item.e_id}">编辑</a></button>
                                <button type="button" class="btn btn-danger"><a
                                        href="/educationsystem/ManagerDelete?e_id=${item.e_id}">删除</a></button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
        <!-- 分页标签 -->
<%--        <div class="page">--%>
<%--            【${pageInfo.pageIndex}/${pageInfo.totalPage}，共${pageInfo.totalRecordNum}条记录】 <a--%>
<%--                href="javascript:jumpPage(1)" title="">首页</a> <a--%>
<%--                href="javascript:jumpPage(${pageInfo.prePage})" title="">上一页</a> <a--%>
<%--                href="javascript:jumpPage(${pageInfo.nextPage})" title="">下一页</a> <a--%>
<%--                href="javascript:jumpPage(${pageInfo.totalPage})" title="">尾页</a>--%>
<%--        </div>--%>
        <!-- END TABLE STRIPED -->
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
<script type="application/javascript">

    function jumpPage(page) {
        //要修改访问的页码
        document.getElementById("page").value = page;
        document.getElementById("form_query").submit();
    }

</script>
</body>

</html>