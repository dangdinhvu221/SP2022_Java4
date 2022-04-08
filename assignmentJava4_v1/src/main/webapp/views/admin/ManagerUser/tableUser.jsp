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
<div class="row">
    <div class="col-lg-8"></div>
    <!-- Another variation with a button -->
    <div class="input-group col-lg-4 mb-4">
        <label>
            <input type="text" oninput="searchByName(this)" class="form-control" name="search"
                   placeholder="Search this blog">
        </label>
        <div class="input-group-append">
            <button type="button" class="btn btn-secondary">
                <i class="fa fa-search"></i>
            </button>
        </div>
    </div>
</div>
<div class=" table-responsive">
    <table class="table table-bordered table-hover sortable">
        <thead class="table-dark">
        <tr>
            <th>Username</th>
            <th>FullName</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Gender</th>
            <th>Created</th>
            <th>Role</th>
            <th>Avatar</th>
            <th>Status</th>
            <th colspan="2">Manipulation</th>
        </tr>
        </thead>
        <tbody id="content">
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
                <td>${user.created}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.role == true}">Admin</c:when>
                        <c:when test="${user.role == false}">User</c:when>
                        <c:otherwise>---</c:otherwise>
                    </c:choose>
                </td>
                    <%--            <td>${user.created}</td>--%>
                <td><img src="uploads/${user.avatar}" class="img-thumbnail rounded" width="50px" height="50px"
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
                    <button type="button" formaction="AdminServlet/deleteUser?id=${user.id}"
                            class="btn btn-outline-danger fw-bold " id="deleteUser"
                            onclick="alertWarningDelete(${user.id})">
                        Delete
                    </button>
                </td>
            </tr>
            <script>
                var alertWarningDelete = document.querySelector("#deleteUser");
                alertWarningDelete = function (id) {
                    Swal.fire({
                        title: 'Warning?',
                        text: "Do you want to delete this user?!",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#dd3333',
                        confirmButtonText: '<a href="AdminServlet/deleteUser?id='+id+'" class = "text-light">Yes, Delete it!</a>'
                    })
                }
            </script>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function loadMore() {
        var amount = document.getElementsByClassName("product").length;
        $.ajax({
            url: "/Project_banhang/load",
            type: "get", //send it through get method
            data: {
                exits: amount
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    }

    function searchByName(param) {
        let txtSearch = param.value;
        $.ajax({
            url: "${pageContext.request.contextPath}/searchAjaxServlet",
            type: "get", //send it through get method
            data: {
                search: txtSearch
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    }
</script>