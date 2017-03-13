<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
    $(document).ready(function(){

        var policyService = new commonService();
        var obj={
            context : "/policy",
            methodId : "policyList",
            callBackFnc : "initSucess"
        }

        policyService.search(obj);

    })

    function initSucess(result){
        var objList = result.list;
        var html = "";
        html = "<div class='row'>" ;


        for(var i = 0 ; i<objList.length ; i ++){
            html += '<div class="col-md-4">';
            html += '<div class="form-group">';
            html += '<label>';
            html += '<input type="checkbox" class="flat-red" >' + '&nbsp;' + '&nbsp;';
            html += objList[i].name;
            html += '<label>';
            html += '</div>';
            html += '</div>';
        }
        html += "</div>" ;

        $('.modal-body').html(html);
    };
</script>
<!-- header -->
<div class="modal-header">
    <!-- 닫기(x) 버튼 -->
    <button type="button" class="close" data-dismiss="modal">×</button>
    <!-- header title -->
    <h4 class="modal-title">사용자별 접근정책리스트</h4>
</div>
<!-- body -->
<div class="modal-body">

</div>
<!-- Footer -->
<div class="modal-footer">
    <button type="button" class="btn btn-default" >SAVE</button>
    <button type="button" class="btn btn-default" data-dismiss="modal">CLOSE</button>
</div>


