function showdiv(obj) {

    var element=document.getElementById(obj);
    element.setAttribute("style","display: inline;");

}

function closediv(obj) {
    var element=document.getElementById(obj);

    element.setAttribute("style","display: none;");
}

function showloadingdialog(obj) {

    var element=document.getElementById(obj);
    element.setAttribute("style","display: inline;");

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


}

function showToast(text) {

    M.toast({html: text})


}


function  setBadge(id,text) {

    var badge=document.getElementById(id);
    badge.setAttribute("data-badge-caption",text);

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