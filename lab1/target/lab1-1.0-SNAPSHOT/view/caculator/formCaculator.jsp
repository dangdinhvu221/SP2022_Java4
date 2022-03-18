<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<h1>THÔNG TIN HÌNH CHỮ NHẬT</h1>
<form action="ChuNhatServlet" method="post">
    Chiều rộng:<br>
    <label>
        <input type="text" name="chieuR">
    </label> <br>
    Chiều dài:<br>
    <label>
        <input type="text" name="chieuD">
    </label><br>
    <button>Tính</button>
</form>
</body>
</html>