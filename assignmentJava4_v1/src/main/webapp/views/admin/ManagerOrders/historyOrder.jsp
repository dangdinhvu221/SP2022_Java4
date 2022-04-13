<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/7/2022
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col">
        <c:if test="${not empty sessionScope.message}">
            <script>
                Swal.fire({
                    icon: "success",
                    title: "SuccessFully!",
                    text: "${sessionScope.message}",
                    showConfirmButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 1600,
                });
            </script>
            <c:remove var="message" scope="session"/>
        </c:if>
        <c:if test="${not empty sessionScope.error}">
            <script>
                Swal.fire({
                    icon: 'error',
                    title: 'ERROR!',
                    text: '${sessionScope.error}',
                })
            </script>
            <c:remove var="error" scope="session"/>
        </c:if>
    </div>
</div>
<div id="page">
    <div class="breadcrumbs">
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="bread"><span><a href="index.html">Home</a></span> / <span>Shopping Checkout</span></p>
                </div>
            </div>
        </div>
    </div>

    <div class="colorlib-product">
        <div class="container">
            <div class="row row-pb-lg">
                <div class="col-md-12">
                    <div class="product-name d-flex">
                        <div class="one-eight text-center">
                            <span>ID</span>
                        </div>
                        <div class="one-forth text-left ">
                            <span class="ml-5">Name</span>
                        </div>
                        <div class="one-forth text-left ml-2">
                            <span class="ml-5">Image</span>
                        </div>
                        <div class="one-forth text-left ml-5">
                            <span class="ml-3">Color</span>
                        </div>
                        <div class="one-forth text-left">
                            <span class="ml-4">Size</span>
                        </div>
                        <div class="one-forth text-left">
                            <span class="ml-4">Price</span>
                        </div>
                        <div class="one-eight text-left">
                            <span>Quantity</span>
                        </div>
                        <div class="one-forth text-center">
                            <span class="ml-4">Total</span>
                        </div>
                        <div class="one-forth text-center">
                            <span class="ml-4">Status</span>
                        </div>
                        <div class="one-forth text-center">
                            <span>Remove</span>
                        </div>
                    </div>
                    <c:forEach items="${list_history}" var="item">
                        <div class="product-cart d-flex">
                            <div class="one-eight text-center pr-5">
                                <div class="display-tc">
                                    <h3>${item.o_id}</h3>
                                </div>
                                <div class="display-tc">
                                    <h3>${item.nameProduct}</h3>
                                </div>
                            </div>
                            <div class="one-eight text-center ml-5">
                                <div class="display-tc ml-5">
                                    <div class="product-img"
                                         style="background-image: url(${pageContext.request.contextPath}/uploads/${item.imageProduct});">
                                    </div>
                                </div>
                            </div>

                            <div class="one-eight text-center ml-2">
                                <div class="display-tc">
                                    <h3>${item.color}</h3>
                                </div>
                            </div>

                            <div class="one-eight text-center ml-5">
                                <div class="display-tc">
                                    <h3>${item.size}</h3>
                                </div>
                            </div>
                            <div class="one-eight text-center ml-5">
                                <div class="display-tc">
                                    <h3>${item.price}$</h3>
                                </div>
                            </div>
                            <div class="one-eight text-center ml-5">
                                <div class="display-tc">
                                    <input type="text" id="quantity" name="quantity"
                                           class="form-control input-number text-center" disabled
                                           value="${item.o_quantity}" min="1" max="100">
                                </div>
                            </div>
                            <div class="one-eight text-center ml-4">
                                <div class="display-tc">
                                    <span class="price">${item.total}$</span>
                                </div>
                            </div>
                            <div class="one-eight text-center ml-5">
                                <div class="display-tc">
                                    <span class="price">
                                        <c:choose>
                                            <c:when test="${item.status == 1}">Chờ xác nhận</c:when>
                                            <c:when test="${item.status == 2}">Chờ lấy hàng</c:when>
                                            <c:when test="${item.status == 3}">Hoàn tất</c:when>
                                            <c:when test="${item.status == 4}">Huỷ đơn hàng</c:when>
                                            <c:otherwise>--</c:otherwise>
                                        </c:choose>
                                    </span>
                                </div>
                            </div>
                            <div class="one-eight text-center ml-4">
                                <div class="display-tc">
                                    <a id="deleteUser" onclick="alertWarningDelete(${item.o_id})" type="button" class="closed"></a>
                                </div>
                            </div>
                        </div>
                        <script>
                            var alertWarningDelete = document.querySelector("#deleteUser");
                            alertWarningDelete = function (id) {
                                Swal.fire({
                                    title: 'Warning?',
                                    text: "Do you want to delete this Order?!",
                                    icon: 'warning',
                                    showCancelButton: true,
                                    confirmButtonColor: '#3085d6',
                                    cancelButtonColor: '#dd3333',
                                    confirmButtonText: '<a href="CheckoutProductServlet/remove?id='+id+'" class = "text-light">Yes, Delete it!</a>'
                                })
                            }
                        </script>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
