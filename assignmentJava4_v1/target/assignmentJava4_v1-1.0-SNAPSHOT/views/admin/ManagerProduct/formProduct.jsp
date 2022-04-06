<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/31/2022
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
    <nav class="mt-5">
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab"
               aria-controls="nav-home" aria-selected="true">User Editing</a>
            <a class="nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
               aria-controls="nav-profile" aria-selected="false">User List</a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
             aria-labelledby="nav-home-tab">
            <form action="ProductServlet" method="post" enctype="multipart/form-data">
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
                <div class="row">
                    <div class="form-group col-lg-12">
                        <label for="nameProduct">Name Product</label>
                        <input type="text" name="nameProduct" id="nameProduct" class="form-control"
                               placeholder="" aria-describedby="helpId112">
                        <small id="helpId112" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-12">
                        <label for="title">Title</label>
                        <input type="text" name="title" id="title" class="form-control"
                               placeholder="" aria-describedby="helpId1">
                        <small id="helpId11" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="category_id">Category</label>
                        <select class="form-control" name="category_id" id="category_id">
                            <c:forEach var="item" items="${ListCategory}">
                                <option value="${item.id}">${item.nameCategory}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="supplier_id">Supplier</label>
                        <select class="form-control" name="supplier_id" id="supplier_id">
                            <c:forEach var="i" items="${ListSupplier}">
                                <option value="${i.id}">${i.nameSupplier}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="quantity">Quantity</label>
                        <input type="number" name="quantity" id="quantity" class="form-control"
                               placeholder="" aria-describedby="helpId4" min="0">
                        <small id="helpId4" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="price">Price</label>
                        <input type="text" name="price" id="price" class="form-control" placeholder=""
                               aria-describedby="helpId5">
                        <small id="helpId5" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="color">Color</label>
                        <input type="text" name="color" id="color" class="form-control" placeholder=""
                               aria-describedby="helpId8">
                        <small id="helpId8" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="size">Size</label>
                        <input type="text" name="size" id="size" class="form-control"
                               placeholder="" aria-describedby="helpId6">
                        <small id="helpId6" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="description">Description</label>
                        <textarea class="form-control" name="description" id="description" rows="3"></textarea>
                    </div>
                    <div class="input-group mb-3 col-lg-6">
                        <label class="input-group-text" for="imageProduct">Image: </label>
                        <input name="imageProduct" type="file" class="form-control"
                               id="imageProduct">
                    </div>
                </div>
                <div class="d-flex justify-content-around row">
                    <button formaction="ProductServlet/createProduct" class="btn btn-outline-success btn-block">Create
                    </button>
                    <button type="reset" class="btn btn-outline-info btn-block">Reset</button>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <jsp:include page="${tableProduct}"/>
        </div>
    </div>
</div>
<!-- end dashboard inner -->