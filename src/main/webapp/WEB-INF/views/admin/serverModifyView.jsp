<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Server List</title>
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
				<h1>ServerList</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">ServerList</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">KSignAccess Server</h3>
							</div>
							<div class="box-body">
								<form id="modifyForm" name="modifyForm" class="form-horizontal">
								<div class="form-group">
										<label for="serverName" class="col-sm-2 control-label">serverName</label>
											<div class="col-sm-10">
												<input readOnly type="text" class="form-control" id="serverName" name="serverName"  placeholder="serverName">
											</div>
										</div>
										<div class="form-group">
											<label for="type" class="col-sm-2 control-label">type</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="type" name="type" placeholder="type">
											</div>
										</div>
										<div class="form-group">
											<label for="ip" class="col-sm-2 control-label">ip</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="ip" name="ip" placeholder="ip">
											</div>
										</div>
										
										<div class="form-group">
											<label for="port" class="col-sm-2 control-label">port</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="port" name="port" placeholder="port">
											</div>
										</div>
										
										<div class="form-group">
											<label for="url" class="col-sm-2 control-label">url</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="url" name="url" placeholder="url">
											</div>
										</div>
										
										<div class="form-group">
											<label for="gid" class="col-sm-2 control-label">gid</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="gid" name="gid" placeholder="gid">
											</div>
										</div>
										
										<div class="form-group">
											<label for="certdn" class="col-sm-2 control-label">certdn</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="certdn" name="certdn" placeholder="certdn">
											</div>
										</div>
										
										<div class="form-group">
											<label for="usableAgent" class="col-sm-2 control-label">usableAgent</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="usableAgent" name="usableAgent" placeholder="usableAgent">
											</div>
										</div>

										<div class="form-group">
											<label for="modDate" class="col-sm-2 control-label">modDate</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="modDate" name="modDate" placeholder="modDate">
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
		var serverName = '${x}';

		$(document).ready(function() {
			setApiUrl("/api");
            var obj ={
                context : getContextPath(),
                methodId : "serverInfo",
                callBackFnc : "initSucess",
                keyName : "serverName",
                keyValue : serverName
            }
			var serverService = new commonService();
            serverService.search( obj);
			
		 	$("#modified").click(function(){
		 	    serverService.modify(getContextPath(),"server","modifyForm");
		 	}); 
		 	
		 	$("#cancel").click(function(){
				history.back();
		 	}); 
		});

		function initSucess(result) {
		    $("#serverName").val(result.serverName);
			$("#type").val(result.type);
			$("#ip").val(result.ip);
			$("#port").val(result.port);
			$("#url").val(result.url);
			$("#gid").val(result.gid);
			$("#certdn").val(result.certdn);
            $("#usableAgent").val(result.usableAgent);
            $("#modDate").val(result.modDate);
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

