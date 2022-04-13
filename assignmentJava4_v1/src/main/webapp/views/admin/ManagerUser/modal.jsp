<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/28/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- modal Category -->
<div class="modal fade" id="myModalCreateCategory" tabindex="-1" role="dialog" aria-labelledby="myModal"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content form-elegant">
            <div class="modal-header text-center bg-info">
                <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModal">
                    <strong> Category Create
                        <img src="${pageContext.request.contextPath}/views/admin/images/logo/iconload.gif" alt="" width="10%"/>
                    </strong>
                </h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form class="modal-body mx-4" action="CategoryServlet" method="post">
                <div class="md-form mb-5">
                    <div class="form-group">
                        <label for="nameCategory1">Name Category:</label>
                        <input type="text" class="form-control" name="nameCategory" id="nameCategory1" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form">
                    <div class="form-group">
<%--                        <label for="user_id">User ID:</label>--%>
                        <input type="hidden" class="form-control"  name="user_id" value="${users.id}" id="user_id" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="text-center mb-3">
                    <button formaction="CategoryServlet/createCategory" class="btn btn-info btn-block btn-rounded z-depth-1a">
                        Create Category
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- modal Supplier -->
<div class="modal fade" id="myModalCreateSupplier" tabindex="-1" role="dialog" aria-labelledby="myModal"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content form-elegant">
            <div class="modal-header text-center bg-info">
                <h3 class="modal-title w-100 text-dark font-weight-bold my-3" id="myModal">
                    <strong> Supplier Create
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
                        <label for="nameSupplier">Name Supplier:</label>
                        <input type="text" class="form-control" name="nameSupplier" id="nameSupplier" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form mb-5">
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" class="form-control" name="phone" id="phone" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="md-form mb-5">
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" class="form-control" name="address" id="address" aria-describedby="helpId"
                               placeholder=""
                               required/>
                    </div>
                </div>
                <div class="text-center mb-3">
                    <button formaction="SupplierServlet/createSupplier" class="btn btn-info btn-block btn-rounded z-depth-1a"
                            >
                        Create Supplier
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
