<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />

    <title>FPT-Polytechnic</title>
</head>

<body class="container">
<h1 class="alert alert-success">TAM GIÁC</h1>
<form action="TamGiacServlet" method="post">
    <div class="mb-3">
        <label for="input1" class="form-label">Cạnh A:</label>
        <input type="text" name="canhA" class="form-control" id="input1" aria-describedby="textHelp">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Cạnh B:</label>
        <input type="text" name="canhB" class="form-control" id="input2" aria-describedby="textHelp">
    </div>
    <div class="mb-3">
        <label for="input3" class="form-label">Cạnh C:</label>
        <input type="text" name="canhC" class="form-control" id="input3" aria-describedby="emailHelp">
    </div>
    <hr>
    <div class="d-grid gap-2">
        <button formaction="chu-vi" class="btn btn-outline-success" type="submit">Tính chu vi</button>
        <button formaction="dien-tich" class="btn btn-outline-warning" type="submit">Tính diện tích</button>
    </div>
</form>
<p class="fs-4 fw-bold alert alert-danger mt-5 text-dark">${message}</p>

<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>

</body>

</html>