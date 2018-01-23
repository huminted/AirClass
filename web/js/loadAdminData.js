
var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {

    fly.get('/alldoc')
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
                        " <div>" + json[i].filename +"  |  "+json[i].username +"\n" +



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




    fly.get('/allscore')
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
                        " <div>" + json[i].papertitle +"  |  "+json[i].username+"\n" +


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


});




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
                        " <div>" + json[i].papertitle +"  |  "+json[i].username+"\n" +


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




function getScoreByPaperId() {

    fly.get('/getscorebypaperid')
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);


            if (json!==""){

                var parent = document.getElementById("gradesul");
                parent.innerHTML=" ";

                for (var i = 0; i <json.length; i++) {


                    var li = document.createElement("li");
                    li.setAttribute("class", "collection-item");
                    li.innerHTML =
                        " <div>" + json[i].papertitle +"  |  "+json[i].username+"\n" +


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