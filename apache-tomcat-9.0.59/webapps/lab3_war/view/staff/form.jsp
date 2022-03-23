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
<h1 class="alert alert-success">Thông tin sinh viên:</h1>
<form action="staffServlet" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="input1" class="form-label">Họ và tên: </label>
        <input name="fullname" type="text" class="form-control" id="input1" aria-describedby="textHelp">
    </div>
    <div class="mb-3">
        <label for="input5" class="form-label">Hình ảnh:</label>
        <input name="image" class="form-control" type="file" id="input5" multiple>
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Ngày sinh: </label>
        <input name="birthday" type="date" class="form-control" id="input2" aria-describedby="textHelp">
    </div>
    <div class="mb-3">
        <label for="radio1" class="form-label">Giới tính:</label>
        <div class="form-check form-check-inline">
            <input
                    class="form-check-input"
                    type="radio"
                    id="radio1"
                    value="true"
                    name="gender"
                    checked="checked"
            />
            <label class="form-check-label" for="radio1">Male</label>
        </div>
        <div class="form-check form-check-inline">
            <input
                    class="form-check-input"
                    type="radio"
                    id="radio2"
                    value="false"
                    name="gender"
            />
            <label class="form-check-label" for="radio2">Female</label>
        </div>
    </div>
    <div class="mb-3 form-check">
        <input name="married" type="checkbox" class="form-check-input" id="check1"/>
        <label class="form-check-label" for="check1">Are you married ?</label>
    </div>
    <div class="mb-3">
        <label class="form-label">Country: </label>
        <select name="country" class="form-select" aria-label="Default select example">
            <option selected value="US">United States</option>
            <option value="VIE">Vietnamese</option>
            <option value="UK">United Kingdom</option>
            <option value="RUS">Russia</option>
        </select>
    </div>
    <div class="form-group">
        <label>Hobbies: </label>
        <div class="form-check form-check-inline">
            <input name="hobbies" type="checkbox" value="R"> Đọc sách
            <input name="hobbies" type="checkbox" value="T"> Du lịch
            <input name="hobbies" type="checkbox" value="M"> Âm nhạc
            <input name="hobbies" type="checkbox" value="O"> Khác
        </div>
    </div>
    <div class="form-group">
        <label for="note">Note:</label>
        <textarea class="form-control" name="notes" id="note" rows="3"></textarea>
    </div>
    <hr>
    <div class="d-grid gap-2">
        <button class="btn btn-outline-success" type="submit">Đăng Ký</button>
    </div>
</form>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta1/js/bootstrap.bundle.min.js"></script>

</body>

</html>