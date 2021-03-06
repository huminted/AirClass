<%--
  Created by IntelliJ IDEA.
  User: humin
  Date: 2017/11/8
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="icon" href="http://static.iwakeup.cn/airclass.ico" type="image/x-icon">

    <!-- Google Analytics -->
    <script>
        window.ga=window.ga||function(){(ga.q=ga.q||[]).push(arguments)};ga.l=+new Date;
        ga('create', 'UA-113330665-1', 'auto');
        ga('send', 'pageview');
    </script>
    <script async src='https://www.google-analytics.com/analytics.js'></script>
    <!-- End Google Analytics -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 ">
    <title>注册</title>
    <link rel="icon" href="https://raw.githubusercontent.com/huminted/AirClass/master/web/images/airclass.ico" type="image/x-icon">
</head>
<body >

<div style="background-image:  url(https://picsum.photos/1980/1080/?random); width: 100%;height: 100%">
    <div style="height: 8%"></div>
    <div class="container "  >
        <!-- Page Content goes here -->
        <div class="row push-s7"  >
            <div class="col s12 m12 offset-s11" >
                <div class="card-panel hoverable">
                    <div class="row">
                        <form class="col s12"  action="/regist"  method="post">
                            <div class="row">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input  name ="username" id="username"  type="text" class="validate" required >
                                    <label for="username">姓名</label>
                                </div>
                                <div class="input-field col s12">
                                    <i id="idicon" class="material-icons prefix">looks_one</i>
                                    <input  name ="userid" id="userid"  type="text" class="validate" minlength="10" maxlength="10" required>
                                    <label for="userid" id="idlable">学号</label>
                                </div>

                                <div class="input-field col s12">
                                    <i class="material-icons prefix">lock</i>
                                    <input oninput="Resister(event);"  name ="password" id="password" type="tel" class="validate" required>
                                    <label for="password">密码</label>
                                </div>

                                <div class="input-field col s12">
                                    <i class="material-icons prefix">account_balance</i>
                                    <input oninput="Resister(event);"name ="school" id="school" type="tel" class="validate" required>
                                    <label for="school">学院</label>
                                </div>

                                <div class="input-field col s12">
                                    <i class="material-icons prefix">explore</i>
                                    <input oninput="Resister(event);" name ="major" id="major" type="tel" class="validate" minlength="8" required>
                                    <label for="major">专业</label>
                                </div>

                                <div class="input-field col s12">
                                    <i class="material-icons prefix">local_library</i>
                                    <input oninput="Resister(event);" name ="classes" id="classes" type="tel" maxlength="1"  class="validate">
                                    <label for="classes" >班级</label>
                                </div>

                            </div>
                            <center>
                                <button type="submit"  class="waves-effect waves-light btn" id="registerbtn">注册</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fly.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/LoginAndRegister.js"></script>
</body>
</html>
