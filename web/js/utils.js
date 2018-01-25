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