

var fly=require(['https://unpkg.com/flyio/dist/fly.min.js','../js/require.js'],function getVideo () {


    fly.get('/video')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            if (json!==""){

                for (var i = 0; i < 4; i++) {


                    var parent = document.getElementById("row");
                    var div = document.createElement("div");

                    //设置 div 属性，如 id
                    div.setAttribute("id", "newDiv");

                    div.innerHTML = "<div id=\"card\" class=\"col s3\">\n" +
                        "            <div class=\"card medium \">\n" +
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


            if (json!==""){

                for (var i = 0; i <json.length; i++) {

                    var parent = document.getElementById("row1");
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
                        "                        <p>"+ json[i].title+"</p>\n" +
                        "                        <p>"+json[i].content+" </p>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"card-action\">\n" +
                        "                        <a href=\"#\">答题</a>\n" +
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

});



