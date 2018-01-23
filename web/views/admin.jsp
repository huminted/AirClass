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
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>管理页面</title>
</head>
<body onload="lo();">
<iframe id="id_iframe" name="iframe" style="display:none;"></iframe>
<nav>
    <div class="nav-wrapper ">

        &nbsp;<a href="#!" class="brand-logo"><i class="large material-icons">import_contacts</i>管理模块</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="/admin"><i class="material-icons">search</i></a></li>
            <li><a href="badges.html"><i class="material-icons">view_module</i></a></li>
            <li><a href="collapsible.html"><i class="material-icons">refresh</i></a></li>
            <li><a href="mobile.html"><i class="material-icons">more_vert</i></a></li>
        </ul>
    </div>

</nav>
<div class="row s12" >
    <div class="col12 s12">
        <ul class="tabs">
            <li class="tab col s3"><a  href="#itemDoc">文档管理</a></li>
            <li class="tab col s3"><a  class="active" href="#itemPaper">在线出题</a></li>
            <li class="tab col s3"><a href="#itemGrades">成绩查看</a></li>
            <li class="tab col s3"><a href="#itemVideo">视频管理</a></li>
        </ul>
    </div>



    <div id="itemDoc" class="col s12" >
        <%--视频卡片区域--%>
        <div id="row" class="col s12">

            <div class="card  col m12 l12" id="doc">
                <p class="flow-text">&nbsp;学生文档</p>

                <ul class="collection with-header" id="docul">


                </ul>

            </div>
        </div>


    </div>


    <div id="itemPaper" class="col s12" >
        <ul class="collapsible popout" data-collapsible="accordion">



            <li>
                <div class="collapsible-header"><i class="material-icons">assignment</i>新增试卷</div>
                <div class="collapsible-body">

                    <form id="paperform"  action="/addpaper"  method="get" target="iframe">
                        <div class="row" >

                            <div class="input-field col s12">
                                <input id="papertitle"  name="papertitle" type="text" class="validate">
                                <label for="papertitle">试卷标题</label>
                            </div>

                            <div class="input-field col s12">
                                <input id="papercontent"  name="papercontent" type="text" class="validate">
                                <label for="papercontent">试卷描述</label>
                            </div>

                        </div>
                        <button class="btn " form="paperform" type="submit" name="action" >生成一张试卷</button>
                    </form>
                </div>
            </li>



            <li>
                <div class="collapsible-header"><i class="material-icons">assignment</i>选择题</div>
                <div class="collapsible-body">
                    <!--TEST1表单-->
                    <form id="scform" action="/addsc" method="get" target="iframe">
                    <div class="row" >

                        <div class="input-field col s12">
                            <input id="scquestion"  name="scquestion" type="text" class="validate">
                            <label for="scquestion">题目</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer1"  name="scanswer1" type="text" class="validate">
                            <label for="scanswer1">选项1</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer2"  name="scanswer2" type="text" class="validate">
                            <label for="scanswer2">选项2</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer3"  name="scanswer3" type="text" class="validate">
                            <label for="scanswer3">选项3</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scanswer4"  name="scanswer4" type="text" class="validate">
                            <label for="scanswer4">选项4</label>
                        </div>

                        <div class="input-field col s2">
                            <input id="scrightanswer"  name="scrightanswer" type="text" class="validate">
                            <label for="scrightanswer">正确答案</label>
                        </div>
                    </div>
                        <button class="btn " form="scform" type="submit" name="action" >发布该试题</button>
                    </form>
                </div>
            </li>



            <li>
                <div class="collapsible-header"><i class="material-icons">assignment</i>填空题</div>
                <div class="collapsible-body">

                    <form id="fbform" action="/addfb" method="get" target="iframe">
                        <div class="row" >

                            <div class="input-field col s12">
                                <input id="fbquestion"  name="fbquestion" type="text" class="validate">
                                <label for="fbquestion">题目</label>
                            </div>


                            <div class="input-field col s2">
                                <input id="fbanswer"  name="fbanswer" type="text" class="validate">
                                <label for="fbanswer">答案</label>
                            </div>

                        </div>
                        <button class="btn " form="fbform" type="submit" name="action" >发布该试题</button>
                    </form>
                </div>
            </li>





            <li>
                <div class="collapsible-header"><i class="material-icons">assignment</i>判断题</div>
                <div class="collapsible-body">

                    <form id="tofform" action="/addtof" method="get" target="iframe">
                        <div class="row" >

                            <div class="input-field col s12">
                                <input id="tofquestion"  name="tofquestion" type="text" class="validate">
                                <label for="tofquestion">题目</label>
                            </div>


                            <div class="input-field col s12">
                                <input id="tofanswer"  name="tofanswer" type="text" class="validate">
                                <label for="tofanswer">0代表错，1代表对</label>
                            </div>

                        </div>
                        <button class="btn " form="tofform" type="submit" name="action" >发布该试题</button>
                    </form>
                </div>
            </li>


        </ul>

    </div>


    <div id="itemGrades" class="col s12">

        <div class="card  col m12 l12" id="grades">
            <p class="flow-text">&nbsp;学生成绩</p>
            <a class='dropdown-button' href='#' data-activates='dropdown1' onclick="getScoreByPaperId();">&nbsp;选择试卷</a>
            <ul id='dropdown1' class='dropdown-content'>
                <li><a href="/">试卷1</a></li>
                <li><a href="/">试卷2</a></li>
                <li><a href="/">试卷3</a></li>
                <li><a href="/">试卷4</a></li>

            </ul>

            <ul class="collection with-header" id="gradesul">


            </ul>
        </div>
    </div>

    <div id="itemVideo" class="col s12">

        <div class="card  hoverable col s12">
            <p class="flow-text">视频发布</p>
            <center>
                <form id="videoform">

                    <div class="row">
                        <div class="input-field col s6 offset-l3 ">
                            <input id="videotitle"  name="videotitle" type="text" class="validate">
                            <label for="videotitle">视频标题</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s6 offset-l3">
                            <input id="videocontent"  name="videocontent" type="text" class="validate">
                            <label for="videocontent">视频描述</label>
                        </div>
                    </div>

                    <div class="row ">
                        <div class="input-field col s6 offset-l3">
                            <input id="videolink"  name="videolink" type="text" class="validate">
                            <label for="videolink">视频链接</label>
                        </div>
                    </div>
                    <button class="btn   " form="videoform" type="submit" name="action" >发布视频</button>

                </form>
            </center>
        </div>

        <div class="card  hoverable col s12 ">
            <p class="flow-text">视频管理</p>

        <ul class="collection with-header" id="videoul">

            <li class="collection-item">
                <div>视频1
                    <a class="secondary-content " href="/deleteFileCenter?objectid=undefined">
                        <i class="material-icons">clear</i>
                    </a>
                    <a download="" class="secondary-content" href="https://c.iwakeup.cn/download?filepath=C:/Files/1516272605215mujiang.docx&amp;filename=mujiang.docx">
                        <i class="material-icons">arrow_downward</i>
                    </a>
                    <a target="_blank" class="secondary-content" href="https://view.officeapps.live.com/op/view.aspx?src=https%3A%2F%2Fc.iwakeup.cn%2Fdownload%3Ffilepath%3DC%3A%2FFiles%2F1516272605215mujiang.docx%26filename%3Dmujiang.docx&amp;filename=文档1">
                        <i class="material-icons">visibility</i>
                    </a>
                </div>
            </li>
            <li class="collection-item">
                <div>视频1
                    <a class="secondary-content " href="/deleteFileCenter?objectid=undefined">
                        <i class="material-icons">clear</i>
                    </a>
                    <a download="" class="secondary-content" href="https://c.iwakeup.cn/download?filepath=C:/Files/1516272605215mujiang.docx&amp;filename=mujiang.docx">
                        <i class="material-icons">arrow_downward</i>
                    </a>
                    <a target="_blank" class="secondary-content" href="https://view.officeapps.live.com/op/view.aspx?src=https%3A%2F%2Fc.iwakeup.cn%2Fdownload%3Ffilepath%3DC%3A%2FFiles%2F1516272605215mujiang.docx%26filename%3Dmujiang.docx&amp;filename=文档1">
                        <i class="material-icons">visibility</i>
                    </a>
                </div>
            </li>
            <li class="collection-item">
                <div>视频1
                    <a class="secondary-content " href="/deleteFileCenter?objectid=undefined">
                        <i class="material-icons">clear</i>
                    </a>
                    <a download="" class="secondary-content" href="https://c.iwakeup.cn/download?filepath=C:/Files/1516272605215mujiang.docx&amp;filename=mujiang.docx">
                        <i class="material-icons">arrow_downward</i>
                    </a>
                    <a target="_blank" class="secondary-content" href="https://view.officeapps.live.com/op/view.aspx?src=https%3A%2F%2Fc.iwakeup.cn%2Fdownload%3Ffilepath%3DC%3A%2FFiles%2F1516272605215mujiang.docx%26filename%3Dmujiang.docx&amp;filename=文档1">
                        <i class="material-icons">visibility</i>
                    </a>
                </div>
            </li>

        </ul>
        </div>





    </div>

















</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loadAdminData.js"></script>

<script>

    function lo() {
        var elem = document.querySelector('.tabs');
        var instance = M.Tabs.init(elem, 4);


        var elem2 = document.querySelector('.collapsible');
        var instance = M.Collapsible.init(elem2,4);

        //
        // var elem3 = document.querySelector('.dropdown-content');
        // var instance = M.Dropdown.init(elem3,4);



    }

</script>


</body>
</html>
