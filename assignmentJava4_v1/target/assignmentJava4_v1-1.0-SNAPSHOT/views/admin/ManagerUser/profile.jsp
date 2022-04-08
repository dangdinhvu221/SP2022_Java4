<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <div class="profile_img"><img width="180px" height="180px" class="rounded-circle"
                                                              src="${pageContext.request.contextPath}/uploads/${users.avatar}"
                                                              alt="#"/></div>
                                <div class="profile_contant">
                                    <div class="contact_inner">
                                        <h3>${users.fullName}</h3>
                                        <p><strong>About: </strong>${users.address}</p>
                                        <ul class="list-unstyled">
                                            <li><i class="fa fa-envelope-o"></i> : ${users.email}</li>
                                            <li><i class="fa fa-phone"></i> : ${users.phone}</li>
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
                                                   aria-selected="false">Change password</a>
                                            </div>
                                        </nav>
                                        <div class="tab-content" id="nav-tabContent">
                                            <div class="tab-pane fade show active" id="recent_activity"
                                                 role="tabpanel" aria-labelledby="nav-home-tab">
                                                <div class="msg_list_main">
                                                    <ul class="msg_list">
                                                        <li>
                                                                            <span><img
                                                                                    src="../images/layout_img/msg2.png"
                                                                                    class="img-responsive"
                                                                                    alt="#"></span>
                                                            <span>
                                                               <span class="name_user">Taison Jack</span>
                                                               <span class="msg_user">Sed ut perspiciatis unde omnis.</span>
                                                               <span class="time_ago">12 min ago</span>
                                                               </span>
                                                        </li>
                                                        <li>
                                                                            <span><img
                                                                                    src="${pageContext.request.contextPath}/images/layout_img/msg3.png"
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
                                                <form action="ChangePasswordServlet" method="post">
                                                    <input type="hidden" name="idUser" value="${users.id}" readonly>
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
                                                        <div class="form-group col-lg-12">
                                                            <label  for="password">Password Old</label>
                                                            <input readonly type="password" name="password" id="password" class="form-control"
                                                                   placeholder="" aria-describedby="helpId1" value="${users.password}">
                                                            <small id="helpId1" class="text-muted"></small>
                                                        </div>
                                                        <div class="form-group col-lg-12">
                                                            <label for="password-new">Password New</label>
                                                            <input  type="password" name="password-new" id="password-new" class="form-control"
                                                                   placeholder="" aria-describedby="helpId2" >
                                                            <small id="helpId2" class="text-muted"></small>
                                                        </div>
                                                        <div class="form-group col-lg-12">
                                                            <label for="cf-password">Confirm password</label>
                                                            <input type="password" name="cf-password" id="cf-password" class="form-control"
                                                                   placeholder="" aria-describedby="helpId3" >
                                                            <small id="helpId3" class="text-muted"></small>
                                                        </div>
                                                    </div>
                                                    <button formaction="ChangePasswordServlet/changePassword?id=${users.id}" class="btn btn-outline-success btn-block" onsubmit=" notload();">Change Password</button>
                                                    <button type="reset" class="btn btn-outline-info btn-block">Reset</button>
                                                </form>
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
</div>
<!-- end dashboard inner -->

<script>
    const notload = (even) =>{
        even.preventDefault();
    }
</script>
