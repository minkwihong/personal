<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | Server Regist</title>
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
				<h1>ServerRegist</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">ServerRegist</li>
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
								<form id="registForm" name="registForm" class="form-horizontal" data-parsley-validate>
										<div class="form-group">
											<label for="serverName" class="col-sm-2 control-label">serverName</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" id="serverName" name="serverName"  placeholder="serverName">
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
												<input type="ip" class="form-control" id="ip" name="ip" placeholder="ip">
											</div>
										</div>

										<div class="form-group">
											<label for="port" class="col-sm-2 control-label">port</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="port" name="port" placeholder="port">
											</div>
										</div>

										<div class="form-group">
											<label for="url" class="col-sm-2 control-label">title</label>
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
											<label for="mobile" class="col-sm-2 control-label">mobile</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="mobile" name="mobile" placeholder="mobile">
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

								<input type="hidden" id="isDupl" name="isDupl" value="false">
								</form>
							</div>
							 
							<div class="box-footer clearfix">

								<button id="cancel" type="submit" class="btn btn-default">Cancel</button>
                				<button id="regist" type="submit" class="btn btn-info pull-right">regist</button>
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

			var serverService = new commonService();
			$("#regist").click(function(){
                serverService.regist( getContextPath(),"server" ,"registForm");
		 	});

            $("#dup").click(function(){
                if($('#serverName').val() == '' || $('#serverName').val() == null){
                    alert('서버이름을 입력해주세요')
                    return;
				}
                serverService.duplCheck( getContextPath(),"server" ,"serverName");
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
		        alert(" [ "+ $("#serverName").val() + " ] "+" 는 등록 가능한 서버 입니다.");
                $("#isDupl").val("true");
            }else{
                alert("중복된 서버입니다.");
                return;
			}

		};

        function duplError(){
            alert('서버 응답이 지연되고 있습니다. 관리자에게 문의 하세요.')
        };
		
	</script>
</body>
</html>

