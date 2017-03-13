<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/meta.jsp" %>
  <title>KSignAccess | DashBoard</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
 
 <%-- Main Header include --%>
 <%@ include file="/WEB-INF/views/inc/main_header.jsp" %>
  
 <%-- SideBar include --%>
 <%@ include file="/WEB-INF/views/inc/sideBar.jsp" %>




     <!-- Control Sidebar -->
     <aside class="control-sidebar control-sidebar-dark">
         <!-- Create the tabs -->
         <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
             <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
             <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
         </ul>
         <!-- Tab panes -->
         <div class="tab-content">
             <!-- Home tab content -->
             <div class="tab-pane" id="control-sidebar-home-tab">
                 <h3 class="control-sidebar-heading">Recent Activity</h3>
                 <ul class="control-sidebar-menu">
                     <li>
                         <a href="javascript:void(0)">
                             <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                             <div class="menu-info">
                                 <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                 <p>Will be 23 on April 24th</p>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <i class="menu-icon fa fa-user bg-yellow"></i>

                             <div class="menu-info">
                                 <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                 <p>New phone +1(800)555-1234</p>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                             <div class="menu-info">
                                 <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                 <p>nora@example.com</p>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <i class="menu-icon fa fa-file-code-o bg-green"></i>

                             <div class="menu-info">
                                 <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                 <p>Execution time 5 seconds</p>
                             </div>
                         </a>
                     </li>
                 </ul>
                 <!-- /.control-sidebar-menu -->

                 <h3 class="control-sidebar-heading">Tasks Progress</h3>
                 <ul class="control-sidebar-menu">
                     <li>
                         <a href="javascript:void(0)">
                             <h4 class="control-sidebar-subheading">
                                 Custom Template Design
                                 <span class="label label-danger pull-right">70%</span>
                             </h4>

                             <div class="progress progress-xxs">
                                 <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <h4 class="control-sidebar-subheading">
                                 Update Resume
                                 <span class="label label-success pull-right">95%</span>
                             </h4>

                             <div class="progress progress-xxs">
                                 <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <h4 class="control-sidebar-subheading">
                                 Laravel Integration
                                 <span class="label label-warning pull-right">50%</span>
                             </h4>

                             <div class="progress progress-xxs">
                                 <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                             </div>
                         </a>
                     </li>
                     <li>
                         <a href="javascript:void(0)">
                             <h4 class="control-sidebar-subheading">
                                 Back End Framework
                                 <span class="label label-primary pull-right">68%</span>
                             </h4>

                             <div class="progress progress-xxs">
                                 <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                             </div>
                         </a>
                     </li>
                 </ul>
                 <!-- /.control-sidebar-menu -->

             </div>
             <!-- /.tab-pane -->
             <!-- Stats tab content -->
             <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
             <!-- /.tab-pane -->
             <!-- Settings tab content -->
             <div class="tab-pane" id="control-sidebar-settings-tab">
                 <form method="post">
                     <h3 class="control-sidebar-heading">General Settings</h3>

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Report panel usage
                             <input type="checkbox" class="pull-right" checked>
                         </label>

                         <p>
                             Some information about this general settings option
                         </p>
                     </div>
                     <!-- /.form-group -->

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Allow mail redirect
                             <input type="checkbox" class="pull-right" checked>
                         </label>

                         <p>
                             Other sets of options are available
                         </p>
                     </div>
                     <!-- /.form-group -->

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Expose author name in posts
                             <input type="checkbox" class="pull-right" checked>
                         </label>

                         <p>
                             Allow the user to show his name in blog posts
                         </p>
                     </div>
                     <!-- /.form-group -->

                     <h3 class="control-sidebar-heading">Chat Settings</h3>

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Show me as online
                             <input type="checkbox" class="pull-right" checked>
                         </label>
                     </div>
                     <!-- /.form-group -->

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Turn off notifications
                             <input type="checkbox" class="pull-right">
                         </label>
                     </div>
                     <!-- /.form-group -->

                     <div class="form-group">
                         <label class="control-sidebar-subheading">
                             Delete chat history
                             <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                         </label>
                     </div>
                     <!-- /.form-group -->
                 </form>
             </div>
             <!-- /.tab-pane -->
         </div>
     </aside>
     <!-- /.control-sidebar -->
     <!-- Add the sidebar's background. This div must be placed
          immediately after the control sidebar -->
     <!-- Content Wrapper. Contains page content -->
     <div class="content-wrapper">
         <!-- Content Header (Page header) -->
         <section class="content-header">
             <h1>
                 Dashboard
                 <small>version 0.1</small>
             </h1>
             <ol class="breadcrumb">
                 <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                 <li><a href="#">Dashboard</a></li>

             </ol>
         </section>

         <!-- Main content -->
         <section class="content">

             <div class="row">
                 <div class="col-md-6">
                     <!-- AREA CHART -->
                     <div class="box box-primary">
                         <div class="box-header with-border">
                             <h3 class="box-title">연도 별 각 시스템 접속자 통계 </h3>

                             <div class="box-tools pull-right">
                                 <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                 </button>
                                 <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                             </div>
                         </div>
                         <div class="box-body chart-responsive">
                             <div class="chart" id="revenue-chart" style="height: 300px;"></div>
                         </div>
                         <!-- /.box-body -->
                     </div>
                     <!-- /.box -->

                     <!-- DONUT CHART -->


                 </div>
                 <!-- /.col (LEFT) -->
                 <div class="col-md-6">
                     <!-- LINE CHART -->
                     <div class="box box-danger">
                         <div class="box-header with-border">
                             <h3 class="box-title">시스템 별 총접속자수 통계</h3>

                             <div class="box-tools pull-right">
                                 <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                 </button>
                                 <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                             </div>
                         </div>
                         <div class="box-body chart-responsive">
                             <div class="chart" id="sales-chart" style="height: 300px; position: relative;"></div>
                         </div>
                         <!-- /.box-body -->
                     </div>
                     <!-- /.box -->


                 </div>
                 <!-- /.col (RIGHT) -->
             </div>
             <!-- /.row -->

         </section>
         <!-- /.content -->
     </div>
     <!-- /.content-wrapper -->
     <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
     <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->



<%@ include file="/WEB-INF/views/inc/base_js.jsp" %>
<script src="${pageContext.request.contextPath}/resources/plugins/chartjs/Chart.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/demo.js"></script>
<script>

$(document).ready(function() {
    setApiUrl("/api");
    var statisticService = new commonService();
    var donutObj = {
        context : "/statistic",
        methodId : "statisticDunutInfo",
        callBackFnc : "dunutSuccess"
    }
    var areaObj = {
        context : "/statistic",
        methodId : "statisticAreaInfo",
        callBackFnc : "areaSuccess"
    }
    statisticService.search(donutObj);
    statisticService.search(areaObj);

});

function dunutSuccess(result){
    var donut = new Morris.Donut({
        element: 'sales-chart',
        resize: true,
        colors: ["#3c8dbc", "#f56954", "#00a65a"],
        data: result.total,
        hideHover: 'auto'
    });
    //donut.setData(result.total);
}

function areaSuccess(result){
    // AREA CHART
    var area = new Morris.Area({
        element: 'revenue-chart',
        resize: true,
        data: result.total,
        xkey: 'Y',
        ykeys: result.agentList,
        labels: result.agentList,
        lineColors: ['#a0d0e0', '#3c8dbc'],
        hideHover: 'auto'
    });
    //area.setData(result.total);

}
</script>
</body>
</html>
