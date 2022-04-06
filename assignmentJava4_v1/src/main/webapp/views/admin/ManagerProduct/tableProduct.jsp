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
<div class=" table-responsive">
    <table class="table table-bordered table-hover sortable">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Color</th>
            <th>Size</th>
            <th>Image</th>
            <th>Created</th>
            <th colspan="2">Manipulation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ListProducts}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nameProduct}</td>
                <td>${item.quantity}</td>
                <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${item.price}"/> </td>
                <td>${item.color}</td>
                <td>${item.size}</td>
                <td><img src="${pageContext.request.contextPath}/uploads/${item.imageProduct}" class="img-thumbnail rounded" width="50px" height="50px"
                         alt=""></td>
                <td>${item.created}</td>

                <td>
                    <a href="ProductServlet/editProduct?id=${item.id}"
                       class="btn btn-outline-secondary fw-bold">Edit</a>
                </td>
                <td>
                    <button
                            class="btn btn-outline-danger fw-bold " id="deleteUser" onclick="alertWarningDelete()">
                        Delete
                    </button>
                </td>
            </tr>
            <script>
                var alertWarningDelete = document.querySelector("#deleteUser");
                alertWarningDelete = function () {
                    Swal.fire({
                        title: 'Warning?',
                        text: "Do you want to delete this user?!",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#dd3333',
                        confirmButtonText: '<a href="ProductServlet/deleteProduct?id=${item.id}" class = "text-light">Yes, Delete it!</a>'
                    })
                }
            </script>
        </c:forEach>
        </tbody>
    </table>
</div>