<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/29/2022
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
    <nav class="mt-5">
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab"
               aria-controls="nav-home" aria-selected="true">User Editing</a>
            <a class="nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
               aria-controls="nav-profile" aria-selected="false">User List</a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
             aria-labelledby="nav-home-tab">
            <form action="AdminServlet" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col">
                        <c:if test="${not empty message}">
                            <script>
                                Swal.fire({
                                    icon: "success",
                                    title: "SuccessFully!",
                                    text: "${message}",
                                    showConfirmButton: false,
                                    closeOnClickOutside: false,
                                    allowOutsideClick: false,
                                    timer: 1600,
                                });
                            </script>
                        </c:if>
                        <c:if test="${not empty error}">
                            <script>
                                Swal.fire({
                                    icon: 'error',
                                    title: 'ERROR!',
                                    text: '${error}',
                                })
                            </script>
                        </c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <label for="username">Username</label>
                        <input type="text" name="username" id="username" class="form-control"
                               placeholder="" aria-describedby="helpId1">
                        <small id="helpId1" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="fullName">Fullname</label>
                        <input type="text" name="fullName" id="fullName" class="form-control"
                               placeholder="" aria-describedby="helpId2">
                        <small id="helpId2" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="email">Email</label>
                        <input type="text" name="email" id="email" class="form-control" placeholder=""
                               aria-describedby="helpId3">
                        <small id="helpId3" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-6">
                        <label for="address">Address</label>
                        <input type="text" name="address" id="address" class="form-control"
                               placeholder="" aria-describedby="helpId4">
                        <small id="helpId4" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-12">
                        <label for="phone">Phone Number</label>
                        <input type="text" name="phone" id="phone" class="form-control" placeholder=""
                               aria-describedby="helpId5">
                        <small id="helpId5" class="text-muted"></small>
                    </div>
                    <%--                    <div class="form-group col-lg-6">--%>
                    <%--                        <label for="birth">BirthDay</label>--%>
                    <%--                        <input type="date" name="birth" id="birth" class="form-control" placeholder=""--%>
                    <%--                               aria-describedby="helpId8">--%>
                    <%--                        <small id="helpId8" class="text-muted"></small>--%>
                    <%--                    </div>--%>
                    <div class="form-group col-lg-12">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" class="form-control"
                               placeholder="" aria-describedby="helpId6">
                        <small id="helpId6" class="text-muted"></small>
                    </div>
                    <div class="form-group col-lg-12">
                        <label for="repassword">RePassword</label>
                        <input type="password" name="repassword" id="repassword" class="form-control"
                               placeholder="" aria-describedby="helpId7">
                        <small id="helpId7" class="text-muted"></small>
                    </div>
                    <div class="input-group mb-3 col-lg-12">
                        <label class="input-group-text" for="inputGroupFile01">Avatar: </label>
                        <input name="avatar" type="file" class="form-control"
                               id="inputGroupFile01">
                    </div>
                    <div class="mb-3 col-12">
                        <label for="radio3" class="">Gender </label>
                        <div class="form-check form-check-inline ">
                            <input checked class="form-check-input" type="radio" id="radio" value="true"
                                   name="gender"/>
                            <label class="form-check-label" for="radio">Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" id="radio1"
                                   value="false" name="gender"/>
                            <label class="form-check-label" for="radio1">FeMale</label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="radio3" class="ml-3">Role </label>
                        <div class="form-check form-check-inline ">
                            <input class="form-check-input" type="radio" id="radio2" value="true"
                                   name="role"/>
                            <label class="form-check-label" for="radio2">Manager</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input checked class="form-check-input" type="radio" id="radio3"
                                   value="false" name="role"/>
                            <label class="form-check-label" for="radio3">User</label>
                        </div>
                    </div>
                </div>
                <div class="form-check mb-5">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="checkedI" id="checkedI"
                               value="checkedValue" checked>
                        <label class="form-check-label" for="checkedI">
                            I agree all statements in <a href="#">Terms of service</a>
                        </label>
                    </label>
                </div>
                <div class="d-flex justify-content-around row">
                    <button formaction="AdminServlet/createUser" class="btn btn-outline-success btn-block">Create
                    </button>
                    <button formaction="AdminServlet/resetUser" class="btn btn-outline-info btn-block">Reset</button>
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <jsp:include page="${tableUsers}"/>
        </div>
    </div>
</div>
<!-- end dashboard inner -->
