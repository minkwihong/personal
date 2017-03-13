<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
          <a href="${pageContext.request.contextPath}/main/main.do">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
          </a>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-file-text-o"></i>
            <span>AccessLog</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/audit/auditList.do"><i class="fa fa-circle-o"></i> KAAudit</a></li>
<!--             <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li> -->
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-users"></i>
            <span>Identity</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/user/userList.do"><i class="fa fa-circle-o"></i> KAUser</a></li>
<!--             <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li> -->
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-television"></i>
            <span>Admin</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/admin/adminList.do"><i class="fa fa-circle-o"></i> KAAdmin</a></li>
                         <%--<li><a href="/admin/serverList.do"><i class="fa fa-circle-o"></i> KAServer</a></li>--%>
            <!--           <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
                       <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li> -->
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Session</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/login/loginList.do"><i class="fa fa-circle-o"></i> CurrentAccessUser</a></li>
            <!--             <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
                        <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
                        <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li> -->
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-book"></i>
            <span>Policy</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li>
              <a href="#"><i class="fa fa-circle-o"></i> AccessPolicy
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="${pageContext.request.contextPath}/policy/policyGrpList.do"><i class="fa fa-circle-o"></i> AccessPolicyGrp</a></li>
                <li><a href="${pageContext.request.contextPath}/policy/policyList.do"><i class="fa fa-circle-o"></i> AccessPolicy</a></li>
                <li><a href="${pageContext.request.contextPath}/policy/policyMapping.do"><i class="fa fa-circle-o"></i> AccessPolicyMapping</a></li>
              </ul>
            </li>
            <li>
              <a href="#"><i class="fa fa-circle-o"></i> PwPolicy
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> PwPolicy</a></li>
              </ul>
            </li>
          </ul>
        </li>

      </ul>
      
    </section>
    <!-- /.sidebar -->
  </aside>