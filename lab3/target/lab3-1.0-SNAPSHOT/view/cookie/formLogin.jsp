<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>

    <title>FPT-Polytechnic</title>
</head>

<body class="container">
<h1 class="alert alert-danger">Login</h1>
<form action="LoginServlet" method="post">
    <div class="mb-3">
        <label for="input1" class="form-label">Username: </label>
        <input name="username" type="text" class="form-control" id="input1" aria-describedby="textHelp" value="${username}">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Password: </label>
        <input name="password" type="password" class="form-control" id="input2" aria-describedby="textHelp" value="${password}">
    </div>
    <div class="form-check mb-3">
        <input name="remember" class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
            Remember me?
        </label>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <button class="btn btn-outline-success" type="submit">Đăng Ký</button>
    </div>
    <br>
    <h1 class="alert alert-success">${message}</h1>
</form>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>

</body>
</html>