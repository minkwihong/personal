<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp" %>

  <title>KSignAccess | Log in</title>

</head>

<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>KSignAccess </b>Admin
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

    <form id="loginForm" action="/login.ajax" method="post" data-parsley-validate >
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="adminId" placeholder="adminId" data-parsley-required="true"  data-parsley-trigger="change">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" id="passwd" placeholder="Password" data-parsley-required="true"  data-parsley-trigger="change">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" name="remember-me" id="remember-me"> Remember Me
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="loginBtn" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

<!--     <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
        Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
        Google+</a>
    </div> -->
    <!-- /.social-auth-links -->

    <!--<a href="#">I forgot my password</a><br>-->
    <a href="/main/" class="text-center">Register a new membership</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->



<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/util.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<script src="http://cdn.jsdelivr.net/parsleyjs/2.0.0-rc4/parsley.min.js"></script>
<script>
$(document).ready(function() {

    $('#loginForm').parsley();
    $("#adminId").focus();
    $("#passwd").keyup(function(event){
        if(event.keyCode == 13){
            $("#loginBtn").click();
        }
    });
	$("#loginBtn").click(function() {

		$.ajax({
			url : '${pageContext.request.contextPath}/login.ajax',
			type : 'POST',
			data : 'adminId=' + $("#adminId").val() + '&passwd='
					+ $("#passwd").val() + '&remember-me='
					+ $('#remember-me').is(':checked'),
			success : function(msg, status, xhr) {
				var json = $.parseJSON(xhr.responseText);

				var result = json.result;
				if (result == "success") {
					top.location.href = json.returnUrl;
				} else {
					alert(json.message);
				}
			},
			error : function(data) {
				alert("서버 응답이 지연되고 있습니다. 관리자에게 문의 하세요.");
			}
		});
	});
});


  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
