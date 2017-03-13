<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Admin List</title>
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
				<h1>AdminInfo</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Admin</a></li>
					<li class="active">AdminInfo</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">KSignAccess Admin</h3>
							</div>
							<div class="box-body">
								<form id="modifyForm" name="modifyForm" class="form-horizontal">
								<div class="form-group">
										<label for="userId" class="col-sm-2 control-label">userID</label>
											<div class="col-sm-10">
												<input readOnly type="text" class="form-control" id="userId" name="userId"  placeholder="userId">
											</div>
										</div>
										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="name" name="name" placeholder="name">
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-2 control-label">password</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="password" name="password" placeholder="password">
											</div>
										</div>
										
										<div class="form-group">
											<label for="allowedIp" class="col-sm-2 control-label">allowedIp</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="allowedIp" name="allowedIp" placeholder="allowedIp">
											</div>
										</div>
										
										<div class="form-group">
											<label for="certDn" class="col-sm-2 control-label">title</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="title" name="title" placeholder="title">
											</div>
										</div>
										
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">email</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="email" name="email" placeholder="email">
											</div>
										</div>
										
										<div class="form-group">
											<label for="mobile" class="col-sm-2 control-label">mobile</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="mobile" name="mobile" placeholder="mobile">
											</div>
										</div>
										
										<div class="form-group">
											<label for="description" class="col-sm-2 control-label">description</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" id="description" name="description" placeholder="description">
											</div>
										</div>
								</form>
							</div>
							 
							<div class="box-footer clearfix">
								<button id="cancel" type="button" class="btn btn-default">Cancel</button>
                				<button id="modified" type="button" class="btn btn-info pull-right">modified</button>
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
		var userId = '${x}';

		$(document).ready(function() {
			setApiUrl("/api");

			var adminService = new commonService();
			var obj ={
			    context : "/admin",
				methodId : "adminInfo",
				callBackFnc : "initSucess",
				keyName : "userId",
                keyValue : userId
			}
            adminService.search(obj);

		 	$("#modified").click(function(){
                adminService.modify("/admin","admin","modifyForm");
		 	}); 
		 	
		 	$("#cancel").click(function(){
				history.back();
		 	}); 
		});

		function initSucess(result) {
		    $("#userId").val(result.userId);
			$("#name").val(result.name);
			$("#title").val(result.title);
			$("#allowedIp").val(result.allowedIp);
			$("#email").val(result.email);
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

