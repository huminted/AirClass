

var totalScore=0;
var flag=0;
function getAllAnswer() {
    var  scnum=document.getElementById("scform").getElementsByTagName("div").length;
    var  fbnum=  document.getElementById("fbform").getElementsByTagName("div").length;
    var  tofnum = document.getElementById("tofform").getElementsByTagName("div").length;



    getScAnswer(scnum);
    getFbAnswer(fbnum/2);
    getTofAnswer(tofnum);

    if (flag===3){
        genJson();
        showScore();
        clearScore();

    }else {
        alert("还有未完成的题目，禁止提交！");
    }
    clearScore();


}







function getScAnswer(scnum)
{
    var  ScJson ={"total" :scnum,"sc":[ ] };
    var  ScCheckedTotal=0;

    for (var num=0;num<scnum;num++){



        var arr=document.getElementsByName("scradio"+num);
        for(var i=0;i<arr.length;i++)
        {
            if(arr[i].checked)
            {
                console.log(arr[i].value);

                ScCheckedTotal++;


                ScJson["sc"].push({
                    "number":num,"answer":arr[i].value
                });


            }
        }


    }

    ScJson.total=ScCheckedTotal;
    checkSc(ScJson,ScRightAnswer);
}


var ScScore=0;
function checkSc(ScJson,ScRightAnswer) {



    if (ScJson.total === ScRightAnswer.total){


        for (var i=0;i<ScRightAnswer.total;i++){

            // alert("选择用户"+ScJson.sc[i].answer+" 和 标准答案"+ ScRightAnswer.sc[i].answer);

            if (ScJson.sc[i].answer == ScRightAnswer.sc[i].answer){

                ScScore+=1;


            }

        }

        // alert("选择题得分"+ScScore);
        totalScore+=ScScore;
        flag+=1;






    }else {

        alert("选择题还有未完成的题目");

        return false;


    }


}


function getFbAnswer (fbnum) {

    var  FbJson ={"total" :fbnum,"fb":[ ] };
    var  FbFilledTotal=0;



    for (var num=0;num<fbnum;num++){
        var arr=document.getElementById("fbinput"+num);



        if (arr.value!==""){
            console.log(arr.value);
            FbFilledTotal++;

            FbJson["fb"].push({

                "number":num,"answer":arr.value
            });

        }


    }

    FbJson.total=FbFilledTotal;
    checkFb(FbJson,FbRightAnswer);
}


var FbScore=0;
function checkFb (FbJson,FbRightAnswer) {

    if (FbJson.total === FbRightAnswer.total) {


        for (var i = 0; i < FbRightAnswer.total; i++) {

            // alert("填空用户 " + FbJson.fb[i].answer + " 和 标准答案" + FbRightAnswer.fb[i].answer);

            if (FbJson.fb[i].answer == FbRightAnswer.fb[i].answer) {

                FbScore += 1;


            }

        }

        // alert("填空" + FbScore);
        totalScore+=FbScore;
        flag+=1;



    }else {

        alert("填空题还有未完成的题目");
        return false;

    }

}


function getTofAnswer(tofnum) {

    var  TofJson ={"total" :tofnum,"tof":[ ] };
    var  TofCheckedTotal=0;

    for (var num=0;num<tofnum;num++){

        var arr=document.getElementsByName("tofradio"+num);
        for(var i=0;i<arr.length;i++)
        {
            if(arr[i].checked)
            {
                TofCheckedTotal++;
                console.log(arr[i].value);

                TofJson["tof"].push({
                    "number":num,"answer":arr[i].value

                });

            }
        }
    }
    TofJson.total=TofCheckedTotal;
    checkTof(TofJson,TofRightAnswer);


}

var TofScore=0;
function checkTof(TofJson,TofRightAnswer) {



    if (TofJson.total === TofRightAnswer.total){


        for (var i=0;i<TofRightAnswer.total;i++){

            // alert("判断用户"+TofJson.tof[i].answer+" 和 标准答案"+ TofRightAnswer.tof[i].answer);

            if (TofJson.tof[i].answer == TofRightAnswer.tof[i].answer){

                TofScore+=1;


            }

        }

        // alert("判断题得分"+TofScore);
        totalScore+=TofScore;
        flag+=1;



    }else {

        // alert("判断题还有未完成的题目");

        return false;


    }





}


var fly=require(['../js/fly.js','../js/require.js'],function Sendjson() {});

var  paperid=GetQueryString("paperid");
var  papertitle=decodeURI(GetQueryString("papertitle"));

function genJson() {


    var scoretext = {
        "score": totalScore,
        "detial":[]

    };
    scoretext["detial"].push({

        "paperid":paperid,
        "papertitle":papertitle,
        "singlechoice":ScScore,
        "fillblank":FbScore,
        "tof":TofScore



    });
    var newData = JSON.stringify(scoretext);


        fly.get('/addScore?scoretext='+encodeURI(newData))

            .then(function (response) {

                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                json=JSON.stringify(json.state);
                alert(json);



            })
            .catch(function (error) {
                console.log(error);
            });

        // alert("上传成功");
}


function clearScore() {

    ScScore=0;
    FbScore=0;
    TofScore=0;
    totalScore=0;
    flag=0;



}


function showScore() {

    var main=document.getElementById("main");

    main.innerHTML="\n" +
        "      <ul class=\"collection with-header\">\n" +
        "        <li class=\"collection-header\"><h4>恭喜您在"+papertitle+"获得"+totalScore+"分"+"</h4></li>\n" +
        "        <li class=\"collection-item\">单选题："+ScScore+"分 "+"</li>\n" +
        "        <li class=\"collection-item\">填空题："+FbScore+"分 "+"</li>\n" +
        "        <li class=\"collection-item\">判断题："+TofScore+"分"+"</li>\n" +
        "      </ul>";

}


