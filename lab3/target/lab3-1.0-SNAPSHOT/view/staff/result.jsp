
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<ul>
    <li>Họ và tên: <b>${bean.fullname}</b></li>
    <li>Hình ảnh: <b>${bean.photo}</b></li>
    <li><img src="uploads/${bean.photo}" alt="" width="30%"/></li>
    <li>Ngày sinh: <b>${bean.birthday}</b></li>
    <li>Giới tính: <b>${bean.gender}</b></li>
    <li>Tình trạng hôn nhân: <b>${bean.married}</b></li>
    <li>Quốc tịch: <b>${bean.country}</b></li>
    <li>Sở thích: <b>${hobbies}</b></li>
    <li>Ghi chú: <b>${bean.notes}</b></li>
</ul>
</body>
</html>
