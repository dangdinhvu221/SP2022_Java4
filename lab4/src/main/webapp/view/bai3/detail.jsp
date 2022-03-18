<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/14/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

    <title>Hello, world!</title>
</head>

<body>
<div class="alert alert-success  text-center text-dark">
    <h1 class="fw-bold">Tên sản phẩm: ${item.name}</h1>
</div>
<div class="container">
    <img src="view/bai1/images/${item.images}" class="rounded mx-auto d-block" alt="...">
    <ul class="list-group">
        <li class="list-group-item">Giá gốc: ${item.price}</li>
        <li class="list-group-item">Giá mới:
            <c:set var="newprice" value="${item.price*(1-item.discount)}"/>
            <fmt:formatNumber value="${newprice}"/>
        </li>
        <li class="list-group-item">Mức giá:
            <c:choose>
                <c:when test="${newprice < 10}"> Giá thấp </c:when>
                <c:when test="${newprice > 100}"> Giá cao </c:when>
                <c:otherwise>Bình thường</c:otherwise>
            </c:choose>
        </li>
        <li class="list-group-item"></li>
    </ul>
</div>

<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>
</body>

</html>