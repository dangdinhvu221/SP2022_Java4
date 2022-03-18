
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<c:if test="${empty student}">
    <h1 class="alert alert-warning text-center">
        Không có dữ liệu !!!
    </h1>
</c:if>
<c:if test="${ !empty student}">
    <h1 class="alert alert-success text-center">
        Có dữ liệu !!!
    </h1>
    <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover table-info">
            <thead>
            <tr>
                <th scope="col">code</th>
                <th scope="col">fullname</th>
                <th scope="col">gender</th>
                <th scope="col">major</th>
                <th scope="col">phone</th>
                <th scope="col">email</th>
                <th scope="col">date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${student}" var="item">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.fullname}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.gender == true }">Nam</c:when>
                            <c:when test="${item.gender == false }">Nữ</c:when>
                            <c:otherwise>---</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${item.major}</td>
                    <td>${item.phone}</td>
                    <td>${item.email}</td>
                    <td><fmt:formatDate value="${item.date}" pattern="dd-mm-yyyy"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
