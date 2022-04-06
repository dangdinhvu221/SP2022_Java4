<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Sidebar  -->
<nav id="sidebar">
    <div class="sidebar_blog_1">
        <div class="sidebar-header">
            <div class="logo_section">
                <a href="../../../index.jsp"><img class="logo_icon img-responsive" src="${pageContext.request.contextPath}/images/logo/logo_icon.png" alt="#" /></a>
            </div>
        </div>
        <div class="sidebar_user_info">
            <div class="icon_setting"></div>
            <div class="user_profle_side">
                <div class="user_img"><img class="img-responsive" src="${pageContext.request.contextPath}/images/layout_img/user_img.jpg" alt="#" /></div>
                <div class="user_info">
                    <h6>John David</h6>
                    <p><span class="online_animation"></span> Online</p>
                </div>
            </div>
        </div>
    </div>
    <div class="sidebar_blog_2">
        <h4>General</h4>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="AdminServlet/index" ><i class="fa fa-dashboard yellow_color"></i> <span>Home Dashboard</span></a>
            </li>
            <li>
                <a href="#tables" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-table purple_color2"></i> <span>Tables</span></a>
                <ul class="collapse list-unstyled" id="tables">
                    <li>
                        <a href="AdminServlet/adminUser"> <span>Admin Users</span></a>
                    </li>
                    <li>
                    </li>
                </ul>
            </li>
            <li>
                <a href="contact.html">
                    <i class="fa fa-paper-plane red_color"></i> <span>Contact</span></a>
            </li>
            <li><a href="map.html"><i class="fa fa-map purple_color2"></i> <span>Map</span></a></li>
            <li><a href="charts.html"><i class="fa fa-bar-chart-o green_color"></i> <span>Charts</span></a></li>
            <li><a href="settings.html"><i class="fa fa-cog yellow_color"></i> <span>Settings</span></a></li>
        </ul>
    </div>
</nav>
<!-- end sidebar -->