<%--
  Created by IntelliJ IDEA.
  User: humin
  Date: 2018/1/22
  Time: 20:20
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
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="icon" href="https://raw.githubusercontent.com/huminted/AirClass/master/web/images/airclass.ico" type="image/x-icon">
    <title>管理系统</title>
</head>
<body onload="initAdmin();">
<iframe id="id_iframe" name="iframe" style="display:none;"></iframe>
<nav>
    <div class="nav-wrapper white ">

        &nbsp; &nbsp; &nbsp;&nbsp;<a href="/admin" class="brand-logo  black-text"> &nbsp;<i class="large material-icons">healing</i>管理系统 </a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/"  target="_blank" class="black-text"><i class="material-icons">home</i></a></li>
            <li><a onclick=" window.location.reload(); "  class="black-text"><i class="material-icons">refresh</i></a></li>
            <li><a onclick="alert('按住Ctrl+F')" target="_blank" class="black-text"><i class="material-icons">search</i></a></li>
            <li><a href="/chat" target="_blank" class="black-text"><i class="material-icons">comment</i></a></li>


        </ul>
    </div>

</nav>
<div class="row s12" >
    <div class="col12 s12 white z-depth-1">
        <ul class="tabs" >
            <li class="tab col s3 "><a  href="#itemDoc" class="black-text">文档管理</a></li>
            <li class="tab col s3 "><a  class="active black-text" href="#itemPaper">在线出题</a></li>
            <li class="tab col s3 "><a href="#itemGrades" class="black-text">成绩查看</a></li>
            <li class="tab col s3 "><a href="#itemVideo" class="black-text">视频管理</a></li>
        </ul>
    </div>



    <div id="itemDoc" class="col s12" >

        <div id="row" class="col s12">

            <div class="card  col m12 l12 hoverable" id="doc">
                <p class="flow-text">&nbsp;<i class="material-icons">class</i>&nbsp;学生文档</p>
                <span class="new badge blue"  id="selectedgroupid" ></span>

                <!-- 选择文档分组 -->
                <a class='dropdown-trigger btn  ' href='#' data-target='docGroupDropdown'>选择文档分组</a>
                <ul id='docGroupDropdown' class='dropdown-content'>


                </ul>

                <ul class="collection with-header" id="docul">

                </ul>
            </div>


            <div class="card  hoverable col s12">
                <p class="flow-text">文档需求发布</p>
                <center>
                    <form id="docgroupform" action="/adddocgroup" target="iframe" method="get">

                        <div class="row">
                            <div class="input-field col s6 offset-l3 ">
                                <input id="docgroupname"  name="docgroupname" type="text" class="validate" required>
                                <label for="docgroupname">分组名称</label>
                            </div>
                        </div>


                        <div class="row">
                            <div class="input-field col s6 offset-l3">
                                <input id="notification"  name="notification" type="text" class="validate" required>
                                <label for="notification">分组说明</label>
                            </div>
                        </div>


                        <button class="btn" form="docgroupform" type="submit" name="action" onclick="getAllDocGroup();" >发布分组</button>

                    </form>
                </center>

                    <ul class="collection with-header" id="docgroupul">

                    </ul>
            </div>


        </div>


    </div>


    <div id="itemPaper" class="col s12" >
        <ul class="collapsible " data-collapsible="accordion">

            <li>
                <div class="collapsible-header">

                    <i class="material-icons">insert_drive_file</i>新增试卷
                    <span class=" new badge blue " data-badge-caption="新增试卷后再出题" id="genpaperbadge"></span>

                </div>
                <div class="collapsible-body" id="collapsible-body">

                    <form id="paperform"   action="/addpaper" method="get" target="iframe" >

                        <div class="row" id="inputrow">

                            <div class="input-field col s12">
                                <input id="papertitle"  name="papertitle" type="text" class="validate" required>
                                <label for="papertitle">试卷标题</label>
                            </div>

                            <div class="input-field col s12">
                                <input id="papercontent"  name="papercontent" type="text" class="validate" required>
                                <label for="papercontent">试卷描述</label>
                            </div>

                        </div>
                        <button class="btn"  type="submit" id="genpaper" onclick="getAllPaper();getNewestPaper();">生成一张试卷</button>
                    </form>
                </div>
            </li>



            <li>
                <div class="collapsible-header"><i class="material-icons">assignment_turned_in</i>选择题</div>
                <div class="collapsible-body">

                    <form id="scform" action="/addsc" method="get" target="iframe">
                    <div class="row" >

                        <div class="input-field col s12">
                            <input id="scquestion"  name="scquestion" type="text" class="validate" required>
                            <label for="scquestion">题目</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer1"  name="scanswer1" type="text" class="validate" required>
                            <label for="scanswer1">选项1</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer2"  name="scanswer2" type="text" class="validate" required>
                            <label for="scanswer2">选项2</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer3"  name="scanswer3" type="text" class="validate" required>
                            <label for="scanswer3">选项3</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer4"  name="scanswer4" type="text" class="validate" required>
                            <label for="scanswer4">选项4</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scrightanswer"  name="scrightanswer" type="text" class="validate" required>
                            <label for="scrightanswer">正确答案</label>
                        </div>
                    </div>

                        <button   class="btn " form="scform" type="submit" name="gensc"  onclick="getScByPaperId();">发布该试题</button>
                    </form>


                    <ul class="collection with-header" id="scul">


                    </ul>
                </div>
            </li>



            <li>
                <div class="collapsible-header"><i class="material-icons">create</i>填空题</div>
                <div class="collapsible-body">

                    <form id="fbform" action="/addfb" method="get" target="iframe">
                        <div class="row" >

                            <div class="input-field col s12">
                                <input id="fbquestion"  name="fbquestion" type="text" class="validate" required>
                                <label for="fbquestion">题目</label>
                            </div>


                            <div class="input-field col s2">
                                <input id="fbanswer"  name="fbanswer" type="text" class="validate" required>
                                <label for="fbanswer">答案</label>
                            </div>

                        </div>
                        <button class="btn " form="fbform" type="submit" name="genfb" onclick="getFbByPaperId();">发布该试题</button>
                    </form>
                    <ul class="collection with-header" id="fbul">


                    </ul>
                </div>
            </li>





            <li>
                <div class="collapsible-header"><i class="material-icons">done_all</i>判断题</div>
                <div class="collapsible-body">

                    <form id="tofform" action="/addtof" method="get" target="iframe">
                        <div class="row" >

                            <div class="input-field col s12">
                                <input id="tofquestion"  name="tofquestion" type="text" class="validate" required>
                                <label for="tofquestion">题目</label>
                            </div>


                            <div class="input-field col s12">
                                <input id="tofanswer"  name="tofanswer" type="text" class="validate" required>
                                <label for="tofanswer">0代表错，1代表对</label>
                            </div>

                        </div>
                        <button class="btn " form="tofform" type="submit" name="gentof" onclick="getTofByPaperId()">发布该试题</button>
                    </form>

                    <ul class="collection with-header" id="toful">


                    </ul>
                </div>
            </li>
        </ul>



        <div class="card col m12 l12 hoverable" id="paperadmin">
            <p class="flow-text">&nbsp;<i class="material-icons">filter_none</i>&nbsp;试卷管理</p>
            <a onclick="getAllPaper()"  >&nbsp;&nbsp;刷新</a>
            <ul class="collection with-header" id="paperul">

            </ul>


        </div>


    </div>


    <div id="itemGrades" class="col s12">

        <div id="chartContainter" class="container s12">

            <canvas id="scorechart" style="padding-top: 20px" ></canvas>

        </div>



        <div class="card  col m12 l12 hoverable" id="grades">
            <p class="flow-text">&nbsp;<i class="material-icons">subject</i>&nbsp;学生成绩</p>
            <span class="new badge  blue"  id="paperidtotal" ></span>

            <!-- 试卷选择 -->
            <a class='dropdown-trigger btn  ' href='#' data-target='dropdown' id="choosepaperbtn">选择试卷</a>
            <ul id='dropdown' class='dropdown-content'>

            </ul>



            <ul class="collection with-header" id="gradesul">

            </ul>
        </div>
    </div>

    <div id="itemVideo" class="col s12">

        <div class="card  hoverable col s12">
            <p class="flow-text">&nbsp;<i class="material-icons">subscriptions</i>&nbsp;视频发布</p>
            <center>
                <form id="videoform" action="/addvideo" target="iframe" method="get">

                    <div class="row">
                        <div class="input-field col s6 offset-l3 ">
                            <input id="videotitle"  name="videotitle" type="text" class="validate" required>
                            <label for="videotitle">视频标题</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3">
                            <input id="videocontent"  name="videocontent" type="text" class="validate" required>
                            <label for="videocontent">视频描述</label>
                        </div>
                    </div>

                    <div class="row ">
                        <div class="input-field col s6 offset-l3">
                            <input id="videourl"  name="videourl" type="text" class="validate" required>
                            <label for="videourl">视频链接</label>
                        </div>
                    </div>
                    <button class="btn" form="videoform" type="submit" name="action" onclick="getAllVideo();" >发布视频</button>

                </form>
            </center>
        </div>

        <div class="card  hoverable col s12 ">
            <p class="flow-text">&nbsp;<i class="material-icons">subscriptions</i>&nbsp;视频管理</p>

        <ul class="collection with-header" id="videoul">

        </ul>
        </div>


    </div>



</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loadAdminData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>

</body>
</html>
