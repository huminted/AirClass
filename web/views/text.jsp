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
    <link type="text/css" rel="stylesheet" href="../css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>答题</title>
</head>
<body onload="lo()">
<div class="container">

    <div class="row">
        <div class="card col  s12 m12 l12" id="SingleChoice">
        <h3>单项选择</h3>
            <form action="#">

                <div id="sc1">
                    <span>1.下面哪些是正确答案</span>
                    <p>
                        <label>
                            <input name="group1" type="radio" checked />
                            <span>Red</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input name="group1" type="radio" />
                            <span>Yellow</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input  name="group1" type="radio"  />
                            <span>Green</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input name="group1" type="radio"  />
                            <span>Brown</span>
                        </label>
                    </p>
                </div>


               <div id="sc2">
                    <span>2.下面哪些是正确答案</span>
                   <p>
                       <label>
                           <input name="group2" type="radio" checked />
                           <span>Red</span>
                       </label>
                   </p>
                   <p>
                       <label>
                           <input name="group2" type="radio" />
                           <span>Yellow</span>
                       </label>
                   </p>
                   <p>
                       <label>
                           <input  name="group2" type="radio"  />
                           <span>Green</span>
                       </label>
                   </p>
                   <p>
                       <label>
                           <input name="group2" type="radio"  />
                           <span>Brown</span>
                       </label>
                   </p>

                </div>
            </form>
        </div>


        <div class="card col  s12 m12 l12" id="FillBlank">
            <h3>填空题</h3>
            <form action="#">

               <div class="col s12" id="fb1">
                        <span>1.数据逻辑结构除了集合以外，还包括：____,____,____。 </span>
                        <div class="input-field inline">
                            <input id="email_inline" type="text" class="validate">
                            <label for="email_inline">答案填写在此处</label>
                        </div>
               </div>

                <div class="col s12" id="fb2">
                    <span>1.数据逻辑结构除了集合以外，还包括：____,____,____。 </span>
                    <div class="input-field inline">
                        <input id="email_inline2" type="text" class="validate">
                        <label for="email_inline2">答案填写在此处</label>
                    </div>
                </div>

                <div class="col s12" id="fb3">
                    <span>1.数据逻辑结构除了集合以外，还包括：____,____,____。 </span>
                    <div class="input-field inline">
                        <input id="email_inline3" type="text" class="validate">
                        <label for="email_inline3">答案填写在此处</label>
                    </div>
                </div>

                <div class="col s12" id="fb4">
                    <span>1.数据逻辑结构除了集合以外，还包括：____,____,____。 </span>
                    <div class="input-field inline">
                        <input id="email_inline4" type="text" class="validate">
                        <label for="email_inline4">答案填写在此处</label>
                    </div>
                </div>



            </form>
        </div>
        <div class="card col  s12 m12 l12" id="TOF">
            <h3>判断题</h3>
            <form action="#">
                <div id="tof1">
                    <span>1.判断对错</span>
                    <p>
                        <label>
                            <input name="group1" type="radio" checked />
                            <span>X</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input name="group1" type="radio" />
                            <span>✓</span>
                        </label>
                    </p>

                </div>

                <div id="tof2">
                    <span>2.判断对错</span>
                    <p>
                        <label>
                            <input name="group2" type="radio" checked />
                            <span>X</span>
                        </label>
                    </p>
                    <p>
                        <label>
                            <input name="group2" type="radio" />
                            <span>✓</span>
                        </label>
                    </p>


                </div>
            </form>


        </div>




    </div>



</div>



<script>

    function lo() {

        var elem = document.querySelector('select');
        var instance = M.Select.init(elem, 4);


        instance.open(4);
    }

</script>

<script type="text/javascript" src="../js/materialize.js"></script>
</body>
</html>
