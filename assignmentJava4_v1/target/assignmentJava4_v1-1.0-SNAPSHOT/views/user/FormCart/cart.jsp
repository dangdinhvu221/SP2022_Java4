<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/7/2022
  Time: 7:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="page">

    <div class="breadcrumbs">
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="bread"><span><a href="index.html">Home</a></span> / <span>Shopping Cart</span></p>
                </div>
            </div>
        </div>
    </div>

    <div class="colorlib-product">
        <div class="container">
            <div class="row row-pb-lg">
                <div class="col-md-12">
                    <div class="product-name d-flex">
                        <div class="one-forth text-left px-4">
                            <span>Product Details</span>
                        </div>
                        <div class="one-eight text-center">
                            <span>Price</span>
                        </div>
                        <div class="one-eight text-center">
                            <span>Quantity</span>
                        </div>
                        <div class="one-eight text-center">
                            <span>Total</span>
                        </div>
                        <div class="one-eight text-center px-4">
                            <span>Remove</span>
                        </div>
                    </div>
                    <c:forEach items="${list}" var="item">
                        <div class="product-cart d-flex">
                            <div class="one-forth">
                                <div class="product-img"
                                     style="background-image: url(${pageContext.request.contextPath}/uploads/${item.imageProduct});">
                                </div>
                                <div class="display-tc">
                                    <h3>${item.nameProduct}</h3>
                                </div>
                            </div>
                            <div class="one-eight text-center">
                                <div class="display-tc">
                                    <span class="price">${item.price}$</span>
                                </div>
                            </div>
                            <div class="one-eight text-center">
                                <div class="display-tc">
                                    <input type="text" id="quantity" name="quantity"
                                           class="form-control input-number text-center" value="${item.quantity}" min="1" max="100">
                                </div>
                            </div>
                            <div class="one-eight text-center">
                                <div class="display-tc">
                                    <span class="price">${total}$</span>
                                </div>
                            </div>
                            <div class="one-eight text-center">
                                <div class="display-tc">
                                    <a href="remove?id=${item.id}" class="closed"></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="row row-pb-lg">
                <div class="col-md-12">
                    <div class="total-wrap">
                        <div class="row">
                            <div class="col-sm-8">
                                <form action="CheckoutProductServlet">
                                    <div class="row form-group">
                                        <div class="col-sm-3">
                                            <input type="submit" formaction="CheckoutProductServlet" value="Checkout" class="btn btn-primary">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-sm-4 text-center">
                                <div class="total">
                                    <div class="sub">
                                        <p><span>Subtotal:</span> <span>$200.00</span></p>
                                        <p><span>Delivery:</span> <span>$0.00</span></p>
                                        <p><span>Discount:</span> <span>$45.00</span></p>
                                    </div>
                                    <div class="grand-total">
                                        <p><span><strong>Total:</strong></span> <span>$450.00</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                    <h2>Related Products</h2>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${list_products}" var="item" begin="1" end="4">
                    <div class="col-md-3 col-lg-3 mb-4 text-center">
                        <div class="product-entry border">
                            <a href="/assignmentJava4_v1_war_exploded/DetailsProductServlet?id=${item.id}" class="prod-img">
                                <img src="${pageContext.request.contextPath}/uploads/${item.imageProduct}"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                            <div class="desc">
                                <h2><a href="/assignmentJava4_v1_war_exploded/DetailsProductServlet?id=${item.id}">${item.nameProduct}</a></h2>
                                <span class="price">${item.price}$</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
