/*
util.js
 */

/*
 Null 체크 함수
 */
function isNull(s){
    var o = s ;
    if(s == null){
        o = "";
    }else if(s == ""){
        o = "";
    }else if(typeof s == "undefined"){
        o = "";
    }else{
        o = s;
    }

    return o;
}

/*
 serializeObject custom
 */
$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });

    return o;
};

/*
 contextPath get 함수
 */
function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
/*
 list 여부
 */
function isList(s) {
    if(s.indexOf("List") > -1){return true}else {return false}
}
/*
  table obj div 좌표 get 함수
 */
function  objLocation(){

    var jsonObj = new Object();
    var totalInfo = new Object();
    var jsonStr = new Object();

    $( "div[id*='jqGridDiv']" ).each(function (index, item) {
        jsonObj = new Object();
        var div = $(item).attr("id");
        var divX = $("#" + div).offset().left;
        var divY = $("#" + div).offset().top;

        jsonObj.left = divX;
        jsonObj.top = divY;

        totalInfo[div] = jsonObj;
    });

    jsonStr = JSON.stringify(totalInfo);

    return jsonStr;
}

