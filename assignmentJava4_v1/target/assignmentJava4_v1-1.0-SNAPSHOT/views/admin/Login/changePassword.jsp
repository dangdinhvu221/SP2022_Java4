<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/3/2022
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="limiter">
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
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url(${pageContext.request.contextPath}/views/admin/Login/images/bg-01.jpg);">
					<span class="login100-form-title-1">
						Reset Password
					</span>
            </div>
            <form class="login100-form" action="LoginControlServlet" method="post">
                <input type="hidden" name="email" value="${emailTo}" readonly>
                <div class="wrap-input100 validate-input m-b-26" >
                    <span class="label-input100">Password new</span>
                    <input class="input100" type="password" name="password-new" id="password-new" placeholder="Enter username">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 validate-input m-b-18">
                    <span class="label-input100">Confirm password</span>
                    <input class="input100" type="password" name="cf-password" id="cf-password" placeholder="Enter password">
                    <span class="focus-input100"></span>
                </div>
                <div class="container-login100-form-btn">
                    <button type="submit" formaction="ForgotPasswordServlet/resetPassword?email=${emailTo}" class="login100-form-btn">
                        Reset Password
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>