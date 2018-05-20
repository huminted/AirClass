<%--
  Created by IntelliJ IDEA.
  User: humin
  Date: 2018/1/17
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
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
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <link rel="icon" href="https://raw.githubusercontent.com/huminted/AirClass/master/web/images/airclass.ico" type="image/x-icon">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>答题</title>
</head>
<body  >

<div class="container" id="main">
    <iframe id="id_iframe" name="iframe" style="display:none;"></iframe>

    <h5 class="center-align" id="title"></h5>
    <div class="row" id="row">



        <form  id="form" target="iframe" method="get" action="#">
        <div class="card col  s12 m12 l12" id="SingleChoice">
        <h3><i class="material-icons small">assignment_turned_in</i> 单项选择</h3>
            <div  id="scform">

            </div>



        </div>


        <div class="card col  s12 m12 l12" id="FillBlank">
            <h3><i class="material-icons small">create</i> 填空题</h3>
            <div  id="fbform">


            </div>


        </div>
        <div class="card col  s12 m12 l12" id="TOF">
            <h3><i class="material-icons small">done_all</i> 判断题</h3>
            <div  id="tofform">

            </div>


        </div>


        </form>

        <center>
        <button class="btn"  type="submit" name="action"  onclick="getAllAnswer();">提交
            <i class="material-icons right">send</i>
        </button>

        <span>&nbsp;</span>
        </center>
    </div>



</div>




<script type="text/javascript" src="${pageContext.request.contextPath}/js/fly.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loadQuestions.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/getAnswer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>
</body>
</html>
