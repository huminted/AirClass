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



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Google Analytics -->
    <script>
        window.ga=window.ga||function(){(ga.q=ga.q||[]).push(arguments)};ga.l=+new Date;
        ga('create', 'UA-113330665-1', 'auto');
        ga('send', 'pageview');
    </script>
    <script async src='https://www.google-analytics.com/analytics.js'></script>
    <!-- End Google Analytics -->


    <title>登陆</title>
    <link rel="icon" href="https://raw.githubusercontent.com/huminted/AirClass/master/web/images/airclass.ico" type="image/x-icon">

    <style type="text/css">
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px white inset;
        }
    </style>


</head>




<body>



<div  style="background-image:  url(https://picsum.photos/1980/1080/?random); width: 100%;height: 100%">
<div style="height: 30%"></div>
<iframe id="id_iframe" name="iframe" style="display:none;"></iframe>
<div class="container "  >

    <!-- Page Content goes here -->
    <div class="row push-s7"  >
        <div class="col s12 m12 offset-s11" >
            <div class="card-panel hoverable">
                <div class="row">
                    <form class="col s12" action="home" method="post" onsubmit="check()"  >
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix" id="idicon">looks_one</i>
                                <input onblur="LoginCheckUserId();" name ="userid" id="userid"  type="text" class="validate" minlength="10" maxlength="10" required>
                                <label for="userid" id="idlable">学号</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix" id="pwicon">lock_outline</i>
                                <input onblur="LoginCheckPW();" name ="password" id="password" type="password" minlength="1" class="validate" required>
                                <label for="password" id="pwlable">密码</label>

                            </div>


                        </div>
                        <center>
                            <button id="loginbtn" type="submit"  class="waves-effect waves-light btn" >登陆</button>
                            <button type="button" onClick="location.href='/register'"  class="waves-effect waves-light btn">注册</button>
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
