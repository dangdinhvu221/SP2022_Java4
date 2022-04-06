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
    <div class="col">
        <c:if test="${not empty message}">
            <script>
                Swal.fire({
                    icon: "success",
                    title: "SuccessFully!",
                    text: "${message}",
                    showConfirmButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 1600,
                });
            </script>
        </c:if>
        <c:if test="${not empty error}">
            <script>
                Swal.fire({
                    icon: 'error',
                    title: 'ERROR!',
                    text: '${error}',
                })
            </script>
        </c:if>
    </div>
</div>

<div class=" table-responsive">
    <table class="table table-bordered table-hover sortable">
        <div class="row">
            <button formaction="" class="btn btn-info col-2 m-5" data-toggle="modal"
                    data-target="#myModalCreateSupplier">Create
            </button>
        </div>
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name Supplier</th>
            <th>Phone</th>
            <th>Address</th>
            <th colspan="2">Manipulation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ListSupplier}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nameSupplier}</td>
                <td>${item.phone}</td>
                <td>${item.address}</td>
                <td>
                    <a href="SupplierServlet/editSupplier?id=${item.id}"
                       class="btn btn-outline-secondary fw-bold" data-toggle="modal"
                       data-target="#myModalEditSupplier_editSupplier?id=${item.id}">Edit</a>
                </td>
                <td>
                    <button type="button"
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
                        confirmButtonText: '<a href="SupplierServlet/deleteSupplier?id=${item.id}" class = "text-light">Yes, Delete it!</a>'
                    })
                }
            </script>
            <div class="modal fade" id="myModalEditSupplier_editSupplier?id=${item.id}" tabindex="-1" role="dialog"
                 aria-labelledby="myModal"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content form-elegant">
                        <div class="modal-header text-center bg-info">
                            <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModal">
                                <strong> Supplier Edit
                                    <img src="${pageContext.request.contextPath}/views/admin/images/logo/iconload.gif"
                                         alt="" width="10%"/>
                                </strong>
                            </h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form class="modal-body mx-4" action="#" method="post">
                            <div class="md-form mb-5">
                                <div class="form-group">
                                    <label for="nameSupplier">Name Supplier:</label>
                                    <input type="text" class="form-control" name="nameSupplier" id="nameSupplier"
                                           aria-describedby="helpId"
                                           placeholder="" value="${item.nameSupplier}"
                                           required/>
                                </div>
                            </div>
                            <div class="md-form mb-5">
                                <div class="form-group">
                                    <label for="phone">Phone:</label>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                           aria-describedby="helpId"
                                           placeholder="" value="${item.phone}"
                                           required/>
                                </div>
                            </div>
                            <div class="md-form mb-5">
                                <div class="form-group">
                                    <label for="address">Address:</label>
                                    <input type="text" class="form-control" name="address" id="address"
                                           aria-describedby="helpId"
                                           placeholder="" value="${item.address}"
                                           required/>
                                </div>
                            </div>
                            <div class="text-center mb-3">
                                <button class="btn btn-info btn-block btn-rounded z-depth-1a"
                                        formaction="SupplierServlet/updateSupplier?id=${item.id}">
                                    Update
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </c:forEach>
        </tbody>
    </table>
</div>
