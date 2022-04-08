<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/6/2022
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>Login HomePage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/loginFormHomePage/css/style.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <base href="/assignmentJava4_v1_war_exploded/">
</head>
<body class="img js-fullheight" style="background-image: url(${pageContext.request.contextPath}/views/user/loginFormHomePage/images/bg.jpg);">
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Login</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <form action="" class="signin-form" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="username" placeholder="Username" >
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" name="password" class="form-control" placeholder="Password" >
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <button type="submit" formaction="HomePagesServlet/login" class="form-control btn btn-primary submit px-3">Sign In</button>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <label class="checkbox-wrap checkbox-primary">Remember Me
                                    <input type="checkbox" name="rememberMe" checked>
                                    <span class="checkmark"></span>
                                </label>
                            </div>
                            <div class="w-50 text-md-right">
                                <a href="ForgotPasswordServlet" style="color: #fff">Forgot Password</a>
                            </div>
                        </div>
                    </form>
                    <p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
                    <div class="social d-flex text-center">
                        <a href="#" class="px-2 py-2 mr-md-1 rounded"><span class="ion-logo-facebook mr-2"></span> Facebook</a>
                        <a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="row">
    <div class="col">
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
<script src="${pageContext.request.contextPath}/views/user/loginFormHomePage/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/views/user/loginFormHomePage/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/views/user/loginFormHomePage/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/views/user/loginFormHomePage/js/main.js"></script>

</body>
</html>

