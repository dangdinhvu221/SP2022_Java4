<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/9/2022
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <div>
        <label for="">Email: </label>
        <input type="email" name="email" required>
    </div>
    <div>
        <label for="">Password</label>
        <input type="password" name="password" required>
    </div>
    <button type="submit">Đăng nhập</button>
</form>

<p>Email: ${email}</p>
<p>Password: ${password}</p>
</body>
</html>
