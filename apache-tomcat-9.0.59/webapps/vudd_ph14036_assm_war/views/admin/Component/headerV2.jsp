<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- topbar -->
<div class="topbar">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="full">
            <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
            <div class="logo_section">
                <a href="AdminServlet/index"><img class="img-responsive" src="${pageContext.request.contextPath}/images/logo/LogoNew.png" alt="#" /></a>
            </div>
            <div class="right_topbar">
                <div class="icon_info">
                    <ul>
                        <li><a href="#"><i class="fa fa-bell-o"></i><span class="badge">2</span></a></li>
                        <li><a href="#"><i class="fa fa-question-circle"></i></a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i><span class="badge">3</span></a></li>
                    </ul>
                    <ul class="user_profile_dd">
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown"><img class="img-responsive rounded-circle" src="${pageContext.request.contextPath}/images/layout_img/user_img.jpg" alt="#" /><span class="name_user">John David</span></a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" data-toggle="modal" data-target="#elegantModalForm">Login</a>
                                <a class="dropdown-item" data-toggle="modal" data-target="#elegantModalForm2">Register</a>
                                <hr>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/profile.jsp">My Profile</a>
                                <a class="dropdown-item" href="settings.html">Settings</a>
                                <a class="dropdown-item" href="help.html">Help</a>
                                <a class="dropdown-item" href="#"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
<!-- end topbar -->
<%--Modal--%>
<%@include file="../ManagerUser/modalLogin.jsp"%>
<%@include file="../ManagerUser/modalSignUp.jsp"%>
