



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>在线学习平台</title>
</head>

<body onload="lo();">

<nav>
    <div class="nav-wrapper ">

        &nbsp;<a href="#!" class="brand-logo"><i class="large material-icons">import_contacts</i>DIST在线学习平台</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="sass.html"><i class="material-icons">search</i></a></li>
            <li><a href="badges.html"><i class="material-icons">view_module</i></a></li>
            <li><a href="collapsible.html"><i class="material-icons">refresh</i></a></li>
            <li><a href="mobile.html"><i class="material-icons">more_vert</i></a></li>
        </ul>
    </div>

</nav>

<div class="row s12" >
    <div class="col12 s12">
        <ul class="tabs">
            <li class="tab col s3"><a class="active" href="#itemVideo">在线视频</a></li>
            <li class="tab col s3"><a  href="#itemPaper">在线答题</a></li>
            <li class="tab col s3"><a href="#itemUpload">文档提交</a></li>
            <li class="tab col s3"><a href="#test4">学习讨论</a></li>
        </ul>
    </div>

    <div id="itemVideo" class="col s12" >
        <%--视频卡片区域--%>
        <div id="row" class="row"></div>
    </div>


    <div id="itemPaper" class="col s12">
        <%--试卷卡片区域--%>
        <div id="row1" class="row"></div>

    </div>




    <div id="itemUpload" class="col s12">

        <div class="card col s12 m12 l12" >
            <p class="flow-text">&nbsp;最新通知</p>
            <blockquote>
                1.在「我的信息」填写个人资料 &nbsp;&nbsp;2.编辑模板文件 &nbsp;&nbsp;3.导出格式为XML模板 &nbsp;&nbsp;4.上传到「我的文档」&nbsp;&nbsp;5.生成最终文档
            </blockquote>
            <div class="col s6 m6  left">


                <div class="card col offset-s12 m12 l12" id="first">
                    <p class="flow-text">&nbsp;最近上传</p>


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




    <div id="test4" class="col s12">
        <iframe src='https://view.officeapps.live.com/op/embed.aspx?src=https%3A%2F%2Fc.iwakeup.cn%2Fdownload%3Ffilepath%3DC%3A%2FFiles%2F1516272605215mujiang.docx%26filename%3Dmujiang.docx' width='800px' height='800px' frameborder='0'>这是嵌入 <a target='_blank' href='https://office.com'>Microsoft Office</a> 文档，由 <a target='_blank' href='https://office.com/webapps'>Office Online</a> 支持。</iframe>



    </div>




</div>







<script>

    function lo() {
        var elem = document.querySelector('.tabs');

        var instance = M.Tabs.init(elem, 4);


    }

</script>

<script src="https://unpkg.com/flyio/dist/fly.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/require.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loadData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>

</body>
</html>