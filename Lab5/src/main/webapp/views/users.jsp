<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/20/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <base href="/Lab05_duc2509_war/">
</head>

<body>
<div class="container">
    <img src="" class="img-responsive img-fluid" alt="">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown link
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <div class="col">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}</div>

                    </c:if>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="UserServlet" method="post">
                        <div class="form-group">
                            <label for="">User ID</label>
                            <input type="text" name="userId" class="form-control" value="${user.userId}">
                        </div>

                        <div class="form-group">
                            <label for="">Password</label>
                            <input type="password" name="password" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="">Fullname</label>
                            <input type="text" name="fullname" class="form-control" value="${user.fullname}">
                        </div>
                        <div class="form-group">
                            <label for="">Email</label>
                            <input type="text" name="email" class="form-control"
                                   value="${user.email}"
                            >
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="admin" id="flexRadioDefault1"
                            ${user.admin ? 'checked':''}
                                   value="true">
                            <label class="form-check-label" for="flexRadioDefault1">
                                Admin
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="admin" id="flexRadioDefault2"
                                   value="false"
                            ${!user.admin ? 'checked':''}>
                            <label class="form-check-label" for="flexRadioDefault2">
                                User
                            </label>
                        </div>
                        <div class="form-check">
                            <button class="btn btn-primary" formaction="UserServlet/create">Create</button>
                            <button class="btn btn-warning" formaction="UserServlet/update">Update</button>
                            <button class="btn btn-danger" formaction="UserServlet/delete">Delete</button>
                            <button class="btn btn-info" formaction="UserServlet/reset">Reset</button>
                        </div>
                    </form>
                </div>

                <div class="col">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>UserID</td>
                                <td>FullName</td>
                                <td>Email</td>
                                <td>Role</td>
                                <td>&nbsp</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${users}">

                                <tr>
                                    <td>${item.userId}</td>
                                    <td>${item.fullname}</td>
                                    <td>${item.email}</td>
                                    <td>${item.admin ? 'Admin' : 'User'}</td>
                                    <td>
                                        <a href="UserServlet/edit?userId=${item.userId}">
                                            Edit
                                        </a>
                                        <a href="UserServlet/delete?userId=${item.userId}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-3">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>

            <ol class="list-group list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
            </ol>
        </div>
    </div>

    <footer class="bg-danger text-center mt-5">
        Vuddph14036
    </footer>
</div>

<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>
