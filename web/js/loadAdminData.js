
var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {





    fly.get('/allscore')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);



            if (json!==""){

                var parent = document.getElementById("gradesul");

                var badge=document.getElementById("paperidtotal");
                badge.setAttribute("data-badge-caption","共有 "+json.length+" 人的成绩");



                for (var i = 0; i <json.length; i++) {

                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>" + json[i].papertitle +"&nbsp;&nbsp;|&nbsp;&nbsp;"+json[i].username+"\n" +


                        " <a  class=\"secondary-content \"\">\n" +
                        " "+"成绩: "+json[i].score  +"\n" +
                        " </a>\n" +


                        " </div>";

                    parent.appendChild(li);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });



    getAllDoc();
    getAllDocGroup();
    getAllPaper();
    getAllVideo();


});




function getAllDoc() {

    setBadge("selectedgroupid","全部分组");
    setTimeout(function sleep () {

        fly.get('/alldoc')
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
                            " <div>" + docs[i].filename +"&nbsp;&nbsp;|&nbsp;&nbsp;"+docs[i].username +"\n" +
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

function getAllDocGroup() {

    setTimeout(function  sleep() {

        fly.get('/alldocgroup')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                var docgroups=eval(json.docgroup);


                if (docgroups!=="null"){

                    var parent = document.getElementById("docgroupul");
                    parent.innerHTML=" ";


                    var dropdown = document.getElementById("docGroupDropdown");
                    dropdown.innerHTML=" ";

                    var dropdownLiGetAll=document.createElement("li");
                    dropdownLiGetAll.innerHTML="<a onclick=\"getAllDoc();\">"+"查看全部"+"</a>";

                    dropdown.appendChild(dropdownLiGetAll);

                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>" + docgroups[i].groupname +"&nbsp;&nbsp;|&nbsp;&nbsp;"+docgroups[i].notification +"\n" +

                            " <a  class=\"secondary-content \"   target='iframe' onclick='getAllDocGroup();' href=\"/deldocgroup?objectid=" + docgroups[i].objectid + "\">\n" +
                            " <i class=\"\">&nbsp;删除 &nbsp;</i>\n" +
                            " </a>\n" +
                            " </div>";

                        parent.appendChild(li);


                        var dropdownLi=document.createElement("li");
                        dropdownLi.innerHTML="    <a onclick=\"getDocByGroupId("+ docgroups[i].objectid+",'"+ docgroups[i].groupname+"')\"> "+ docgroups[i].groupname  +"      </a>                                                                    ";

                        dropdown.appendChild(dropdownLi);

                    }



                }





            })
            .catch(function (error) {
                console.log(error);
            });

    },500);


}



function getDocByGroupId(groupid,groupname) {


    setTimeout(function sleep () {

        fly.get('/getdocbygroupid?groupid='+groupid)
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
                            " <div>" + docs[i].filename +"&nbsp;&nbsp;|&nbsp;&nbsp;"+docs[i].username +"\n" +



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





function getAllPaper () {
    // "/allpaer"
    setTimeout(function  sleep() {

        fly.get('/paper')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                var papers=eval(json.paper);


                if (papers!=="null"){

                    var parent = document.getElementById("paperul");
                    parent.innerHTML=" ";

                    var dropdown=document.getElementById("dropdown");
                    dropdown.innerHTML=" ";



                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>" + papers[i].title +"&nbsp;&nbsp;|&nbsp;&nbsp;"+papers[i].content +"\n" +

                            " <a  class=\"secondary-content \"   target='iframe' onclick='getAllPaper();' href=\"/delpaper?objectid=" + papers[i].objectid + "\">\n" +
                            " <i class=\"\">&nbsp;删除 &nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"/text?paperid="+ papers[i].objectid+" \">\n" +
                            " <i class=\"\">&nbsp;查看&nbsp;</i>\n" +
                            " </a>\n" +

                            " </div>";

                        parent.appendChild(li);


                        var dropdownLi=document.createElement("li");
                        dropdownLi.innerHTML="<a onclick=\"getScoreByPaperId("+papers[i].objectid +");\">"+ papers[i].title+","+ papers[i].content+"</a>";
                        dropdown.appendChild(dropdownLi);



                    }

                }





            })
            .catch(function (error) {
                console.log(error);
            });

    },500);






}

function getAllVideo() {

    setTimeout(function  sleep() {

    fly.get('/video')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            var videos=eval(json.video);



            if (videos!=="null"){
                var parent = document.getElementById("videoul");
                parent.innerHTML=" ";


                for (var i = json.total-1 ; i>=0; i--) {
                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>"
     + videos[i].title +"&nbsp;&nbsp;|&nbsp;&nbsp;" +videos[i].content+ " &nbsp;&nbsp;|&nbsp;&nbsp; "+videos[i].url+ "\n" +

                        " <a  class=\"secondary-content \"  onclick='getAllVideo();' target='iframe"   +
                        "'   href=\"/delvideo?objectid=" + videos[i].objectid + "\">\n" +
                        " <i class=\"\">&nbsp;删除 &nbsp;</i>\n" +
                        " </a>\n" +

                        "<a target=\"_blank\" class=\"secondary-content\" href=\""+ videos[i].url+"\"   onclick='getAllVideo();'>\n" +
                        " <i class=\"\">&nbsp;查看&nbsp;</i>\n" +
                        " </a>" +



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






function  getScoreById () {

    fly.get('/getscorebyid')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);


            if (json!==""){

                var parent = document.getElementById("gradesul");
                for (var i = 0; i <json.length; i++) {

                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>" + json[i].papertitle +"&nbsp;&nbsp;|&nbsp;&nbsp;"+json[i].username+"\n" +


                        " <a  class=\"secondary-content \"\">\n" +
                        " "+"成绩: "+json[i].score  +"\n" +
                        " </a>\n" +


                        " </div>";

                    parent.appendChild(li);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });

}




function getScoreByPaperId(paperid) {

    fly.get('/getscorebypaperid?paperid='+paperid)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);


            if (json!==""){

                var parent = document.getElementById("gradesul");
                parent.innerHTML=" ";

                var badge=document.getElementById("paperidtotal");
                badge.setAttribute("data-badge-caption","当前试卷共有: "+json.length+" 人交卷");


                for (var i = 0; i <json.length; i++) {


                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>" + json[i].papertitle +"&nbsp;&nbsp;|&nbsp;&nbsp;"+json[i].username+"\n" +


                        " <a  class=\"secondary-content \"\">\n" +
                        " "+"成绩: "+json[i].score  +"\n" +
                        " </a>\n" +


                        " </div>";

                    parent.appendChild(li);
                }

            }





        })
        .catch(function (error) {
            console.log(error);
        });

}







