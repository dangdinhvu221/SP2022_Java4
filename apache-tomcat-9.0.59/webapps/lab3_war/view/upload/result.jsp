<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPLOAD</title>
</head>
<body>
<h1>Upload-File</h1>
<ol>
    <li>
        Your image file : ${image } <br />
        <img src="uploads/${image }" alt="" width="20%"/>
    </li>
    <li>
        Your document file : ${document } <br />
        <a href="uploads/${document }"> Click here to dowload</a>
    </li>
</ol>
</body>
</html>
