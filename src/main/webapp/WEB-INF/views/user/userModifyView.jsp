<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | User Info</title>
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
				<h1>UserInfo</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Identity</a></li>
					<li class="active">KAUser</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">KSignAccess User</h3>
							</div>
							<div class="box-body">
								<form id="modifyForm" name="modifyForm" class="form-horizontal">
								<div class="form-group">
										<label for="inputEmail3" class="col-sm-2 control-label">userID</label>
											<div class="col-sm-10">
												<input readOnly type="text" class="form-control" id="userId" name="userId"  placeholder="Email">
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="name" name="name" placeholder="Email">
											</div>
										</div>
										<div class="form-group">
											<label for="certDn" class="col-sm-2 control-label">title</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="title" name="title" placeholder="">
											</div>
										</div>
										
										<div class="form-group">
											<label for="certDn" class="col-sm-2 control-label">certDn</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="certDn" name="certDn" placeholder="">
											</div>
										</div>
										
										<div class="form-group">
											<label for="certDn" class="col-sm-2 control-label">oudn</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="oudn" name="oudn" placeholder="">
											</div>
										</div>
										
										<div class="form-group">
											<label for="lastLoginTime" class="col-sm-2 control-label">lastLoginTime</label>
											<div class="col-sm-10">
												<input disabled type="text" class="form-control" id="lastLoginTime" name="lastLoginTime" placeholder="">
											</div>
										</div>
										
										<div class="form-group">
											<label for="certDn" class="col-sm-2 control-label">description</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="description" name="description" placeholder="">
											</div>
										</div>
										
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

											<div class="col-sm-10">
												<input type="password" class="form-control" id="inputPassword3" value="" placeholder="Password">
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox"> Remember me
													</label>
												</div>
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
		var userId = '${x}';
		
		$(document).ready(function() {
			setApiUrl("/api");

			var userService = new commonService();
            var obj ={
                context : getContextPath(),
                methodId : "userInfo",
                callBackFnc : "initSucess",
                keyName : "userId",
                keyValue : userId
            }
            userService.search(obj);
			
		 	$("#modified").click(function(){
                userService.modify(getContextPath(), "user", "modifyForm");
		 	}); 
		 	
		 	$("#cancel").click(function(){
				history.back();
		 	}); 
		});

		function initSucess(result) {
			$("#userId").val(result.userId);
			$("#name").val(result.name);
			
			$("#title").val(result.title);
			$("#certDn").val(result.certDn);
			$("#oudn").val(result.u_oudn);
			$("#description").val(result.description);
			$("#lastLoginTime").val(result.lastLoginTime);
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

