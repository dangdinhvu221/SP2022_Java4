<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/3/2022
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="colorlib-nav" role="navigation">
    <div class="top-menu">
        <div class="container">
            <div class="row">
                <div class="col-sm-7 col-md-9">
                    <div id="colorlib-logo"><a href="HomePagesServlet">FPT-Polytechnic</a></div>
                </div>
                <div class="col-sm-5 col-md-3">
                    <form action="#" class="search-wrap">
                        <div class="form-group">
                            <label>
                                <input oninput="searchByName(this)" name="search" value="${txtSearch}" type="search" class="form-control search" placeholder="Search">
                            </label>
                            <button class="btn btn-primary submit-search text-center" type="submit"><i
                                    class="icon-search"></i></button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 text-left menu-1">
                    <ul>
                        <li class="active"><a href="HomePagesServlet">Home</a></li>
                        <li class="has-dropdown">
                            <a href="HomePagesServlet">Men</a>
                            <ul class="dropdown">
                                <li><a href="CartServlet">Shopping Cart</a></li>
                                <li><a href="CheckoutProductServlet">Checkout</a></li>
                                <li><a href="HomePagesServlet">Order Complete</a></li>
                                <li><a href="HomePagesServlet">Wishlist</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Women</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="HomePagesServlet/contact">Contact</a></li>

                        <li class="dropdown-toggle cart" data-toggle="dropdown">
                            <a href="#"><i class="icon-user"></i><span>
                                <c:choose>
                                    <c:when test="${users.fullName == null}"></c:when>
                                    <c:otherwise>${users.fullName}</c:otherwise>
                                </c:choose>
                            </span></a>
                        </li>
                        <div class="dropdown-menu">
                            <c:choose>
                                <c:when test="${users.role == true}">
                                    <a class="dropdown-item" href="AdminServlet">Dashboard</a>
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${users.username != null}">
                                    <a class="dropdown-item"
                                       href="HomePagesServlet/profile"
                                       id="profile">My Profile</a>
                                    <hr>
                                    <a class="dropdown-item"
                                       href="OrderControlServlet/historyOrder"
                                       id="profile">History Orders</a>
                                    <hr>
                                    <a class="dropdown-item" href="HomePagesServlet/help">Help</a>
                                    <a class="dropdown-item" href="HomePagesServlet/logout"><span>Log Out</span> <i
                                            class="fa fa-sign-out"></i></a>
                                </c:when>
                                <c:when test="${users.username == null}">
                                    <a class="dropdown-item" href="HomePagesServlet/login">Login</a>
                                    <a class="dropdown-item" href="HomePagesServlet/register">Register</a>
                                </c:when>
                            </c:choose>
                        </div>
                        <li class="cart"><a href="CartServlet"><i class="icon-shopping-cart"></i> Cart [${count}]</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sale">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 offset-sm-2 text-center">
                    <div class="row">
                        <div class="owl-carousel2">
                            <div class="item">
                                <div class="col">
                                    <h3><a href="#">25% off (Almost) Everything! Use Code: Summer Sale</a></h3>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col">
                                    <h3><a href="#">Our biggest sale yet 50% off all summer shoes</a></h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
