
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
                document.getElementById("idicon").className ="red-text material-icons prefix";

                document.getElementById("registerbtn").disabled=true;

            }
            else {
                var userid=document.getElementById("idlable").innerText="学号";
                document.getElementById("registerbtn").disabled=false;
            }


            })
        .catch(function (error) {  })

}



function LoginCheckPW() {

    var userid=document.getElementById("userid");
    var password=document.getElementById("password");


    fly.get('/home?userid='+userid.value+'&password='+password.value)
        .then(
            function (response) {

                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                if (json.code===1){
                    document.getElementById("pwicon").className ="red-text material-icons prefix";
                    document.getElementById("pwlable").innerText="密码错误";
                    document.getElementById("loginbtn").disabled=true;
                }
                else if (json.code===2) {
                    document.getElementById("pwicon").className ="red-text material-icons prefix";
                    document.getElementById("pwlable").innerText="该学号未注册";
                    document.getElementById("loginbtn").disabled=true;
                }
                else {
                    document.getElementById("pwicon").className =" material-icons prefix";
                    document.getElementById("pwlable").innerText="密码";
                    document.getElementById("loginbtn").disabled=false;
                }


            }

            ).catch(
                function (reason) {


                }
            )

}
function LoginCheckUserId() {

    var userid=document.getElementById("userid");
    var password=document.getElementById("password");


    fly.get('/home?userid='+userid.value+'&password='+password.value)
        .then(
            function (response) {

                var text= JSON.stringify(response.data);
                var json = JSON.parse(text);
                if (json.code===2) {
                    document.getElementById("idicon").className ="red-text material-icons prefix";
                    document.getElementById("idlable").innerText="该学号未注册";
                    document.getElementById("loginbtn").disabled=true;
                }
                else {
                    document.getElementById("idicon").className =" material-icons prefix";
                    document.getElementById("idlable").innerText="学号";
                    document.getElementById("loginbtn").disabled=false;
                }


            }

        ).catch(
        function (reason) {


        }
    )

}