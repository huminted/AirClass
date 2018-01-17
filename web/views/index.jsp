



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

<div class="row s12">
    <div class="col12 s12">
        <ul class="tabs">
            <li class="tab col s3"><a class="active" href="#test1">在线视频</a></li>
            <li class="tab col s3"><a  href="#test2">在线答题</a></li>
            <li class="tab col s3"><a href="#test3">文档提交</a></li>
            <li class="tab col s3"><a href="#test4">学习讨论</a></li>
        </ul>
    </div>

    <div id="test1" class="col s12">
        <div id="card" class="col s3">
            <div class="card medium ">
                <div class="card-image small">
                    <video class="responsive-video " controls="controls" poster="http://chart.iwakeup.cn/Main.png">
                        <source src="http://chart.iwakeup.cn/teach.mp4" type="video/mp4">
                    </video>

                </div>
                <div class="card-content">
                    <span class="card-title">结题报告.doc </span>
                    <p>I am a very simple card. I am good at containing small bits of information.</p>
                </div>
                <div class="card-action">
                    <a href="/genExcel?filename=1513087119481结题报告.doc">下载</a>
                    <a href="/delete?objectid=51">收藏</a>
                </div>
            </div>
        </div>


        <div id="card1" class="col s3">
            <div class="card medium ">
                <div class="card-image small">
                    <video class="responsive-video " controls="controls" poster="http://chart.iwakeup.cn/Main.png">
                        <source src="http://chart.iwakeup.cn/teach.mp4" type="video/mp4">
                    </video>

                </div>
                <div class="card-content">
                    <span class="card-title">结题报告.doc </span>
                    <p>I am a very simple card. I am good at containing small bits of information.</p>
                </div>
                <div class="card-action">
                    <a href="/genExcel?filename=1513087119481结题报告.doc">下载</a>
                    <a href="/delete?objectid=51">收藏</a>
                </div>
            </div>



        </div>



    </div>


    <div id="test2" class="col s12">

        <div class="col s12 m4">
            <div class="card horizontal">
                <div class="card-image">
                    <img src="https://wx1.sinaimg.cn/mw690/66e8f898gy1fnjnukznaej20j70eejrv.jpg">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p>I am a very simple card. I am good at containing small bits of information.</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col s12 m4">
            <div class="card horizontal">
                <div class="card-image">
                    <img src="https://wx1.sinaimg.cn/mw690/66e8f898gy1fnjnukznaej20j70eejrv.jpg">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p>I am a very simple card. I am good at containing small bits of information.</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col s12 m4">
            <div class="card horizontal">
                <div class="card-image">
                    <img src="https://wx1.sinaimg.cn/mw690/66e8f898gy1fnjnukznaej20j70eejrv.jpg">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p>I am a very simple card. I am good at containing small bits of information.</p>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
        </div>



    </div>
    <div id="test3" class="col s12">Test 3</div>
    <div id="test4" class="col s12">Test 4</div>




</div>








<script>

    function lo() {
        var elem = document.querySelector('.tabs');

        var instance = M.Tabs.init(elem, 4);
        instance.open(1);
    }

</script>

<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="../js/materialize.js"></script>
</body>
</html>