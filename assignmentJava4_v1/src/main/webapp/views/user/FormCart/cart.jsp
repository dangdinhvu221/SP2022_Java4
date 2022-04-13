<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/7/2022
  Time: 7:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    input#quantity {
        width: 80px;
        /* margin-left: -10px; */
    }

    span {
        margin-left: 20px;
    }

    .one-eight.text-center.quantity-left {
        margin-left: 50px;
    }
</style>

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
            <form action="CartServlet" method="post">
                <div class="row row-pb-lg">
                    <div class="col-md-12">
                        <div class="product-name d-flex">
                            <div class="one-forth text-left px-4">
                                <span>Product Details</span>
                            </div>
                            <div class="one-eight text-center">
                                <span>Price</span>
                            </div>
                            <div class="one-eight text-center quantity-left">
                                <span>Quantity</span>
                            </div>
                            <%--                        <div class="one-eight text-center">--%>
                            <%--                            <span>Total</span>--%>
                            <%--                        </div>--%>
                            <div class="one-eight text-center px-4 ml-5">
                                <span>Remove</span>
                            </div>
                        </div>
                        <c:forEach items="${list_cart}" var="item">
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
                                    <div class="display-tc d-flex justify-content-between align-items-center">
                                        <span class="input-group-btn">
                                            <a href="SubControlServlet?id=${item.id}" class="btn btn-sm">
                                                <i class="icon-minus2"></i>
                                            </a>
                    		            </span>
                                        <input type="number" id="quantity" name="quantity"
                                               width="100px"
                                               class="form-control input-number"
                                               value="${item.quantity}"
                                               min="1" max="100">
                                        <span class="input-group-btn ml-1">
                                            <a href="CartControlServlet?id=${item.id}" class="btn btn-sm">
                                                 <i class="icon-plus2"></i>
                                            </a>
                                        </span>
                                    </div>
                                </div>
                                <div class="one-eight text-center">
                                    <div class="display-tc">
                                        <a href="CartServlet/remove?id=${item.id}" class="closed"></a>
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
                                    <div class="row form-group">
                                        <div class="col-sm-3">
                                            <button formaction="CheckoutProductServlet"
                                                    class="btn btn-primary btn-addtocart btn-block">
                                                <span><i class="icon-shopping-cart"></i> Checkout</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4 text-center">
                                    <div class="total">
                                        <div class="sub">
                                            <p><span>Total price goods:</span> <span>${total}$</span></p>
                                            <p><span>VAT:</span> <span>${vat}$</span></p>
                                            <p><span>Transport Fee:</span> <span>0$</span></p>
                                        </div>
                                        <div class="grand-total">
                                            <p><span><strong>Total:</strong></span> <span>${sum}$</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                    <h2>Related Products</h2>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${listA}" var="item" end="3">
                    <div class="col-md-3 col-lg-3 mb-4 text-center">
                        <div class="product-entry border">
                            <a href="/assignmentJava4_v1_war_exploded/DetailsProductServlet?id=${item.id}"
                               class="prod-img">
                                <img src="${pageContext.request.contextPath}/uploads/${item.imageProduct}"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                            <div class="desc">
                                <h2>
                                    <a href="/assignmentJava4_v1_war_exploded/DetailsProductServlet?id=${item.id}">${item.nameProduct}</a>
                                </h2>
                                <span class="price">${item.price}$</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-md-12 text-center mt-2 mb-2">
                    <div class="block-27">
                        <ul>
                            <c:forEach var="item" begin="1" end="${endP}">
                                <li class="${tag == item ? "active" : ""}"><a href="CartServlet?index=${item}">${item}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
