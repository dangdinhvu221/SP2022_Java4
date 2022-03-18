<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/13/2022
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="alert alert-danger  text-center text-dark">
    <h1 class="fw-bold">User List</h1>
</div>
<table class="table table-striped table-bordered table-hover table-warning">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">User Name</th>
        <th scope="col">Password</th>
        <th scope="col">Remember?</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>${items[0].username}</td>
        <td>${items[0].password}</td>
        <td>${items[0].remember?'Yes':'No'}</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>${items[1].username}</td>
        <td>${items[1].password}</td>
        <td>${items[1].remember?'Yes':'No'}</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td>${items[2].username}</td>
        <td>${items[2].password}</td>
        <td>${items[2].remember?'Yes':'No'}</td>
    </tr>
    </tbody>
</table>