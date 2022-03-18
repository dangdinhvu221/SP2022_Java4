<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/10/2022
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
    />

    <title>FPT-Polytechnic</title>
</head>

<body class="container">
<h1 class="alert alert-info">Email</h1>
<div class="container">
    <form action="" method="post">
        <div class="mb-3">
            <label for="input1" class="form-label">Form: </label>
            <input name="form" type="email" class="form-control" id="input1" />
        </div>
        <div class="mb-3">
            <label for="input2" class="form-label">To: </label>
            <input name="to" type="email" class="form-control" id="input2" />
        </div>
        <div class="mb-3">
            <label for="input3" class="form-label">Subject: </label>
            <input name = "subject" type="text" class="form-control" id="input3" />
        </div>
        <div class="form-group mb-3">
            <label  for="">Body</label>
            <textarea name ="body" class="form-control" id="" rows="3" placeholder="bạn nhớ tui hông!!"></textarea>
        </div>
        <hr>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-outline-primary">Send</button>
        </div>
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
