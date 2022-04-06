<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/31/2022
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-bordered table-hover  table-responsive">
    <thead class="table-dark">
    <tr>
        <th>Username</th>
        <th>FullName</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone Number</th>
        <th>Gender</th>
        <th>Birth Day</th>
        <th>Role</th>
        <th>Avatar</th>
        <th>Status</th>
        <th colspan="2">Manipulation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUsers}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.fullName}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.phone}</td>
            <td>
                <c:choose>
                    <c:when test="${user.gender == true}">Male</c:when>
                    <c:when test="${user.gender == false}">Female</c:when>
                    <c:otherwise>---</c:otherwise>
                </c:choose>
            </td>
            <td>${user.birth}</td>
            <td>
                <c:choose>
                    <c:when test="${user.role == true}">Manager</c:when>
                    <c:when test="${user.role == false}">User</c:when>
                    <c:otherwise>---</c:otherwise>
                </c:choose>
            </td>
                <%--            <td>${user.created}</td>--%>
            <td><img src="uploads/${user.avatar}" class="img-thumbnail rounded" width="100px" height="100px"
                     alt=""></td>
            <td>
                <c:choose>
                    <c:when test="${user.status == true}">Online</c:when>
                    <c:when test="${user.status == false}">Offline</c:when>
                    <c:otherwise>---</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="AdminServlet/editUser?id=${user.id}"
                   class="btn btn-outline-secondary fw-bold">Edit</a>
            </td>
            <td>
                <a href="AdminServlet/deleteUser?id=${user.id}"
                   class="btn btn-outline-danger fw-bold">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>