<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/18/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="StudentServlet" method="post">
    <div class="mb-3">
        <label for="input1" class="form-label">Mã sinh viên:</label>
        <input name="code" type="text" class="form-control" id="input1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Họ tên:</label>
        <input name="fullname" type="text" class="form-control" id="input2" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="input3" class="form-label">Số điện thoại:</label>
        <input name="phone" type="text" class="form-control" id="input3" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="input4" class="form-label">Email:</label>
        <input name="email" type="email" class="form-control" id="input4" aria-describedby="emailHelp">
    </div>
    <%--        <div class="mb-3">--%>
    <%--            <label for="input5" class="form-label">Thời gian tạo:</label>--%>
    <%--            <input name="date" type="date" class="form-control" id="input5" aria-describedby="emailHelp">--%>
    <%--        </div>--%>
    <div class="mb-3">
        <label for="input2" class="form-label">Giới tính:</label>
        <div class="form-check form-check-inline">
            <input name="gender" class="form-check-input" type="radio" id="radio1" value="true" checked="checked"/>
            <label class="form-check-label" for="radio1">Nam</label>
        </div>
        <div class="form-check form-check-inline">
            <input name="gender" class="form-check-input" type="radio" id="radio2" value="false"/>
            <label class="form-check-label" for="radio2">Nữ</label>
        </div>
    </div>
    <div class="mb-3">
        <select name="major" class="form-select" aria-label="Default select example">
            <option disabled selected value="">-Mời bạn chọn chuyên ngành-</option>
            <option value="UDPM">Ứng dụng phần mềm</option>
            <option value="TKW">Thiết kế website</option>
            <option value="TKDH">Thiết kế đồ hoạ</option>
        </select>
    </div>
    <div class="d-grid gap-2">
        <button type="submit" class="btn btn-outline-success">Submit</button>
    </div>
</form>