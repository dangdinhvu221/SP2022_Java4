<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/3/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>FPT-Polytechnic</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/icomoon.css">
    <!-- Ion Icon Fonts-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/ionicons.min.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/bootstrap.min.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/magnific-popup.css">

    <!-- Flexslider  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/flexslider.css">

    <!-- Owl Carousel -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/owl.theme.default.min.css">

    <!-- Date Picker -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/bootstrap-datepicker.css">
    <!-- Flaticons  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/fonts/flaticon/font/flaticon.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <base href="/assignmentJava4_v1_war_exploded/">
</head>
<body>

<div class="colorlib-loader"></div>
<div class="row">
    <div class="col">
        <c:if test="${not empty sessionScope.message}">
            <script>
                Swal.fire({
                    icon: "success",
                    title: "SuccessFully!",
                    text: "${sessionScope.message}",
                    showConfirmButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 1600,
                });
            </script>
            <c:remove var="message" scope="session"/>
        </c:if>
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

<div id="page">
    <%--    navigation--%>
    <jsp:include page="user/component/navigation.jsp"/>
    <%--    aside--%>
    <jsp:include page="user/component/aside.jsp"/>
    <%--    content--%>
    <jsp:include page="user/component/content.jsp"/>
    <%--    footer--%>
    <jsp:include page="user/component/footer.jsp"/>
</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- popper -->
<script src="${pageContext.request.contextPath}/views/user/js/popper.min.js"></script>
<!-- bootstrap 4.1 -->
<script src="${pageContext.request.contextPath}/views/user/js/bootstrap.min.js"></script>
<!-- jQuery easing -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.easing.1.3.js"></script>
<!-- Waypoints -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.waypoints.min.js"></script>
<!-- Flexslider -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.flexslider-min.js"></script>
<!-- Owl carousel -->
<script src="${pageContext.request.contextPath}/views/user/js/owl.carousel.min.js"></script>
<!-- Magnific Popup -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/views/user/js/magnific-popup-options.js"></script>
<!-- Date Picker -->
<script src="${pageContext.request.contextPath}/views/user/js/bootstrap-datepicker.js"></script>
<!-- Stellar Parallax -->
<script src="${pageContext.request.contextPath}/views/user/js/jquery.stellar.min.js"></script>
<!-- Main -->

<script src="${pageContext.request.contextPath}/views/user/js/main.js"></script>

<script>
    function loadMore() {
        var amount = document.getElementsByClassName("product").length;
        $.ajax({
            url: "${pageContext.request.contextPath}/loadMoreControlServlet",
            type: "get", //send it through get method
            data: {
                exits: amount
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    }

    function searchByName(param) {
        let txtSearch = param.value;
        $.ajax({
            url: "${pageContext.request.contextPath}/searchAjaxServlet",
            type: "get", //send it through get method
            data: {
                search: txtSearch
            },
            success: function (data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function (xhr) {
                //Do Something to handle error
            }
        });
    }
</script>


</body>
</html>

