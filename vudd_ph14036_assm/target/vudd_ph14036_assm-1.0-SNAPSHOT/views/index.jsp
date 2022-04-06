<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Pluto - Responsive Bootstrap Admin Panel Templates</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- site icon -->
    <link rel="icon" href="images/fevicon.png" type="image/png"/>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <!-- site css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <!-- responsive css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css"/>
    <!-- color css -->
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/co.css" />--%>
    <!-- select bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.css"/>
    <!-- scrollbar css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css"/>
    <!-- custom css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <base href="/vudd_ph14036_assm_war/">

</head>
<body class="dashboard dashboard_1">
<div class="full_container">
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- wow animation -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/animate.js"></script>
    <!-- select country -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
    <!-- owl carousel -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/owl.carousel.js"></script>
    <!-- chart js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.bundle.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/utils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/analyser.js"></script>
    <!-- nice scrollbar -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript">
        var ps = new PerfectScrollbar('#sidebar');
    </script>
    <!-- custom js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chart_custom_style1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>
</div>
<!-- end-script -->
</body>
</html>