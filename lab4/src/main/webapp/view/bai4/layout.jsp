<%@ page  contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>DEMO BOOTSTRAP</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous" />
    <link rel="stylesheet"
          href="../fonts/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="../css/style.css" />

</head>

<body>
<div class="container-fluid">
    <jsp:include page="template/header.jsp" />
    <jsp:include page="template/menu.jsp" />
    <jsp:include page="template/banner.jsp" />

    <section class="row my-3 d-flex">
        <jsp:include page="template/category.jsp" />
        <article class="col-lg-9 col-12">
                <h1 class="display-4 bg-secondary text-white pl-3">LAP TOP:</h1>
                <div class="row ">
                    <c:forEach var="item" items="${items}">
                    <div class="col-lg-3 col-12 justify-content-center">
                        <div class="card text-left ">
                            <img src="${pageContext.request.contextPath}/view/bai1/images/${item.images}" alt="">
                            <div class="card-body">
                                <h4 class="card-title font-italic text-danger font-weight-bold ">${item.price * (1-item.discount)}</h4>
                                <span class="text-black-50 font-italic"><s>${item.price}</s></span>
                                <p class="card-text">${item.name}</p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </article>
    </section>

    <jsp:include page="template/footer.jsp" />
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>