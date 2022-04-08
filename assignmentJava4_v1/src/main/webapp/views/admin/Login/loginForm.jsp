
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="limiter">
    <div class="row">
        <div class="col">
            <c:if test="${not empty sessionScope.error}">
                <script>
                    Swal.fire({
                        icon: 'error',
                        title: 'ERROR!',
                        text: '${sessionScope.error}',
                    })
                </script>
                <c:remove var="error" scope="session"/>
            </c:if>
        </div>
    </div>
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url(${pageContext.request.contextPath}/views/admin/Login/images/bg-01.jpg);">
					<span class="login100-form-title-1">
						Sign In
					</span>
            </div>
            <form class="login100-form" action="LoginControlServlet" method="post">
                <div class="wrap-input100 validate-input m-b-26" >
                    <span class="label-input100">Username</span>
                    <input class="input100" type="text" name="username" id="username" placeholder="Enter username">
                    <span class="focus-input100"></span>
                </div>
                <div class="wrap-input100 validate-input m-b-18">
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" name="password" id="password" placeholder="Enter password">
                    <span class="focus-input100"></span>
                </div>
                <div class="flex-sb-m w-full p-b-30">
                    <div>
                        <a href="ForgotPasswordServlet" class="txt1">
                            Forgot Password?
                        </a>
                    </div>
                </div>
                <div class="container-login100-form-btn">
                    <button type="submit" formaction="LoginControlServlet/login" class="login100-form-btn">
                        Login
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
