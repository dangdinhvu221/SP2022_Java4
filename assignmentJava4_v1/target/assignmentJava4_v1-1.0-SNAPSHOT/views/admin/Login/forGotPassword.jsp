<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/4/2022
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
						Forgot Password
					</span>
            </div>
            <form class="login100-form" action="ForgotPasswordServlet" method="post">
                <div class="wrap-input100 validate-input m-b-26" >
                    <span class="label-input100">Email</span>
                    <input class="input100" type="email" required name="email" id="email" placeholder="Enter email">
                    <span class="focus-input100"></span>
                </div>
                <div class="container-login100-form-btn">
                    <button type="submit" formaction="ForgotPasswordServlet/forgotPassword" class="login100-form-btn">
                        Forgot Password
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
