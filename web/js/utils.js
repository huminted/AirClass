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

    //
    // var elem3 = document.querySelector('.dropdown-content');
    // var instance = M.Dropdown.init(elem3,4);



}


function initIndex() {

    var elem = document.querySelector('.tabs');
    var instance = M.Tabs.init(elem, 4);




}