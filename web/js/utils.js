function showdiv(obj) {

    var element=document.getElementById(obj);
    element.setAttribute("style","display: inline;");

}

function closediv(obj) {
    var element=document.getElementById(obj);

    element.setAttribute("style","display: none;");
}









function initAdmin() {
    var elem = document.querySelector('.tabs');
    var instance = M.Tabs.init(elem, 4);


    var elem2 = document.querySelector('.collapsible');
    var instance2 = M.Collapsible.init(elem2,4);



    var elem3 = document.querySelectorAll('.dropdown-trigger');
    var instance3 = M.Dropdown.init(elem3, 10);




}








function initIndex() {




    var elem = document.querySelector('.tabs');
    var instance = M.Tabs.init(elem, 4);

    var elem2 = document.querySelector('.dropdown-trigger');
    var instance2 = M.Dropdown.init(elem2, 10);

    var elem3 = document.querySelectorAll('.collapsible');
    var instance3 = M.Collapsible.init(elem3,4);

    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('.tap-target');
        var instances = M.TapTarget.init(elems, options);
        var instance = M.TapTarget.getInstance(elem);
        instance.next();
    });


}

function showToast(text) {

    M.toast({html: text})


}


function  setBadge(id,text) {

    var badge=document.getElementById(id);
    badge.setAttribute("data-badge-caption",text);

}

document.getElementById("navusername").innerText=getCookie("username");
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

    if(arr=document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}




function reUlSize(total,min,id) {

    if (total<=min){

        var item=document.getElementById(id);

        var reSizediv = document.createElement("div");
        reSizediv.setAttribute("class","ResizeContainer");

        item.appendChild(reSizediv);
    }

}

function reSize(total,min,id) {

    if (total>0&&total<=min){

        var item=document.getElementById(id);

        var reSizediv = document.createElement("div");
        reSizediv.setAttribute("class","ResizeContainer");

        item.appendChild(reSizediv);
    }

}


function setEmpty(total,id,html) {

    if (total===0){

        var itemPaper=document.getElementById(id);

        var loadingdiv = document.createElement("div");
        loadingdiv.setAttribute("class","container2");
        loadingdiv.innerHTML=html;

        itemPaper.appendChild(loadingdiv);
    }
    
}

function unLock(){


    document.getElementById("genpaper").disabled=false;

    document.getElementById("inputrow").style.display="inline";

    var collapsibleBody =document.getElementById("collapsible-body");

    var child=document.getElementById("lockdiv");

    collapsibleBody.removeChild(child);
    setBadge("genpaperbadge","新增试卷后再出题");



}

function ScoreChart(id,label,subjectArray,scoreArray) {

    var colorArray=[];
    var borderColorArray=[];

    for (var i=0;i<scoreArray.length;i++){


        var r=Math.floor(Math.random()*255);
        var g=Math.floor(Math.random()*255);
        var b=Math.floor(Math.random()*255);

        colorArray[i]='rgba('+ r+','+ g+','+b+','+0.2+')';

        borderColorArray[i]='rgba('+ r+','+ g+','+b+','+1+')';

    }

    this.show=function () {





        document.getElementById("chartContainter").innerHTML='&nbsp;';
        document.getElementById("chartContainter").innerHTML='<canvas id="scorechart" style="padding-top: 20px" ></canvas>';



        require(['../js/Chart.min.js'], function(Chart){

            var ctx = document.getElementById(id).getContext("2d");



            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels:subjectArray,
                    datasets: [{
                        label: label,
                        data: scoreArray,
                        backgroundColor: colorArray,
                        borderColor: borderColorArray,
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero:true
                            }
                        }]
                    }


                }
            });

        });


    }


}


