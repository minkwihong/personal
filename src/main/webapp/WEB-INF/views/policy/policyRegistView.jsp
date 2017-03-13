<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Policy Regist</title>
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
				<h1>PolicyRegist</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">PolicyRegist</li>
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
								<form id="registForm" name="registForm" class="form-horizontal" data-parsley-validate>
										<div class="form-group">
											<label for="name" class="col-sm-2 control-label">name</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="name" name="name"  placeholder="name">
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


								<input type="hidden" id="isDupl" name="isDupl" value="false">
								</form>
							</div>
							 
							<div class="box-footer clearfix">

								<button id="cancel"  class="btn btn-default">Cancel</button>
                				<button id="regist"  class="btn btn-info pull-right">regist</button>
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
			var policyService = new commonService();

			$("#regist").click(function(){
                policyService.regist( getContextPath(),"policy" ,"registForm");
		 	});

            $("#dup").click(function(){

				if($("#name").val() == '' || $("#name").val() == null){
					alert('정책이름 필수입력 사항입니다.')
				    return;
				}
                policyService.duplCheck( getContextPath() , "policy" ,"name");
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
		        alert(" [ "+ $("#name").val() + " ] "+" 는 등록 가능한 정책 입니다.");
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

