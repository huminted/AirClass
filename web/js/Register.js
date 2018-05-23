
var fly=require(['../js/fly.js','../js/require.js'],function  () {});

function Resister() {



    var userid=document.getElementById('userid');



    fly.get('/checkUserid?userid='+userid.value)
        .then(function (response) {
            var text= JSON.stringify(response.data);
            var json = JSON.parse(text);
            console.log(json.msg);

            if (json.code===0){
                alert(json.msg);
                var userid=document.getElementById("idlable").innerText="该用户已经存在";

                document.getElementById("registerbtn").disabled=true;

            }
            else {
                var userid=document.getElementById("idlable").innerText="学号";
                document.getElementById("registerbtn").disabled=false;
            }


            })
        .catch(function (error) {  })

}
