/*
공통 service js
 */

var commonService = function () {};

commonService.prototype.search = function (obj) {

    var context = obj.context;
    var methodId = obj.methodId;
    var callBackFnc = obj.callBackFnc;
    var keyName = obj.keyName;
    var keyValue = obj.keyValue;
    var order_by = $("#sortType").val();
    var sortType = $("#sortType").attr("data-sorttype");
    var paramObj = {};

    if(isList(methodId)){
        paramObj = {
            orderBy : order_by + " " + sortType, // using defualt
            pageSize : pageSize,
            pageNo : parseInt($("#curPage").val())
        }

        paramObj[order_by] = encodeURIComponent($("#s_value").val())
     }else{
        var key  = keyName ;
        paramObj = {};

        paramObj[key] = keyValue;
    }

    handleGet( context + "/" +methodId , paramObj, eval(callBackFnc), serviceError);
};

commonService.prototype.regist = function (context, serviceId ,formName) {

    var formName = "#" + formName;

    if($('#isDupl').val() == 'false'){
        alert('중복체크를 확인이 필요합니다.');
        return;
    };
    var paramObj = $(formName).serializeObject();

    handlePost( context + "/" + serviceId + "Regist", paramObj , registSuccess, serviceError);
};

commonService.prototype.modify = function (context, serviceId ,formName) {

    var formName = "#" + formName;
    var paramObj = $(formName).serializeObject();

    handlePatch( context + "/" + serviceId  + "Update", paramObj , modifySuccess, serviceError);
};

commonService.prototype.delete = function () {


};

commonService.prototype.duplCheck = function (context, serviceId ,keyname) {
    var key  = keyname ;
    var paramObj = {};

    paramObj[key] = $('#' + keyname).val()

    handleGet( context + "/" + serviceId + "DuplCheck", paramObj , duplSuccess , serviceError);

};



function serviceError(result){
    alert('code : ' + result.code + "msg : " + result.message);
}


