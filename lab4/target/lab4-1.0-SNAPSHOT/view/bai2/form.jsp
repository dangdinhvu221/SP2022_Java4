<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/13/2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-success  text-center text-dark">
    <h1 class="fw-bold">User Management</h1>
    <h4 class="text-danger fw-bold">User Edition</h4>
    <p class="fst-italic text-muted">${message}</p>
</div>
<form action="userServlet" >
    <div class="mb-3">
        <label for="input1" class="form-label">Username: </label>
        <input name="username" type="text" class="form-control" id="input1" aria-describedby="emailHelp"
               placeholder="Enter username" value="${form.username}">
    </div>
    <div class="mb-3">
        <label for="input2" class="form-label">Password: </label>
        <input name="password" type="password" class="form-control" id="input2" aria-describedby="emailHelp"
               placeholder="Enter password" value="${form.password}">
    </div>
    <div class="mb-3 form-check">
        <input name="remember" type="checkbox" class="form-check-input" id="check1" ${form.remember?'checked':''}/>
        <label class="form-check-label" for="check1">Remember me!</label>
    </div>
    <div class="d-grid gap-2">
        <button type="button" class="btn btn-outline-primary">Create</button>
    </div>
</form>
<hr>
<hr>
