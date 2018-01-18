



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="../css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
            <li class="tab col s3"><a href="#test3">文档提交</a></li>
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




    <div id="test3" class="col s12">Test 3</div>
    <div id="test4" class="col s12">Test 4</div>




</div>







<script>

    function lo() {
        var elem = document.querySelector('.tabs');

        var instance = M.Tabs.init(elem, 4);



    }

</script>

<script src="https://unpkg.com/flyio/dist/fly.min.js"></script>
<script type="text/javascript" src="../js/require.js"></script>

<script type="text/javascript" src="../js/loadVideo.js">
</script>


<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="../js/materialize.js"></script>


</body>
</html>