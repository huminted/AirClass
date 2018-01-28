/**
 * @return {boolean}
 */

function GetQueryString(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

var ScRightAnswer;
var FbRightAnswer;
var TofRightAnswer;




var fly=require(['../js/fly.js','../js/require.js'],function getVideo () {


    var paperid=GetQueryString("paperid");
    fly.get('/getOnePaper?paperid='+paperid)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);

            var sc=eval(json.sc);
            var fb=eval(json.fb);
            var tof=eval(json.tof);

            if (typeof(sc) !== "undefined"){

                ScRightAnswer ={"total" :json.scTotal,"sc":[ ] };

                for (var i = 0; i <json.scTotal; i++) {



                    var parent = document.getElementById("scform");
                    var div = document.createElement("div");

                    ScRightAnswer["sc"].push({ "number":i,"answer":sc[i].rightanswer});

                    //设置 div 属性，如 id
                    div.setAttribute("id", "sc"+i);
                    div.setAttribute("class","col s12");

                    div.innerHTML =
                        "<span>"+(i+1)+". "+sc[i].question+"</span>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input name=\"scradio"+ i+"\" type=\"radio\"  value=\""+sc[i].answer1 +"\"  />\n" +
                        "                            <span>"+sc[i].answer1+"</span>\n" +
                        "                        </label>\n" +
                        "                    </p>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input name=\"scradio"+i+"\" type=\"radio\" value=\""+sc[i].answer2 +"\"/>\n" +
                        "                            <span>"+ sc[i].answer2+"</span>\n" +
                        "                        </label>\n" +
                        "                    </p>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input  name=\"scradio"+i+"\" type=\"radio\" value=\""+sc[i].answer3 +"\" />\n" +
                        "                            <span>"+ sc[i].answer3+"</span>\n" +
                        "                        </label>\n" +
                        "                    </p>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input name=\"scradio"+i+"\" type=\"radio\"  value=\""+sc[i].answer4 +"\" />\n" +
                        "                            <span>"+ sc[i].answer4+"</span>\n" +
                        "                        </label>\n" +
                        "                    </p>";
                    parent.appendChild(div);
                }


            }

            if (typeof(fb) !== "undefined"){

                FbRightAnswer ={"total" :json.fbTotal,"fb":[ ] };

                for (var j = 0; j <json.fbTotal; j++) {

                    FbRightAnswer["fb"].push({ "number":j,"answer":fb[j].rightanswer});

                    var parent2 = document.getElementById("fbform");
                    var div2 = document.createElement("div");

                    //设置 div 属性，如 id
                    div2.setAttribute("id", "fb"+j);
                    div2.setAttribute("class","col s12");
                    div2.innerHTML=
                        "<span>"+(j+1)+". "+fb[j].question+" </span>\n" +
                        " <div class=\"input-field inline\">\n" +
                        "  <input id=\"fbinput"+j+"\" type=\"text\" class=\"validate\">\n" +
                        "  <label for=\"fbinput"+j+"\">答案填写在此处</label>\n" +
                        "</div>";


                    parent2.appendChild(div2);


                }

            }

            if (typeof(tof) !== "undefined"){


                TofRightAnswer={"total" :json.tofTotal,"tof":[ ] };

                for (var k = 0; k <json.tofTotal; k++) {

                    TofRightAnswer["tof"].push({ "number":k,"answer":tof[k].rightanswer});



                    var parent3 = document.getElementById("tofform");
                    var div3 = document.createElement("div");

                    //设置 div 属性，如 id
                    div3.setAttribute("id", "tof"+k);
                    div3.setAttribute("class","col s12");


                    div3.innerHTML=
                        " <span>"+(k+1) +". "+tof[k].question+"</span>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input name=\"tofradio"+k+"\" type=\"radio\" value='0' />\n" +
                        "                            <span>X</span>\n" +
                        "                        </label>\n" +
                        "                    </p>\n" +
                        "                    <p>\n" +
                        "                        <label>\n" +
                        "                            <input name=\"tofradio"+k+"\" type=\"radio\" value='1' />\n" +
                        "                            <span>✓</span>\n" +
                        "                        </label>\n" +
                        "                    </p>";


                    parent3.appendChild(div3);


                }

            }




        })
        .catch(function (error) {
            console.log(error);
        });


});

