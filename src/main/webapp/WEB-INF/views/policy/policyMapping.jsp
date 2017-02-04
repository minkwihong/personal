<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/inc/meta.jsp"%>

	<title>KSignAccess | Admin List</title>
</head>
<%@ include file="/WEB-INF/views/inc/base_js.jsp"%>
<%--<script>
    $.jgrid.defaults.width = 780;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
</script>--%>
<body class="hold-transition skin-blue sidebar-mini sidebar-collapse">
<div class="wrapper">

	<%-- Main Header include --%>
	<%@ include file="/WEB-INF/views/inc/main_header.jsp"%>

	<%-- SideBar include --%>
	<%@ include file="/WEB-INF/views/inc/sideBar.jsp"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>PolicyMapping</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li class="active">PolicyMapping</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12" id="jqGridDiv1">
					<table id="jqGrid1"></table>
					<div id="Pager1"></div>
				</div>

				<div id="jqGridDiv2" class="col-md-3 col-sm-6 col-xs-12"  >
						<table id="jqGrid2"></table>
						<div id="Pager2"></div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12" id="jqGridDiv3">
					<table id="jqGrid3"></table>
					<div id="Pager3"></div>
				</div>


			</div>

			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12" id="jqGridDiv4">
					<table id="jqGrid4"></table>
					<div id="Pager4"></div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12" id="jqGridDiv5">
					<table id="jqGrid5"></table>
					<div id="Pager5"></div>
				</div>
			</div>

			<button id="locRegist" class="btn btn-info pull-right">좌표 저장</button>
		</section>
                <!-- /.content -->



	</div>

	<!-- /.content-wrapper -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>

</div>


