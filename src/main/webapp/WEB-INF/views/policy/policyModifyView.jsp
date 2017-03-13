<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Policy Info</title>
</head>
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
				<h1>PolicyInfo</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">PolicyInfo</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">KSignAccess Policy</h3>
							</div>
							<div class="box-body">
								<form id="modifyForm" name="modifyForm" class="form-horizontal">
								<div class="form-group">
										<label for="name" class="col-sm-2 control-label">name</label>
											<div class="col-sm-10">
												<input readOnly type="text" class="form-control" id="name" name="name"  placeholder="name">
											</div>
										</div>

										<div class="form-group">
											<label for="type" class="col-sm-2 control-label">type</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="type" name="type" placeholder="type">
											</div>
										</div>
										
										<div class="form-group">
											<label for="effect" class="col-sm-2 control-label">effect</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="effect" name="effect" placeholder="effect">
											</div>
										</div>
										
										<div class="form-group">
											<label for="rule" class="col-sm-2 control-label">rule</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="rule" name="rule" placeholder="rule">
											</div>
										</div>
										
										<div class="form-group">
											<label for="polDesc" class="col-sm-2 control-label">polDesc</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="polDesc" name="polDesc" placeholder="polDesc">
											</div>
										</div>

								</form>
							</div>
							 
							<div class="box-footer clearfix">
								<button id="cancel" type="submit" class="btn btn-default">Cancel</button>
								<button id="modified" type="submit" class="btn btn-info pull-right">modified</button>
							</div>
							
						</div>
					</div>
				</div>
				
				<!-- end row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	</div>

	<%@ include file="/WEB-INF/views/inc/base_js.jsp"%>
	<script>
		var pageSize = 20;
		var name = '${x}';

		$(document).ready(function() {
			setApiUrl("/api");
            var obj ={
                context : "/policy",
                methodId : "policyInfo",
                callBackFnc : "initSucess",
                keyName : "name",
                keyValue : name
            }

			var policyService = new commonService();
            policyService.search( obj);
			
		 	$("#modified").click(function(){
                policyService.modify("/policy","policy","modifyForm");
		 	}); 
		 	
		 	$("#cancel").click(function(){
				history.back();
		 	}); 
		});

		function initSucess(result) {
		    $("#name").val(result.name);
			$("#type").val(result.type);
			$("#effect").val(result.effect);
			$("#rule").val(result.rule);
			$("#polDesc").val(result.polDesc);
			$("#mobile").val(result.mobile);
			$("#description").val(result.description);
		}
		
		function modifySuccess(result) {
			alert('사용자 정보 수정이 되었습니다.')
			location.href = result.retUrl;
		}
		
		function modifyError(result) {
			alert('서버 응답이 지연되고 있습니다. 관리자에게 문의 하세요.')
		}
		
	</script>
</body>
</html>

