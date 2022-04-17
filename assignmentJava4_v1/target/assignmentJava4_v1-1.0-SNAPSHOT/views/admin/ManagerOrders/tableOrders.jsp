<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 3/31/2022
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="OrderControlServlet" method="post">
    <div class="row mt-5">
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
    <div class=" table-responsive">
        <div class="form-group row">
            <label class="col-7">
                <select name="statusOrder" class="custom-select text-center">
                    <c:forEach var="i" items="${orderStates}">
                        <option value="${i.id}">${i.nameStates}</option>
                    </c:forEach>
                </select>
            </label>
            <div class="col-5">
                <button formaction="OrderControlServlet/update"
                        class="btn btn-outline-danger btn-block fw-bold">
                    Update
                </button>
            </div>
        </div>
        <table class="table table-bordered table-hove sortable">
            <thead class="table-dark">
            <tr>

                <th>Check Box <input type="checkbox" name="select-all" id="select-all"></th>
                <th>ID_Order</th>
                <th>ID_User</th>
                <th>ImageProduct</th>
                <th>nameProduct</th>
                <th>size</th>
                <th>color</th>
                <th>quantity</th>
                <th>price</th>
                <th>total</th>
                <th>status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders_list}" var="item">
                <tr>
                    <td class="text-center">
                        <input type="checkbox" name="idOrder" value="${item.o_id}">
                    </td>
                    <td>${item.o_id}</td>
                    <td>${item.u_id}</td>
                    <td><img src="uploads/${item.imageProduct}" alt="" class="img-responsive img-thumbnail"
                             width="50px"></td>
                    <td>${item.nameProduct}</td>
                    <td>${item.size}</td>
                    <td>${item.color}</td>
                    <td>${item.o_quantity}</td>
                    <td>${item.price}</td>
                    <td>${item.total}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.status == 1}">Chờ xác nhận</c:when>
                            <c:when test="${item.status == 2}">Chờ lấy hàng</c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    function loadMore() {
        var amount = document.getElementsByClassName("product").length;
        $.ajax({
            url: "/Project_banhang/load",
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

    $('#select-all').click(function (event) {
        if (this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function () {
                this.checked = true;
            });
        } else {
            $(':checkbox').each(function () {
                this.checked = false;
            });
        }
    });
</script>
