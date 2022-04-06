<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/29/2022
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="elegantModalForm2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content form-elegant">
            <div class="modal-header text-center bg-info">
                <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModalLabel">
                    <strong>Register
                        <img src="${pageContext.request.contextPath}/views/admin/images/logo/iconload.gif" alt="" width="10%"/>
                    </strong>
                </h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form class="modal-body mx-4" action="#" method="post">
                <div class="md-form mb-5">
                    <div class="form-group">
                        <label for="username">Enter User:</label>
                        <input type="text" class="form-control" name="username" id="username" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form mb-5">
                    <div class="form-group">
                        <label for="fullName">Enter Fullname:</label>
                        <input type="text" class="form-control" name="fullName" id="fullName" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="email">Enter Email</label>
                        <input type="email" class="form-control" name="email" id="email"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="address">Enter Address</label>
                        <input type="text" class="form-control" name="address" id="address"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="phone">Enter Phone Number</label>
                        <input type="text" class="form-control" name="phone" id="phone"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>

                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="password">Enter Password</label>
                        <input type="password" class="form-control" name="password" id="password"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="password">Enter RePassword</label>
                        <input type="password" class="form-control" name="repassword" id="repassword"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="radio1" class="mr-3">Gender: </label>
                    <div class="form-check form-check-inline ">
                        <input checked class="form-check-input" type="radio" id="radio1" value="true" name="gender"/>
                        <label class="form-check-label" for="radio1" >Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="radio2" value="false" name="gender"/>
                        <label class="form-check-label" for="radio2">Female</label>
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
                <div class="text-center mb-3">
                    <button class="btn btn-info btn-block btn-rounded z-depth-1a"
                            data-dismiss="modal">
                        Register
                    </button>
                </div>
                <p class="font-small text-dark d-flex justify-content-center mb-3 pt-2">
                    or Sign up with:
                </p>

                <div class="row my-3 d-flex justify-content-center">
                    <button type="button" class="btn btn-outline-warning ml-3 btn-rounded mr-md-3 z-depth-1a">
                        <i class="bi bi-facebook text-dark"></i>
                    </button>
                    <button type="button" class="btn btn-outline-warning ml-3 btn-rounded mr-md-3 z-depth-1a">
                        <i class="bi bi-twitter text-dark"></i>
                    </button>
                    <button type="button" class="btn btn-outline-warning ml-3 btn-rounded z-depth-1a">
                        <i class="bi bi-google text-dark"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
