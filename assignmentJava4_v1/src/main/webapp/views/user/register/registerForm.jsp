<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.css"
            rel="stylesheet"
    />
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <base href="/assignmentJava4_v1_war_exploded/">
    <title>Document</title>
</head>
<body>
<section class="vh-100 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
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
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Register</h2>

                            <form action="HomePagesServlet" method="post">
                                <div class="form-outline mb-4">
                                    <input name="fullName" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example1cg">Your Name</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="email" type="email" id="form3Example3cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example3cg">Your Email</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="address" type="text" id="address" class="form-control form-control-lg" />
                                    <label class="form-label" for="address">Your Address</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="phone" type="text" id="phone" class="form-control form-control-lg" />
                                    <label class="form-label" for="phone">Your Phone</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="username" type="text" id="username" class="form-control form-control-lg" />
                                    <label class="form-label" for="username">Username</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="password" type="password" id="form3Example4cg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input name="rePassword" type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                </div>

                                <div class="mb-3 col-12">
                                    <label for="radio3" class="">Gender </label>
                                    <div class="form-check form-check-inline ">
                                        <input checked class="form-check-input" type="radio" id="radio3" value="true"
                                               name="gender"/>
                                        <label class="form-check-label" for="radio3">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" id="radio1"
                                               value="false" name="gender"/>
                                        <label class="form-check-label" for="radio1">FeMale</label>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-center">
                                    <button formaction="HomePagesServlet/register" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="HomePagesServlet/login" class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.js"
></script>
</body>
</html>
