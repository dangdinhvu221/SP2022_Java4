<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="icon" href="images/fevicon.png" type="image/png" />
    <!-- bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <!-- site css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <!-- responsive css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" />
    <!-- color css -->
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/co.css" />--%>
    <!-- select bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.css" />
    <!-- scrollbar css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css" />
    <!-- custom css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
    <base href="/vudd_ph14036_assm_war_exploded/">
</head>
<body class="inner_page profile_page">
<div class="full_container">
    <div class="inner_container">
        <!-- Sidebar  -->
        <jsp:include page="../Component/navigationV2.jsp"/>
        <!-- end sidebar -->
        <!-- right content -->
        <div id="content">
            <!-- topbar -->
            <jsp:include page="../Component/headerV2.jsp"/>
            <!-- end topbar -->
            <!-- dashboard inner -->
            <div class="midde_cont">
                <div class="container-fluid">
                    <div class="row column_title">
                        <div class="col-md-12">
                            <div class="page_title">
                                <h2>Profile</h2>
                            </div>
                        </div>
                    </div>
                    <!-- row -->
                    <div class="row column1">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <div class="white_shd full margin_bottom_30">
                                <div class="full graph_head">
                                    <div class="heading1 margin_0">
                                        <h2>User profile</h2>
                                    </div>
                                </div>
                                <div class="full price_table padding_infor_info">
                                    <div class="row">
                                        <!-- user profile section -->
                                        <!-- profile image -->
                                        <div class="col-lg-12">
                                            <div class="full dis_flex center_text">
                                                <div class="profile_img"><img width="180" class="rounded-circle"
                                                                              src="../../../images/layout_img/user_img.jpg"
                                                                              alt="#"/></div>
                                                <div class="profile_contant">
                                                    <div class="contact_inner">
                                                        <h3>John Smith</h3>
                                                        <p><strong>About: </strong>Frontend Developer</p>
                                                        <ul class="list-unstyled">
                                                            <li><i class="fa fa-envelope-o"></i> : test@gmail.com</li>
                                                            <li><i class="fa fa-phone"></i> : 987 654 3210</li>
                                                        </ul>
                                                    </div>
                                                    <div class="user_progress_bar">
                                                        <div class="progress_bar">
                                                            <!-- Skill Bars -->
                                                            <span class="skill"
                                                                  style="width:85%;">Web Applications <span
                                                                    class="info_valume">85%</span></span>
                                                            <div class="progress skill-bar ">
                                                                <div class="progress-bar progress-bar-animated progress-bar-striped"
                                                                     role="progressbar" aria-valuenow="85"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 85%;">
                                                                </div>
                                                            </div>
                                                            <span class="skill" style="width:78%;">Website Design <span
                                                                    class="info_valume">78%</span></span>
                                                            <div class="progress skill-bar">
                                                                <div class="progress-bar progress-bar-animated progress-bar-striped"
                                                                     role="progressbar" aria-valuenow="78"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 78%;">
                                                                </div>
                                                            </div>
                                                            <span class="skill" style="width:47%;">Automation & Testing <span
                                                                    class="info_valume">47%</span></span>
                                                            <div class="progress skill-bar">
                                                                <div class="progress-bar progress-bar-animated progress-bar-striped"
                                                                     role="progressbar" aria-valuenow="54"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 54%;">
                                                                </div>
                                                            </div>
                                                            <span class="skill" style="width:65%;">UI / UX <span
                                                                    class="info_valume">65%</span></span>
                                                            <div class="progress skill-bar">
                                                                <div class="progress-bar progress-bar-animated progress-bar-striped"
                                                                     role="progressbar" aria-valuenow="65"
                                                                     aria-valuemin="0" aria-valuemax="100"
                                                                     style="width: 65%;">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- profile contant section -->
                                            <div class="full inner_elements margin_top_30">
                                                <div class="tab_style2">
                                                    <div class="tabbar">
                                                        <nav>
                                                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                                                <a class="nav-item nav-link active" id="nav-home-tab"
                                                                   data-toggle="tab" href="#recent_activity" role="tab"
                                                                   aria-selected="true">Recent Activity</a>
                                                                <a class="nav-item nav-link" id="nav-profile-tab"
                                                                   data-toggle="tab" href="#project_worked" role="tab"
                                                                   aria-selected="false">Projects Worked on</a>
                                                                <a class="nav-item nav-link" id="nav-contact-tab"
                                                                   data-toggle="tab" href="#profile_section" role="tab"
                                                                   aria-selected="false">Profile</a>
                                                            </div>
                                                        </nav>
                                                        <div class="tab-content" id="nav-tabContent">
                                                            <div class="tab-pane fade show active" id="recent_activity"
                                                                 role="tabpanel" aria-labelledby="nav-home-tab">
                                                                <div class="msg_list_main">
                                                                    <ul class="msg_list">
                                                                        <li>
                                                                            <span><img src="../images/layout_img/msg2.png"
                                                                                       class="img-responsive"
                                                                                       alt="#"></span>
                                                                            <span>
                                                               <span class="name_user">Taison Jack</span>
                                                               <span class="msg_user">Sed ut perspiciatis unde omnis.</span>
                                                               <span class="time_ago">12 min ago</span>
                                                               </span>
                                                                        </li>
                                                                        <li>
                                                                            <span><img src="../images/layout_img/msg3.png"
                                                                                       class="img-responsive"
                                                                                       alt="#"></span>
                                                                            <span>
                                                               <span class="name_user">Mike John</span>
                                                               <span class="msg_user">On the other hand, we denounce.</span>
                                                               <span class="time_ago">12 min ago</span>
                                                               </span>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                            <div class="tab-pane fade" id="project_worked"
                                                                 role="tabpanel" aria-labelledby="nav-profile-tab">
                                                                <p>Sed ut perspiciatis unde omnis iste natus error sit
                                                                    voluptatem accusantium doloremque laudantium, totam
                                                                    rem aperiam, eaque ipsa quae ab illo inventore
                                                                    veritatis et
                                                                    quasi architecto beatae vitae dicta sunt explicabo.
                                                                    Nemo enim ipsam voluptatem quia voluptas sit
                                                                    aspernatur aut odit aut fugit, sed quia consequuntur
                                                                    magni dolores eos
                                                                    qui ratione voluptatem sequi nesciunt.
                                                                </p>
                                                            </div>
                                                            <div class="tab-pane fade" id="profile_section"
                                                                 role="tabpanel" aria-labelledby="nav-contact-tab">
                                                                <p>Sed ut perspiciatis unde omnis iste natus error sit
                                                                    voluptatem accusantium doloremque laudantium, totam
                                                                    rem aperiam, eaque ipsa quae ab illo inventore
                                                                    veritatis et
                                                                    quasi architecto beatae vitae dicta sunt explicabo.
                                                                    Nemo enim ipsam voluptatem quia voluptas sit
                                                                    aspernatur aut odit aut fugit, sed quia consequuntur
                                                                    magni dolores eos
                                                                    qui ratione voluptatem sequi nesciunt.
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- end user profile section -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- footer -->
                    <jsp:include page="footer.jsp"/>
                </div>
                <!-- end dashboard inner -->
            </div>
        </div>
    </div>
</div>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/chart_custom_style1.js"></script>
</div>
</body>
</html>

