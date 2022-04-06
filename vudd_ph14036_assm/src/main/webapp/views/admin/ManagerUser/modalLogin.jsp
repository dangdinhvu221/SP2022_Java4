<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="elegantModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content form-elegant">
            <div class="modal-header text-center bg-info">
                <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModalLabel">
                    <strong>Sign in
                        <img src="${pageContext.request.contextPath}/images/logo/iconload.gif" alt="" width="10%"/>
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
                <div class="md-form pb-3">
                    <div class="form-group">
                        <label for="password">Enter Password</label>
                        <input type="password" class="form-control" name="password" id="password"
                               aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>

                <div class="text-center mb-3">
                    <button type="" class="btn btn-info btn-block btn-rounded z-depth-1a"
                            data-dismiss="modal">
                        Sign in
                    </button>
                </div>
                <p class="font-small text-dark d-flex justify-content-center mb-3 pt-2">
                    or Sign in with:
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
            <div class="modal-footer mx-5 pt-3 mb-1">
                <p class="font-small grey-text d-flex justify-content-end">
                    Not a member?
                    <a href="#" class="blue-text ml-1" data-toggle="modal" data-target="#modalRegisterForm"
                       data-dismiss="modal" ng-disabled="formSIn.$invalid">
                        Sign Up</a>
                </p>
            </div>
        </div>
    </div>
</div>
