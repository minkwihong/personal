<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Admin Regist</title>
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
				<h1>AdminRegist</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Admin</a></li>
					<li class="active">AdminList</li>
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
								<form id="registForm" name="registForm" class="form-horizontal" data-parsley-validate>
										<div class="form-group">
											<label for="userID" class="col-sm-2 control-label">userID</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" id="userId" name="userId"  placeholder="userID">
											</div>
										</div>

										<div class="form-group">
											<label for="password" class="col-sm-2 control-label">password</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="password" name="password" placeholder="password">
											</div>
										</div>

										<div class="form-group">
											<label for="passwordReset" class="col-sm-2 control-label">passwordReset</label>
											<div class="col-sm-10">
												<input type="passwordReset" class="form-control" id="passwordReset" name="passwordReset" placeholder="password">
											</div>
										</div>

										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="name" name="name" placeholder="name">
											</div>
										</div>

										<div class="form-group">
											<label for="title" class="col-sm-2 control-label">title</label>
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
										
]										<div class="form-group">
											<label for="oudn" class="col-sm-2 control-label">oudn</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="oudn" name="oudn" placeholder="oudn">
											</div>
										</div>
										
										<div class="form-group">
											<label for="description" class="col-sm-2 control-label">description</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="description" name="description" placeholder="description">
											</div>
										</div>

										<div class="form-group">
											<label for="description" class="col-sm-2 control-label">description</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="deactivated" name="deactivated" placeholder="deactivated">
											</div>
										</div>

								<input type="hidden" id="isDupl" name="isDupl" value="false">
								</form>
							</div>
							 
							<div class="box-footer clearfix">

								<button id="cancel" type="button" class="btn btn-default">Cancel</button>
                				<button id="regist" type="button" class="btn btn-info pull-right">regist</button>
								<button id="dup" type="button" class="btn btn-danger">dup</button>
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

		$(document).ready(function() {
			setApiUrl("/api");

			var adminService = new commonService();

			$("#regist").click(function(){
                adminService.regist( getContextPath(),"admin" ,"registForm");
		 	});

            $("#dup").click(function(){
				adminService.duplCheck( getContextPath() , "admin" ,"userId");
            });

            $("#cancel").click(function(){
				history.back();
		 	}); 
		});

		/*
		 callback 함수
		 */
		function registSuccess(result) {
			alert('사용자 정보 저장 되었습니다.')
			location.href = result.retUrl;
		}
		
		function registError(result) {
			alert('서버 응답이 지연되고 있습니다. 관리자에게 문의 하세요.')
		}

		function duplSuccess(result){
		    if(result.result <= 0){
		        alert(" [ "+ $("#userId").val() + " ] "+" 는 등록 가능한 아이디 입니다.");
                $("#isDupl").val("true");
            }else{
                alert("중복된 아이디입니다.");
                return;
			}

		};

        function duplError(){
            alert('서버 응답이 지연되고 있습니다. 관리자에게 문의 하세요.')
        };
		
	</script>
</body>
</html>

