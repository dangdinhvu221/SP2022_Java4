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
    <table class="table table-bordered table-hove sortable">
        <div class="row">
            <button class="btn btn-info col-2 m-5" data-toggle="modal" data-target="#myModalCreateCategory">Create
            </button>
        </div>
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name Category</th>
            <th>User_id</th>
            <th colspan="2">Manipulation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ListCategory}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nameCategory}</td>
                <td>${item.user_id}</td>
                <td>
                    <a href="CategoryServlet/editCategory?id=${item.id}"
                       class="btn btn-outline-secondary fw-bold btn-block" data-toggle="modal"
                       data-target="#myModalEditCategory_editCategory?id=${item.id}">Edit</a>
                </td>
                <td>
                    <button type="button"
                            class="btn btn-outline-danger fw-bold btn-block" id="deleteUser" onclick="alertWarningDelete(${item.id})">
                        Delete
                    </button>
                </td>
            </tr>
            <script>
                var alertWarningDelete = document.querySelector("#deleteUser");
                alertWarningDelete = function (id) {
                    Swal.fire({
                        title: 'Warning?',
                        text: "Do you want to delete this Category?!",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#dd3333',
                        confirmButtonText: '<a href="CategoryServlet/deleteCategory?id='+id+'" class = "text-light">Yes, Delete it!</a>'
                    })
                }
            </script>
            <%--Modal-Edit--%>
            <div class="modal fade" id="myModalEditCategory_editCategory?id=${item.id}" tabindex="-1" role="dialog" aria-labelledby="myModal"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="container">
                        <div class="modal-content form-elegant">
                            <div class="modal-header text-center bg-info">
                                <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModal">
                                    <strong> Category Update
                                        <img src="${pageContext.request.contextPath}/views/admin/images/logo/iconload.gif" alt="" width="10%"/>
                                    </strong>
                                </h3>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="modal-body mx-4" action="CategoryServlet" method="post">
                                <div class="md-form mb-5">
                                    <div class="form-group">
                                        <label for="nameCategory1">Name Category:</label>
                                        <input type="text" class="form-control" value="${item.nameCategory}" name="nameCategory" id="nameCategory1" aria-describedby="helpId"
                                               placeholder=""
                                               required/>
                                    </div>
                                </div>
                                <div class="md-form">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control"  name="user_id" value="${item.user_id}" id="user_id" aria-describedby="helpId"
                                               placeholder=""
                                               required/>
                                    </div>
                                </div>
                                <div class="text-center mb-3">
                                    <button formaction="CategoryServlet/updateCategory?id=${item.id}" class="btn btn-info btn-block btn-rounded z-depth-1a">
                                        Update Category
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
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