<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- topbar -->
<div class="topbar">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="full">
            <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
            <div class="logo_section">
                <a href="AdminServlet/index"><img class="img-responsive"
                                                  src="${pageContext.request.contextPath}/views/admin/images/logo/LogoNew.png"
                                                  alt="#"/></a>
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
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                <c:choose>
                                    <c:when test="${profile_list.avatar == null}">
                                        <img class="img-responsive"
                                             src="${pageContext.request.contextPath}/uploads/user_img.jpg" alt="#"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img class="img-responsive"
                                             src="${pageContext.request.contextPath}/uploads/${profile_list.avatar}"
                                             alt="#"/>
                                    </c:otherwise>
                                </c:choose>
                                <span class="name_user">
                                <c:choose>
                                    <c:when test="${profile_list.fullName == null}">Username</c:when>
                                    <c:otherwise>${profile_list.fullName}</c:otherwise>
                                </c:choose>
                                </span>
                                <span class="font-weight-lighter">
                                    <c:choose>
                                        <c:when test="${profile_list.role == true}">Admin</c:when>
                                        <c:when test="${profile_list.role == false}">User</c:when>
                                    </c:choose>
                                </span>
                            </a>
                            <div class="dropdown-menu">
                                <c:choose>
                                    <c:when test="${profile_list.username != null}">
                                        <a class="dropdown-item" href="AdminServlet/profile" id="profile">My Profile</a>
                                        <hr>
                                        <a class="dropdown-item" href="">Settings</a>
                                        <a class="dropdown-item" href="">Help</a>
                                        <a class="dropdown-item" href="AdminServlet/logout"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                                    </c:when>
                                    <c:when test="${profile_list.username == null}">
                                        <a class="dropdown-item" href="LoginControlServlet">Login</a>
                                        <hr>
                                        <a class="dropdown-item" data-toggle="modal" data-target="#elegantModalForm2">Register</a>
                                    </c:when>
                                </c:choose>

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
<jsp:include page="../ManagerUser/modal.jsp"/>
