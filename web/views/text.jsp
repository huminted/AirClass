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
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>答题</title>
</head>
<body  >

<div class="container">
    <iframe id="id_iframe" name="iframe" style="display:none;"></iframe>

    <div class="row" id="row">



        <form  id="form" target="iframe" method="get" action="#">
        <div class="card col  s12 m12 l12" id="SingleChoice">
        <h3>单项选择</h3>
            <div  id="scform">



            </div>



        </div>


        <div class="card col  s12 m12 l12" id="FillBlank">
            <h3>填空题</h3>
            <div  id="fbform">


            </div>


        </div>
        <div class="card col  s12 m12 l12" id="TOF">
            <h3>判断题</h3>
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
