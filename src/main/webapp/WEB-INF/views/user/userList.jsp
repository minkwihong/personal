<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp"%>
<title>KSignAccess | User List</title>
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
				<h1>UserList</h1>
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
								<h3 class="box-title">KSignAccess User List</h3>
							</div>
							<div class="box-body">
							<form class="form-search" id="f">
									<input type="hidden" id="curPage" value="1">
									<input type="hidden" id="sortType" value="userId" data-sorttype="desc">

									<div class="row">
										<div class="col-xs-3 col-sm-3">
											<div class="input-group input-group-sm">
												<input type="text" class="form-control" id="s_value" name="s_value" placeholder="userId">
												<span class="input-group-btn">
                      								<button type="button" id="s_btn" class="btn btn-info btn-flat">search</button>
                    								</span>
											</div>
										</div>
									</div>
								</form>
								<br>
								<div class="table-header">
									<span id="count">0</span> results (<span id="curPageNo">1</span>/<span id="maxPageNo">1</span> page)
								</div>
								<table class="table table-striped table-bordered table-hover" id="listTable">
									<thead>
										<tr>
											<th>#</th>
											<th>userId <i class="fa fa-sort-desc" id="userIdSort" data-value="desc"></i></th>
											<th>name</th>
											<th>passwordReset</th>
											<th>oudn</th>
											<th>title</th>
											<th>lastLoginTime</th>
											<th>policy</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>

							<div class="box-footer clearfix">
								<button id="regist" type="submit" class="btn btn-info pull-right">regist</button>
								<div class="text-center" style="width: 100%; padding-left: 66px;">
									<ul class="pagination" id="listPagination">
									</ul>
								</div>
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
        var userService = new commonService();
        var obj={
            context : getContextPath(),
            methodId : "userList",
            callBackFnc : "initSucess"
        }

		$(document).ready(function() {
			setApiUrl("/api");

			userService.search(obj);

			$("#userIdSort").click(function() {
				var sort = $("#userIdSort").attr("data-value");
				if (sort == "desc") {
					sort = "asc";
					$("#userIdSort").removeClass("fa-sort-desc");
					$("#userIdSort").addClass("fa-sort-asc");
				} else {
					sort = "desc";
					$("#userIdSort").addClass("fa-sort-desc");
					$("#userIdSort").removeClass("fa-sort-asc");
				}

				$("#userIdSort").removeAttr("data-value");
				$("#userIdSort").attr("data-value", sort);

				$("#sortType").val("userId");
				$("#sortType").attr("data-sorttype", sort);

                userService.search(obj);
			});
			
			$("#regist").click(function(){
				registView();
			});

            $("#s_btn").click(function(){
                userService.search(obj);
            });

		});

		function movePage(pageNo) {
			$("#curPage").val(pageNo);
            userService.search(obj);
		}

		function initSucess(result) {
			var count = result.count;
			var objList = result.list;

			var curPage = parseInt($("#curPage").val());
			var s_value = $("#s_value").val();

			var maxPage = Math.max(Math.floor((count + pageSize - 1) / pageSize), 1);
			var begPage = Math.max(curPage - 4, 1);
			var endPage = Math.min(curPage + 4 + (4 - (curPage - begPage)),	maxPage);

			var prevPage = Math.max(begPage - 1, 1);
			var nextPage = Math.min(endPage + 1, maxPage);

			var idx_b = count - (curPage - 1) * pageSize;

			$("#count").text(count);
			$("#curPageNo").text(curPage);
			$("#maxPageNo").text(maxPage);

			
			var t_rows = "";
			for (var i = 0; i < objList.length; i++) {
				//var auditOid = _highlight(objList[i].auditOid, "", "orange");
				var userId = _highlight(_omit(objList[i].userId, 40), "", "orange");
				var title = isNull(objList[i].title) ;
				var a_link = "userModifyView.do?x="
						+ encodeURI(encodeURIComponent(objList[i].userId));

				var t_row = "<tr>\n" + "  <td>" + (idx_b--) + "</td>\n" +

				"  <td><a href='" + a_link + "'>" + objList[i].userId	+ "</a></td>\n" +
				"  <td><a href='" + a_link + "'>" + isNull(objList[i].name) + "</a></td>\n" +
				"  <td>" + isNull(objList[i].passwordReset)	+ "</td>\n" +
				"  <td>" + isNull(objList[i].oudn) + "</td>\n" +
				"  <td>" + title + "</td>\n" + 
				"  <td>" + isNull(objList[i].lastLoginTime) + "</td>\n" +
				"  <td><button type='button' class= 'btn btn-default'> <i class='fa fa-align-right'></i></button></td>\n" +
				"</tr>\n";
				t_rows += t_row;
			}

			$("#listTable tbody").remove();
			$("#listTable").append("<tbody>\n" + t_rows + "</tbody>\n");

			var p_rows = "";
			if (curPage == 1) {
				p_rows += "<li class='disabled'><a>&laquo;</a></li>";
			} else {
				p_rows += "<li><a href='javascript:movePage(" + prevPage
						+ ")'>&laquo;</a></li>";
			}
			for (var page_i = begPage; page_i <= endPage; page_i++) {
				if (page_i == curPage) {
					p_rows += "<li class='active'><a>" + page_i + "</a></li>\n";
				} else {
					p_rows += "<li><a href='javascript:movePage(" + page_i
							+ ")'>" + page_i + "</a></li>\n";
				}
			}
			if (curPage == maxPage) {
				p_rows += "<li class='disabled'><a>&raquo;</a></li>";
			} else {
				p_rows += "<li><a href='javascript:movePage(" + nextPage
						+ ")'>&raquo;</a></li>";
			}

			$("#listPagination li").remove();
			$("#listPagination").html(p_rows);
		}
		
		function registView() {
			var a_link = "userRegistView.do";
			
			location.href = a_link;
		}
	</script>
</body>
</html>

