<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <!-- basic -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>FPT_Polytechnic</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- site icon -->
    <link rel="icon" href="images/fevicon.png" type="image/png"/>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/bootstrap.min.css"/>
    <!-- site css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/style.css"/>
    <!-- responsive css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/responsive.css"/>
    <!-- color css -->
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/co.css" />--%>
    <!-- select bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/bootstrap-select.css"/>
    <!-- scrollbar css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/perfect-scrollbar.css"/>
    <!-- custom css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/custom.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/animate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/flaticon.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/admin/css/font-awesome.min.css"/>
    <base href="/assignmentJava4_v1_war_exploded/">
</head>
<body class="dashboard dashboard_1">
<div class="full_container">
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

    <div class="inner_container">
        <!-- navigation -->
        <jsp:include page="admin/Component/navigationV2.jsp"/>
        <!-- end-navigation -->

        <!-- right content -->
        <div id="content">
            <!-- topbar -->
            <jsp:include page="admin/Component/headerV2.jsp"/>
            <!-- end-topbar -->

            <!-- dashboard inner -->
            <div class="midde_cont">
                <!-- content -->
                <jsp:include page="${views}"/>
                <!-- end-content -->

                <!-- footer -->
                <jsp:include page="admin/Component/footerV2.jsp"/>
                <!-- end-footer -->

            </div>
            <!-- end dashboard inner -->
        </div>
    </div>
</div>
<!-- script -->
<div>
    <!-- jQuery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/popper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/bootstrap.min.js"></script>
    <!-- wow animation -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/animate.js"></script>
    <!-- select country -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/bootstrap-select.js"></script>
    <!-- owl carousel -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/owl.carousel.js"></script>
    <!-- chart js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/Chart.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/Chart.bundle.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/utils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/analyser.js"></script>
    <!-- nice scrollbar -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript">
        var ps = new PerfectScrollbar('#sidebar');
    </script>
    <!-- custom js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/chart_custom_style1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/custom.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/admin/js/sorttable.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</div>
<!-- end-script -->
</body>
</html>