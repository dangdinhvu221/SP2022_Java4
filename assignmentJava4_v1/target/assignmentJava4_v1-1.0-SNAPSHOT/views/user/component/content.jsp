<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/3/2022
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main>
    <div class="colorlib-product">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                    <h2>Product</h2>
                </div>
            </div>
            <div class="row row-pb-md" id="content">
                <c:forEach var="item" items="${listA}" end="3">
                    <div class="col-lg-3 mb-4 text-center product">
                        <div class="product-entry border">
                            <a href="DetailsProductServlet?id=${item.id}" class="prod-img">
                                <img src="uploads/${item.imageProduct}" class="img-fluid"
                                     alt="Free html5 bootstrap 4 template">
                            </a>
                            <div class="desc">
                                <h2><a href="ShowCartServlet?id=${item.id}">${item.nameProduct}</a></h2>
                                <h5 class="text-secondary text-muted font-italic"></h5>
                                <span class="price"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                                      value="${item.price}"/>$</span>
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
                                <li class="${tag == item ? "active" : ""}"><a href="HomePagesServlet?index=${item}">${item}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <p>
                        <button onclick="loadMore()" class="btn btn-primary btn-lg">Shop All Products</button>
                    </p>
                </div>
            </div>
        </div>
    </div>
</main>