<script>

	$(document).ready(function() {

		$('#locRegist').click(function(){
            var jsonObj= "";

            jsonObj = objLocation();

            setCookie("location" , jsonObj,1);

            alert('테이블 좌표가 저장되었습니다.')
        });

        setDragnDrop();

        jQuery("#jqGrid1").jqGrid({
            url : "/api/policy/policyGrpList",
            mtype : "GET",
            datatype: "JSON",
            jsonReader:{
                page :'page', // 페이징을 위한
                total:'total',
                root:'list' //
			},
            colNames: ['name', 'grpDesc'],
			colModel: [
                { label: 'name ', name: 'name',  width: 100 , key:true ,
                    searchoptions : { sopt:['cn']}
                },
                { label: 'grpDesc', name: 'grp_Desc', width: 100 }
            ],
            caption: '[정책그룹]',
            width: 300,
            height: 200,
            rowNum: 20,
            loadError: function(xhr, status, error){
                alert("정책그룹목록 에러발생 : "+xhr.responseText);
            },
           	/*onSelectRow: function(rowid, status, e) {
            	alert("asdf : " + rowid + "/" + status);
        	},*/
            onSelectRow: grpMappingView,
        pager: '#Pager1'
        });

        jQuery("#jqGrid3").jqGrid({
            url : "/api/policy/policyList",
            datatype: "json",
            mtype : "GET",
            width: 300,
            height: 200,
            rowNum: 20,
            jsonReader:{
                page :'page', // 페이징을 위한
                total:'total',
                root:'list' // map에 "list",list 넣으면 그 키값 써줘야 데이터 뿌려짐
			},
            colNames: ['name', 'polDesc'],
            colModel: [
                { label: 'name ', name: 'name',  width: 100 , key:true

                },
                { label: 'pol_Desc', name: 'polDesc', width: 100 }
            ],
            caption	: '[정책]',
			pager: '#Pager3'
        });

        $("#jqGrid3")
            .jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
            .jqGrid('setSelection', '3');

        jQuery("#jqGrid5").jqGrid({
            url : "/api/policy/userList",
            datatype: "json",
            mtype : "GET",
            width: 300,
            height: 200,
            rowNum: 20,
            jsonReader:{
                page :'page', // 페이징을 위한
                total:'total',
                root:'list' // map에 "list",list 넣으면 그 키값 써줘야 데이터 뿌려짐
            },
            colNames: ['userId','name'],
            colModel: [
                { label: 'userId ', name: 'userId',  width: 100 , key:true ,
                    searchoptions : { sopt:['cn']}
                },
                { label: 'name', name: 'name', width: 100 }
            ],
            caption: '[사용자]',
            pager: '#Pager5'
        });


		$('#jqGrid1').jqGrid('filterToolbar');

        $('#jqGrid1').jqGrid('navGrid',"#Pager1", {
            search: false,
            add: false,
            edit: false,
            del: false,
            refresh: true
        });

       	$('#jqGrid3').jqGrid('filterToolbar');

        $('#jqGrid3').jqGrid('navGrid',"#Pager3", {
            search: false,
            add: false,
            edit: false,
            del: false,
            refresh: true
        });

        $('#jqGrid5').jqGrid('filterToolbar');

        $('#jqGrid5').jqGrid('navGrid',"#Pager5", {
            search: false,
            add: false,
            edit: false,
            del: false,
            refresh: true
        });

		if(getCookie('location') != ''){
		 	setGridPosition();
		 }
	});

    function grpMappingView(rowid, status, e){
        $('#jqGridDiv2').empty();
		var a = $("<table>").attr("id", "jqGrid2");
        var b = $("<div>").attr("id", "Pager2");
		$("#jqGridDiv2").append(a);
        $("#jqGridDiv2").append(b);

		var paramObj ={
		    name : rowid
		};
		jQuery("#jqGrid2").jqGrid({
            url : "/api/policy/policyMappingList",
            mtype : "GET",
            datatype: "JSON",
			postData: {
                group_Name : encodeURIComponent(rowid)
			},
            jsonReader:{
                page :'page', // 페이징을 위한
                total:'total',
                root:'list'
            },
            colNames: ['grpName', 'policyName'],
            colModel: [
                { label: 'group_Name ', name: 'group_Name',  width: 100 , key:true ,
                    searchoptions : { sopt:['cn']}
                },
                { label: 'policy_Name', name: 'policy_Name', width: 100 }
            ],
            caption: '정책그룹매핑' + '[ ' + rowid + ' ] < - > 정책 ' ,
            width: 300,
            height: 200,
            rowNum: 20,
            gridview: true,
            loadError: function(xhr, status, error){
                alert("정책매핑목록 에러발생 : "+xhr.responseText);
            },
            loadComplete: function(){

                $('#jqGrid2').jqGrid('filterToolbar');

                $('#jqGrid2').jqGrid('navGrid',"#Pager2", {
                    search: false, // show search button on the toolbar
                    add: false,
                    edit: false,
                    del: false,
                    refresh: true
                });
                $('#jqGridDiv2').draggable();

                $("#jqGrid3").jqGrid('gridDnD',{
                    connectWith:"#jqGrid2",
                    ondrop : function(event, ui,getdata) {

                        $('#jqGrid3').trigger( 'reloadGrid' );
						setApiUrl("/api");
                        var paramObj ={
                            grpName : rowid,
                            policyName : $(ui.draggable).attr("id")
						}

                        handlePost("/policy/registPolicyMapp",paramObj,function(){
                            $('#jqGrid2').trigger( 'reloadGrid' );
						});

                    }
                });
			},
            pager: '#Pager2'
		})

//===========================================================================================

        $('#jqGridDiv4').empty();
        var a = $("<table>").attr("id", "jqGrid4");
        var b = $("<div>").attr("id", "Pager4");
        $("#jqGridDiv4").append(a);
        $("#jqGridDiv4").append(b);

        var paramObj ={
            name : rowid
        };
        jQuery("#jqGrid4").jqGrid({
            url : "/api/policy/userGrpMappingList",
            mtype : "GET",
            datatype: "JSON",
            postData: {
                name :  rowid
            },
            jsonReader:{
                page :'page', // 페이징을 위한
                total:'total',
                root:'list'
            },
            colNames: ['name', 'userId'],
            colModel: [
                { label: 'name ', name: 'name',  width: 100 , key:true ,
                    searchoptions : { sopt:['cn']}
                },
                { label: 'user_id', name: 'user_id', width: 100 }
            ],
            caption: '정책그룹매핑' + '[ ' + rowid + ' ] < - > 사용자' ,
            width: 300,
            height: 200,
            rowNum: 20,
            gridview: true,
            loadError: function(xhr, status, error){
                alert("정책그룹매핑목록 에러발생 : "+xhr.responseText);
            },
            loadComplete: function(){

                $('#jqGrid4').jqGrid('filterToolbar',{defaultSearch:true,stringResult:true});

                $('#jqGrid4').jqGrid('navGrid',"#Pager4", {
                    search: false, // show search button on the toolbar
                    add: false,
                    edit: false,
                    del: false,
                    refresh: true
                });
                $('#jqGridDiv4').draggable();

                $("#jqGrid5").jqGrid('gridDnD',{
                    connectWith:"#jqGrid4",
                    ondrop : function(event, ui,getdata) {

                        $('#jqGrid5').trigger( 'reloadGrid' );
                        setApiUrl("/api");
                        var paramObj ={
                            name : rowid,
                            user_id : $(ui.draggable).attr("id")
                        }

                        handlePost("/policy/registPolicyGrpMapp",paramObj,function(){
                            $('#jqGrid4').trigger( 'reloadGrid' );
                        });

                    }
                });
            },
            pager: '#Pager4'
        })

	}

	function setGridPosition(){

        var location = getCookie("location");
        var result = JSON.parse(location);

        $( "div[id*='jqGridDiv']" ).each(function (index, item) {
           	var left = result[$(item).attr("id")].left;
			var top = result[$(item).attr("id")].top;


            $("#" + $(item).attr("id")).offset({top: top, left: left});
        });
	}

	function setDragnDrop(){
		$('#jqGridDiv1').draggable();
        $('#jqGridDiv3').draggable();
        $('#jqGridDiv4').draggable();
        $('#jqGridDiv5').draggable();
    }




</script>
</body>
</html>

