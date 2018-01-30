



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>



    <!-- Google Analytics -->
    <script async>
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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/loading.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->

    <link rel="icon" href="http://static.iwakeup.cn/airclass.ico" type="image/x-icon">
    <title>在线学习平台</title>
</head>

<body onload="initIndex();" >



<iframe id="id_iframe" name="iframe" style="display:none;"></iframe>


<nav class="white">

<div class="row">

    <div class="col s3">

        <nav class="z-depth-0">

            <div class="nav-wrapper white s12 col ">

                &nbsp; &nbsp; &nbsp;&nbsp;<a href="/" class="brand-logo   black-text"> &nbsp;<i class="large material-icons">import_contacts</i>AirClass </a>
                <span class="center-align">dsa</span>

            </div>

        </nav>

    </div>
    <div class="col s6 white">

        <nav  class="z-depth-0 m12 white  ">
        <ul class="tabs white s12 m12">
            <li class="tab col s3 black-text  "><a class="active black-text" href="#itemVideo">在线视频</a></li>
            <li class="tab col s3"><a  href="#itemPaper" class="black-text">在线答题</a></li>
            <li class="tab col s3"><a href="#itemUpload" class="black-text">文档提交</a></li>
            <li class="tab col s3"><a href="#itemZone" class="black-text">个人中心</a></li>
            <li class="indicator black" ></li>
        </ul>
        </nav>

    </div>
    <div class="col s3">

        <nav class="z-depth-0">

            <div class="nav-wrapper white  s12 ">


                <ul class="right hide-on-med-and-down">
                    <li><a href="/admin"  target="_blank" class="black-text"><i class="material-icons">view_module</i></a></li>
                    <li><a onclick=" window.location.reload();"  class="black-text"><i class="material-icons">refresh</i></a></li>
                    <li><a href="/chat" target="_blank" class="black-text"><i class="material-icons">comment</i></a></li>
                </ul>

            </div>

        </nav>

    </div>
</div>

</nav>

<div class="row s12  " >
    <div class="  black  black-text z-depth-1">


    </div>

    <div id="itemVideo" class="row s12  " >
        <%--视频卡片区域--%>
        <div id="row" class="row"></div>
    </div>


    <div id="itemPaper" class="col s12 " >
        <%--试卷卡片区域--%>
        <div id="row1" class="row"></div>

    </div>


    <div id="itemUpload" class="col s12 ">

        <div class="card col s12 m12 l12"  >
            <p class="flow-text">&nbsp;上传操作说</p>
            <blockquote>
                1.先选择文档分类
            </blockquote>
            <blockquote>
                2.点击右下角图标上传文档
            </blockquote>
            <div class="col s6 m6  left">


                <div class="card col offset-s12 m12 l12" id="first">
                    <p class="flow-text">&nbsp;我的文档</p>
                    <span class="new badge red"  id="selectedgroupid" ></span>

                    <!-- 选择文档分组 -->
                    <a class='dropdown-trigger btn  ' href='#' data-target='docGroupDropdown'>选择文档分组</a>
                    <ul id='docGroupDropdown' class='dropdown-content'>




                    </ul>


                    <ul class="collection with-header" id="docul">

                    </ul>

                </div>
            </div>


            <div class="col s6 m6 left">

                <div class="card col s12 m12 l12" id="tow">
                    <p class="flow-text">&nbsp;已批该文档</p>
                    <ul class="collection with-header" id="modifydocul">

                    </ul>

                </div>
            </div>

        </div>





        <div class=" container  ">

            <!--悬浮按钮-->
            <div class="fixed-action-btn toolbar ">
                <a class="btn-floating btn-large pulse" onclick="showdiv('uploaddiv')">
                    <i class="large material-icons">arrow_upward</i>
                </a>
                <ul>
                    <li class="waves-effect waves-light"  onclick="closediv('uploaddiv')"><a><i class="material-icons">close</i></a></li>
                    <li class="waves-effect waves-light"  onclick="showdiv('uploaddiv')"><a><i class="material-icons">expand_less</i></a></li>

                </ul>
            </div>
            <div class="container" id="uploaddiv" style="display: none;">
                <form action="fileupload" name="fileupload" id="fileupload"   onsubmit=form("userrow","file"); enctype="multipart/form-data" method="post"  >
                    <div class="file-field input-field"  >
                        <div class="btn tooltipped"   data-position="left" data-delay="50" data-tooltip="选择模板文件">
                            <span>选择</span>
                            <input type="file" name="file"  id="file">
                        </div>

                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                    <center>

                        <button class="btn " form="fileupload" type="submit" name="action"  style="float: left"
                                data-position="left" data-delay="50" data-tooltip="确认上传">确认


                        </button>

                    </center>
                </form>

            </div>
        </div>

    </div>




    <div id="itemZone" class="col s12  ">
        <div class="card  col m12 l12 hoverable" >
            <p class="flow-text">我的成绩</p>
            <div class="ResizeContainer"></div>




            <ul class="collection with-header" id="gradesul">

            </ul>
        </div>
    </div>




</div>




<footer class="page-footer grey lighten-4">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="black-text">DIST信管在线学习系统 Beta V0.1</h5>
                <p class="black-text ">推荐使用Chrome，Firefox等现代内核浏览器</p>
            </div>
            <div class="col l3 offset-l2 s12">
                <h5 class="black-text">友情链接</h5>
                <ul>
                    <li><a class="black-text " href="#!">Link 1</a></li>
                    <li><a class="black-text " href="#!">Link 2</a></li>
                    <li><a class="black-text " href="#!">Link 3</a></li>
                    <li><a class="black-text " href="#!">Link 4</a></li>
                </ul>


            </div>
        </div>
    </div>
    <div class="footer-copyright grey lighten-4" >
        <div class="container black-text">
            <a>蜀ICP备17008553号-1</a>
            © 2018 MujiangTech Humin , All rights reserved.
            <a class="black-text right " href="https://weibo.com/win8humin">了解更多</a>
        </div>
    </div>
</footer>






<script type="text/javascript" src="${pageContext.request.contextPath}/js/fly.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loadData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>





</body>
</html>