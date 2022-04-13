<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Sidebar -->
<nav id="sidebar">
    <div class="sidebar_blog_1">
        <div class="sidebar-header">
            <div class="logo_section">
                <a href="AdminServlet/index"><img class="logo_icon img-responsive"
                                                  src="${pageContext.request.contextPath}/views/admin/images/logo/logo_icon.png"
                                                  alt="#"/></a>
            </div>
        </div>
        <div class="sidebar_user_info">
            <div class="icon_setting"></div>
            <div class="user_profle_side">
                <div class="user_img">
                    <c:choose>
                        <c:when test="${users.avatar == null}">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/uploads/user_img.jpg"
                                 alt="#"/>
                        </c:when>
                        <c:otherwise>
                            <img class="img-responsive" src="${pageContext.request.contextPath}/uploads/${users.avatar}"
                                 alt="#"/>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="user_info">
                    <h6>
                        <c:choose>
                            <c:when test="${users.fullName == null}">Username</c:when>
                            <c:otherwise>${users.fullName}</c:otherwise>
                        </c:choose>
                    </h6>
                    <p>
                        <c:choose>
                            <c:when test="${users.status == null}">
                                <span class="text-secondary">Offline</span>
                            </c:when>
                            <c:otherwise>
                                <span class="online_animation"></span>Online
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="sidebar_blog_2">
        <h4>General</h4>
        <ul class="list-unstyled components">
            <li class="active">
                <a href="AdminServlet/index"><i class="fa fa-home yellow_color"></i> <span>Home Dashboard</span></a>
            </li>
            <li>
                <a href="#tables" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                        class="fa fa-table purple_color2"></i> <span>Manage</span></a>
                <ul class="collapse list-unstyled" id="tables">
                    <li>
                        <a href="AdminServlet/adminUser"> <span><i class="fa fa-user-circle-o" aria-hidden="true"></i> Manager Users</span></a>
                    </li>
                    <li>
                        <a href="#tables1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"> <span>Product</span></a>
                        <ul class="collapse list-unstyled" id="tables1">
                            <li>
                                <a href="ProductServlet"> <span>Manager Product</span></a>
                            </li>
                            <li>
                                <a href="CategoryServlet"> <span>Manager Category</span></a>
                            </li>
                            <li>
                                <a href="SupplierServlet"> <span>Manager Supplier</span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="OrderControlServlet"> <span><i class="fa fa-user-circle-o" aria-hidden="true"></i> Manager Orders</span></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="contact.html">
                    <i class="fa fa-paper-plane red_color"></i> <span>Contact</span></a>
            </li>
            <li><a href=""><i class="fa fa-map purple_color2"></i> <span>Map</span></a></li>
            <li><a href=""><i class="fa fa-bar-chart-o green_color"></i> <span>Charts</span></a></li>
            <li><a href=""><i class="fa fa-cog yellow_color"></i> <span>Settings</span></a></li>
        </ul>
    </div>
</nav>
<!-- end sidebar -->