

function getAll() {
    var  scnum=document.getElementById("scform").getElementsByTagName("div").length;
    var  fbnum=  document.getElementById("fbform").getElementsByTagName("div").length;
    var  tofnum = document.getElementById("tofform").getElementsByTagName("div").length;


    getScAnswer(scnum);
    getFbAnswer(fbnum/2);
    getTofAnswer(tofnum);



}


function getScAnswer(scnum)
{

    for (var num=0;num<scnum;num++){


        var arr=document.getElementsByName("scradio"+num);
        for(var i=0;i<arr.length;i++)
        {
            if(arr[i].checked)
            {
                console.log(arr[i].value);


            }
        }

    }

}


function getFbAnswer (fbnum) {

    for (var num=0;num<fbnum;num++){

        var arr=document.getElementById("fbinput"+num);
        console.log(arr.value);

    }




}


function getTofAnswer(tofnum) {
    for (var num=0;num<tofnum;num++){

        var arr=document.getElementsByName("tofradio"+num);
        for(var i=0;i<arr.length;i++)
        {
            if(arr[i].checked)
            {
                console.log(arr[i].value);

            }
        }
    }



}