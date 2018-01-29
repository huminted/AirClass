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
                        "                    <video class=\"responsive-video \" controls=\"controls\" poster=\"http://static.iwakeup.cn/airclassvideo2.png\">\n" +
                        "                     <source src=\" "+videos[i].url+"\" type=\"video/mp4\">\n" +
                        "                    </video>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"card-content\">\n" +
                        "                    <span class=\"card-title\">"+ videos[i].title+" </span>\n" +
                        "                    <p>" +videos[i].content+ "</p>\n" +
                        "                </div>\n" +
                        "                <div class=\"card-action\">\n" +
                        "                    <a download  class='black-text' href=\""+videos[i].url+"\">下载</a>\n" +
                        "                    <a class='black-text'  href=\"/delete?objectid="+videos[i].objectid+"\">收藏</a>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>";
                    parent.appendChild(div);
                }

            }

            setEmpty(json.total,"itemVideo","\n" +
                "<div class=\"pacman  \">\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <h6 class='text-lighten-1 black-text ' >Ծ‸Ծ被吃完了</h6>         \n  " +
                "</div>");

            reSize(json.total,4,"itemVideo");



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
                        "                    <img src=\"http://static.iwakeup.cn/airclasspaper.png\">\n" +
                        "                </div>\n" +
                        "                <div class=\"card-stacked\">\n" +
                        "                    <div class=\"card-content\">\n" +
                        "                        <p>"+ papers[i].title+"</p>\n" +
                        "                        <p>"+papers[i].content+" </p>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"card-action\">\n" +
                        "                        <a target='_blank' class='black-text' href=\"/text?paperid="+papers[i].objectid+"&papertitle="+papers[i].title+"\">答题</a>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>";
                    parent.appendChild(div);
                }

            }
            setEmpty(json.total,"itemPaper","\n" +
                "<div class=\"pacman  \">\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <div></div>\n" +
                "  <h6 class='text-lighten-1 black-text'>Ծ‸Ծ被吃完了</h6>         \n  " +
                "</div>");

            reSize(json.total,9,"itemPaper");




        })
        .catch(function (error) {
            console.log(error);
        });

    fly.get('/alldocgroup')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);
            var docgroups=eval(json.docgroup);


            if (docgroups!=="null"){

                var dropdown = document.getElementById("docGroupDropdown");
                dropdown.innerHTML=" ";

                var dropdownLiGetAll=document.createElement("li");
                dropdownLiGetAll.innerHTML="<a onclick=\"getAllDoc();\">"+"查看全部"+"</a>";
                dropdown.appendChild(dropdownLiGetAll);





                for (var i = json.total-1 ; i>=0; i--) {



                    var dropdownLi=document.createElement("li");
                    dropdownLi.innerHTML="    <a onclick=\"getDocByUserIdAndGroupId("+ docgroups[i].objectid+",'"+ docgroups[i].groupname+"');\"> "+ docgroups[i].groupname  +"      </a>                                                                    ";
                    dropdown.appendChild(dropdownLi);






                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });

    getAllDoc();



});


function getAllDoc() {
    setBadge("selectedgroupid","全部分组");

    setTimeout(function () {

        fly.get('/docbyuserid')
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

                            " <a  class=\"secondary-content \"   target='iframe'  onclick='getAllDoc();'   href=\"/deldoc?objectid=" + docs[i].objectid +"&filename="+docs[i].filename+ "\">\n" +
                            " <i class=\"material-icons black-text \">&nbsp;clear &nbsp;</i>\n" +
                            " </a>\n" +

                            " <a download class=\"secondary-content\"   href=\"" + docs[i].fileurl + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;arrow_downward&nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"https://view.officeapps.live.com/op/view.aspx?src=" + encodeURIComponent(docs[i].fileurl) + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;remove_red_eye&nbsp;</i>\n" +
                            " </a>\n" +

                            " </div>";

                        parent.appendChild(li);
                    }

                }

                reUlSize(json.total,5,"itemUpload");




            })
            .catch(function (error) {
                console.log(error);
            });
    },500);





}

function getDocByUserIdAndGroupId(groupid,groupname) {


    setTimeout(function sleep () {

        fly.get('/getdocbyuseridandgroupid?groupid='+groupid)
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                var docs=eval(json.doc);

                setBadge("selectedgroupid","当前分组为:"+groupname);

                if (docs!=="null"){

                    var parent = document.getElementById("docul");
                    parent.innerHTML=" ";
                    for (var i = 0; i <json.total; i++) {

                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>" + docs[i].filename +"&nbsp;&nbsp;|&nbsp;&nbsp;"+groupname+"\n" +


                            " <a  class=\"secondary-content \"   target='iframe'   onclick=\" getDocByGroupId("+ docs[i].objectid+",'"+ groupname+"');  \"   href=\"/deldoc?objectid=" + docs[i].objectid + "\">\n" +
                            " <i class=\"material-icons black-text \">&nbsp;clear &nbsp;</i>\n" +
                            " </a>\n" +

                            " <a download class=\"secondary-content\"   href=\"" + docs[i].fileurl + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;arrow_downward&nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"https://view.officeapps.live.com/op/view.aspx?src=" +encodeURIComponent(docs[i].fileurl) + "&filename=" + docs[i].filename + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;remove_red_eye&nbsp;</i>\n" +
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


