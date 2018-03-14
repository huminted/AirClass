
var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {


    getAllScore();
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
                            " <i class=\"material-icons black-text\">&nbsp;arrow_downward&nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"http://oos.iwakeup.cn/wv/wordviewerframe.aspx?WOPISrc=" + docs[i].viewurl + "\">\n" +
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
                            " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
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
                            " <i class=\"material-icons black-text\">&nbsp;arrow_downward&nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"http://oos.iwakeup.cn/wv/wordviewerframe.aspx?WOPISrc=" + docs[i].viewurl + "\">\n" +
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


                    var dropdownLiGetAll=document.createElement("li");
                    dropdownLiGetAll.innerHTML="<a onclick=\"getAllScore();\">"+"查看全部"+"</a>";
                    dropdown.appendChild(dropdownLiGetAll);



                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>" + papers[i].title +"&nbsp;&nbsp;|&nbsp;&nbsp;"+papers[i].content +"\n" +

                            " <a  class=\"secondary-content \"   target='iframe' onclick='getAllPaper();' href=\"/delpaper?objectid=" + papers[i].objectid + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
                            " </a>\n" +

                            " <a  target='_blank' class=\"secondary-content\" href=\"/text?paperid="+ papers[i].objectid+" \">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;remove_red_eye&nbsp;</i>\n" +
                            " </a>\n" +

                            " </div>";

                        parent.appendChild(li);


                        var dropdownLi=document.createElement("li");
                        dropdownLi.innerHTML="<a onclick=\"getScoreByPaperId("+ papers[i].objectid+",'"+ papers[i].title+"');\"> "+ papers[i].title+","+ papers[i].content +"      </a> ";
                        dropdown.appendChild(dropdownLi);



                    }

                }





            })
            .catch(function (error) {
                console.log(error);
            });

    },500);






}


function getNewestPaper() {

    setTimeout(function sleep() {

        fly.get('/getNewestPaper')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                var paper=eval(json.paper);


                // setBadge("selectedgroupid","当前分组为:"+groupname);


                if (json.code!==0){

                    setBadge("genpaperbadge",paper.title);

                    document.getElementById("genpaper").disabled=true;

                    document.getElementById("inputrow").style.display="none";


                    var collapsibleBody =document.getElementById("collapsible-body");
                    var lockdiv=document.createElement("div");
                    lockdiv.setAttribute("id","lockdiv");

                    lockdiv.innerHTML=
                        "<div class=\"card-panel\">\n" +
                        "      <span class=\"blue-text text-darken-2\">已经为您锁定试卷</span>\n" +
                        "      <span class=\"blue-text text-darken-2 right\"  onclick='unLock();'>解锁 </span>" +
                        "      <h6 class=\"blue-text  center-align text-darken-2\">"+paper.title+"</h6>" +
                        "      <h6 class=\"blue-text center-align  text-darken-2\">"+paper.content+"</h6>" +
                        "</div>";

                    collapsibleBody.appendChild(lockdiv);



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
                        " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
                        " </a>\n" +

                        "<a target=\"_blank\" class=\"secondary-content\" href=\""+ videos[i].url+"\"   onclick='getAllVideo();'>\n" +
                        " <i class=\"material-icons black-text\">&nbsp;remove_red_eye&nbsp;</i>\n" +
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

function  getAllScore() {


    fly.get('/allscore')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            var subjectArray=[],scoreArray=[];

            if (json!==""){

                var parent = document.getElementById("gradesul");
                parent.innerHTML=" ";

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

                    subjectArray[i]=json[i].username;
                    scoreArray[i]=json[i].score;
                }

            }


            var scoreChart=new ScoreChart("scorechart","全部成绩",subjectArray,scoreArray);

            scoreChart.show();


        })
        .catch(function (error) {
            console.log(error);
        });




}


function getScoreByPaperId(paperid,papername) {

    fly.get('/getscorebypaperid?paperid='+paperid)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            var subjectArray=[],scoreArray=[];

            if (json!==""){

                var parent = document.getElementById("gradesul");
                parent.innerHTML=" ";

                setBadge("paperidtotal",papername+"   共有: "+json.length+" 人交卷");


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


                    subjectArray[i]=json[i].username;
                    scoreArray[i]=json[i].score;

                }

                var scoreChart=new ScoreChart("scorechart",papername,subjectArray,scoreArray);

                scoreChart.show();

            }





        })
        .catch(function (error) {
            console.log(error);
        });

}



function getScByPaperId() {


    setTimeout(function  sleep() {

        fly.get('/getScByPaperId')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);

                var scs=eval(json.scs);



                if (scs!=="null"){
                    var parent = document.getElementById("scul");
                    parent.innerHTML=" ";


                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>"
                            + scs[i].question  +"&nbsp;&nbsp;|&nbsp;&nbsp;正确答案: "+scs[i].rightanswer+ "\n" +

                            " <a  class=\"secondary-content \"  onclick='getScByPaperId();' target='iframe"  +
                            "'   href=\"/delsc?objectid=" + scs[i].objectid + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
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


function getFbByPaperId() {


    setTimeout(function  sleep() {

        fly.get('/getFbByPaperId')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);

                var fbs=eval(json.fbs);



                if (fbs!=="null"){
                    var parent = document.getElementById("fbul");
                    parent.innerHTML=" ";


                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>"
                            + fbs[i].question  +"&nbsp;&nbsp;|&nbsp;&nbsp;正确答案: "+fbs[i].rightanswer+ "\n" +

                            " <a  class=\"secondary-content \"  onclick='getFbByPaperId();' target='iframe"  +
                            "'   href=\"/delsc?objectid=" + fbs[i].objectid + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
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

function getTofByPaperId() {


    setTimeout(function  sleep() {

        fly.get('/getTofByPaperId')
            .then(function (response) {
                console.log(JSON.stringify(response.data));
                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);

                var tofs=eval(json.tofs);



                if (tofs!=="null"){
                    var parent = document.getElementById("toful");
                    parent.innerHTML=" ";


                    for (var i = json.total-1 ; i>=0; i--) {
                        var li = document.createElement("li");
                        li.setAttribute("class", "collection-item");
                        li.innerHTML =
                            " <div>"
                            + tofs[i].question  +"&nbsp;&nbsp;|&nbsp;&nbsp;正确答案: "+tofs[i].rightanswer+ "\n" +

                            " <a  class=\"secondary-content \"  onclick='getTofByPaperId();' target='iframe"  +
                            "'   href=\"/delsc?objectid=" + tofs[i].objectid + "\">\n" +
                            " <i class=\"material-icons black-text\">&nbsp;clear &nbsp;</i>\n" +
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
