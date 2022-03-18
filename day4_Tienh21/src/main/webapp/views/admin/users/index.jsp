<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/16/2022
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<c:if test="${ empty ds}">
    <p class="alert alert-warning">
        Không có dữ liệu !!!
    </p>
</c:if>

<c:if test="${ !empty ds}">
    <table class="table table-striped table-bordered table-hover ">
        <thead>
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ ds }" var="user">

            <tr>
                <th>#</th>
                <td>${user.fullname}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.gender == true }">Nam</c:when>
                        <c:when test="${user.gender == false }">Nữ</c:when>
                        <c:otherwise>---</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

