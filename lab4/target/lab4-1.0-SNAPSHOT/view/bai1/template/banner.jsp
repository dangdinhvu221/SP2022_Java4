<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<div id="my-carousel" class="carousel slide carousel-fade"
     data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#my-carousel" data-slide-to="0" class="active"></li>
        <li data-target="#my-carousel" data-slide-to="1"></li>
        <li data-target="#my-carousel" data-slide-to="2"></li>
        <li data-target="#my-carousel" data-slide-to="3"></li>
        <li data-target="#my-carousel" data-slide-to="4"></li>
        <li data-target="#my-carousel" data-slide-to="5"></li>
        <li data-target="#my-carousel" data-slide-to="6"></li>
        <li data-target="#my-carousel" data-slide-to="7"></li>

    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active" data-interval="1000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/2.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/4.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/5.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/6.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/7.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/8.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/9.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/10.jpg" alt="">
        </div>
        <div class="carousel-item" data-interval="2000">
            <img class="d-block w-100" src="${pageContext.request.contextPath}/view/bai1/images/13.jpg" alt="">
        </div>
    </div>
    <a class="carousel-control-prev" href="#my-carousel" role="button"
       data-slide="prev"> <span class="carousel-control-prev-icon"
                                aria-hidden="true"></span> <span class="sr-only">Previous</span>
    </a> <a class="carousel-control-next" href="#my-carousel" role="button"
            data-slide="next"> <span class="carousel-control-next-icon"
                                     aria-hidden="true"></span> <span class="sr-only">Previous</span>
</a>
</div>