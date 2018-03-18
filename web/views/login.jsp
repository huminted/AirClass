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
    <link rel="icon" href="http://static.iwakeup.cn/airclass.ico" type="image/x-icon">

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
                    <form class="col s12" action="home" method="post" onsubmit="check()" >
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">looks_one</i>
                                <input  name ="userid" id="userid"  type="text" class="validate"  maxlength="10" required>
                                <label for="userid">学号</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">lock_outline</i>
                                <input name ="password" id="password" type="password" class="validate" required>
                                <label for="password">密码</label>

                            </div>


                        </div>
                        <center>
                            <button type="submit"  class="waves-effect waves-light btn" onclick="check()">登陆</button>
                            <button type="button" onClick="location.href='/register'"  class="waves-effect waves-light btn">注册</button>
                        </center>

                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</div>



<script>


    function check() {

        var username=document.getElementById("username").value;
        var password=document.getElementById("password").value;


        if (username==" " ||password==" " ){

            return false;

        }
        else {
            return true;
        }

    }


</script>

<script src="https://unpkg.com/flyio/dist/fly.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
</body>
</html>
