// var path=window.location.pathname;

var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {


    fly.get('/video')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            var videos=eval(json.video);


            if (videos!=="null"){

                var parent = document.getElementById("row");

                for (var i = 0; i <json.total; i++) {

                    var div = document.createElement("div");

                    //设置 div 属性，如 id
                    div.setAttribute("id", "newDiv");

                    div.innerHTML = "<div id=\"card   \" class=\"col s3 medium\">\n" +
                        "            <div class=\"card \">\n" +
                        "                <div class=\"card-image small\">\n" +
                        "                    <video class=\"responsive-video \" controls=\"controls\" poster=\"http://chart.iwakeup.cn/Main.png\">\n" +
                        "                     <source src=\" "+videos[i].url+"\" type=\"video/mp4\">\n" +
                        "                    </video>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"card-content\">\n" +
                        "                    <span class=\"card-title\">"+ videos[i].title+" </span>\n" +
                        "                    <p>" +videos[i].content+ "</p>\n" +
                        "                </div>\n" +
                        "                <div class=\"card-action\">\n" +
                        "                    <a href=\"/genExcel?filename="+videos[i].objectid+"\">下载</a>\n" +
                        "                    <a href=\"/delete?objectid="+videos[i].objectid+"\">收藏</a>\n" +
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

            if (papers!=="null"){
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


    getAllDoc();


});


function getAllDoc() {


    setTimeout(function () {

        fly.get('/doc')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                var docs=eval(json.doc);


                if (docs!=="null"){

                    var parent = document.getElementById("docul");
                    parent.innerHTML=" ";

                    for (var i = 0; i <json.total; i++) {

                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>" + docs[i].filename +"\n" +



                            " <a  class=\"secondary-content \"   target='iframe'  onclick='getAllDoc();'   href=\"/deldoc?objectid=" + docs[i].objectid + "\">\n" +
                            " <i class=\"\">&nbsp;删除 &nbsp;</i>\n" +
                            " </a>\n" +

                            " <a download class=\"secondary-content\"   href=\"" + docs[i].fileurl + "\">\n" +
                            " <i class=\"\">&nbsp;下载&nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"https://view.officeapps.live.com/op/view.aspx?src=" +encodeURIComponent(docs[i].fileurl) + "&filename=" + docs[i].filename + "\">\n" +
                            " <i class=\"\">&nbsp;查看&nbsp;</i>\n" +
                            " </a>\n" +

                            " </div>";

                        parent.appendChild(li);
                    }

                }





            })
            .catch(function (error) {
                console.log(error);
            });
    },500);





}



