// var path=window.location.pathname;

var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {


    fly.get('/video')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            if (json!==""){

                var parent = document.getElementById("row");
                for (var i = 0; i < 4; i++) {


                    var div = document.createElement("div");

                    //设置 div 属性，如 id
                    div.setAttribute("id", "newDiv");

                    div.innerHTML = "<div id=\"card   \" class=\"col s3 medium\">\n" +
                        "            <div class=\"card \">\n" +
                        "                <div class=\"card-image small\">\n" +
                        "                    <video class=\"responsive-video \" controls=\"controls\" poster=\"http://chart.iwakeup.cn/Main.png\">\n" +
                        "                     <source src=\" "+json[i].url+"\" type=\"video/mp4\">\n" +
                        "                    </video>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"card-content\">\n" +
                        "                    <span class=\"card-title\">"+ json[i].title+" </span>\n" +
                        "                    <p>" +json[i].content+ "</p>\n" +
                        "                </div>\n" +
                        "                <div class=\"card-action\">\n" +
                        "                    <a href=\"/genExcel?filename="+json[i].objectid+"\">下载</a>\n" +
                        "                    <a href=\"/delete?objectid="+json[i].objectid+"\">收藏</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>";
                    parent.appendChild(div);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });


    fly.get('/paper')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);
            var papers=eval(json.paper);
            if (json!==""){
                var parent = document.getElementById("row1");

                for (var i = 0; i <json.total; i++) {



                    var div = document.createElement("div");

                    //设置 div 属性，如 id
                    div.setAttribute("id", "newDiv");

                    div.innerHTML = "<div class=\"col s12 m4\">\n" +
                        "            <div class=\"card horizontal\">\n" +
                        "                <div class=\"card-image\">\n" +
                        "                    <img src=\"https://wx1.sinaimg.cn/mw690/66e8f898gy1fnjnukznaej20j70eejrv.jpg\">\n" +
                        "                </div>\n" +
                        "                <div class=\"card-stacked\">\n" +
                        "                    <div class=\"card-content\">\n" +
                        "                        <p>"+ papers[i].title+"</p>\n" +
                        "                        <p>"+papers[i].content+" </p>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"card-action\">\n" +
                        "                        <a href=\"/text?paperid="+papers[i].objectid+"\">答题</a>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>";
                    parent.appendChild(div);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });


    fly.get('/doc')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);


            if (json!==""){

                var parent = document.getElementById("docul");
                for (var i = 0; i <json.length; i++) {

                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>" + json[i].filename + "\n" +



                        " <a  class=\"secondary-content \" href=\"/deleteFileCenter?objectid=" + json[i].objectid + "\">\n" +
                        " <i class=\"material-icons\">clear</i>\n" +
                        " </a>\n" +

                        " <a download class=\"secondary-content\"   href=\"" + json[i].fileurl + "\">\n" +
                        " <i class=\"material-icons\">arrow_downward</i>\n" +
                        " </a>\n" +

                        " <a  target='_blank' class=\"secondary-content\" href=\"https://view.officeapps.live.com/op/view.aspx?src=" +encodeURIComponent(json[i].fileurl) + "&filename=" + json[i].filename + "\">\n" +
                        " <i class=\"material-icons\">visibility</i>\n" +
                        " </a>\n" +

                        " </div>";

                    parent.appendChild(li);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });










});



