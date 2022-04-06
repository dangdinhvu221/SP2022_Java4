<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/22/2022
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sorttable.js"></script>

    <base href="/lab5_v2_war_exploded/">
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
                <h1 class="alert alert-success text-center">Thông tin sinh viên</h1>
                <form action="UsersServlet" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="input1" class="form-label">Fullname:</label>
                        <input name="fullname" type="text" class="form-control" id="input1"
                               aria-describedby="emailHelp" value="${user.fullname}">
                    </div>
                    <div class="mb-3">
                        <label for="input2" class="form-label">Address: </label>
                        <input name="address" type="text" class="form-control" id="input2"
                               aria-describedby="emailHelp" value="${user.address}">
                    </div>
                    <div class="mb-3">
                        <label for="input3" class="form-label">Email:</label>
                        <input name="email" type="email" class="form-control" id="input3"
                               aria-describedby="emailHelp" value="${user.email}">
                    </div>
                    <div class="mb-3">
                        <label for="input4" class="form-label">Password:</label>
                        <input name="password" type="password" class="form-control" id="input4"
                               aria-describedby="emailHelp" value="${user.password}">
                    </div>
                    <div class="mb-3">
                        <label for="input5" class="form-label">Phone:</label>
                        <input name="phone" type="text" class="form-control" id="input5"
                               aria-describedby="emailHelp" value="${user.phone}">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="inputGroupFile01">Avatar: </label>
                        <input name="avatar" value="${user.avatar}" type="file" class="form-control"
                               id="inputGroupFile01">
                    </div>
                    <div class="row d-flex justify-content-center justify-content-evenly">
                        <button formaction="UsersServlet/insert" class="btn btn-outline-success col-2">Create</button>
                        <button formaction="UsersServlet/delete?id=${user.id}" class="btn btn-outline-danger col-2">Delete</button>
                        <button formaction="UsersServlet/update?id=${user.id}" class="btn btn-outline-info col-2">Update</button>
                        <button formaction="UsersServlet/reset" class="btn btn-outline-warning col-2">Reset</button>
                        <button formaction="UsersServlet/search" class="btn btn-outline-secondary col-2">Search</button>
                    </div>
                </form>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover table-info text-center sortable">
                        <thead>
                        <tr>
                            <th scope="col">Fullname</th>
                            <th scope="col">Address</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Avatar</th>
                            <th scope="col">Edit</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list_users}" var="item">
                            <tr>
                                <td>${item.fullname}</td>
                                <td>${item.address}</td>
                                <td>${item.email}</td>
                                <td>${item.phone}</td>
                                <td><img src="uploads/${item.avatar}" alt="...." width="30px"></td>
                                <td>
                                    <div class="d-grid gap-2">
                                        <a href="UsersServlet/edit?id=${item.id}"
                                           class="btn btn-outline-secondary fw-bold">Edit</a>
                                        <a href="UsersServlet/delete?id=${item.id}" class="btn btn-outline-danger fw-bold">Delete</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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