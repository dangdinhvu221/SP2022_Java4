
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
<h1 class="alert alert-success">Upload</h1>
<form action="UploadServlet" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="input1" class="form-label">Hình ảnh:</label>
        <input name="image" class="form-control" type="file" id="input1" multiple>
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Tài liệu:</label>
        <input name="document" class="form-control" type="file" id="input2" multiple>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <button class="btn btn-outline-success" type="submit">UPLOAD</button>
    </div>
</form>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>
</body>

</html>
