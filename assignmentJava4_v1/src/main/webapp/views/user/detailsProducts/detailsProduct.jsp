<%--
  Created by IntelliJ IDEA.
  User: dangd
  Date: 4/6/2022
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col">
                <p class="bread"><span><a href="HomePagesServlet">Home</a></span> / <span>Product Details</span></p>
            </div>
        </div>
    </div>
</div>

<div class="colorlib-product">
    <div class="container">
        <div class="row row-pb-lg product-detail-wrap">
            <div class="col-sm-8">
                <div class="owl-carousel">
                    <div class="item">
                        <div class="product-entry border">
                            <a href="#" class="prod-img">
                                <img src="${pageContext.request.contextPath}/uploads/${products.imageProduct}"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                        </div>
                    </div>
                    <div class="item">
                        <div class="product-entry border">
                            <a href="#" class="prod-img">
                                <img src="${pageContext.request.contextPath}/views/user/images/item-8.jpg"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                        </div>
                    </div>
                    <div class="item">
                        <div class="product-entry border">
                            <a href="#" class="prod-img">
                                <img src="${pageContext.request.contextPath}/views/user/images/item-3.jpg"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                        </div>
                    </div>
                    <div class="item">
                        <div class="product-entry border">
                            <a href="#" class="prod-img">
                                <img src="${pageContext.request.contextPath}/views/user/images/item-4.jpg"
                                     class="img-fluid" alt="Free html5 bootstrap 4 template">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <form action="DetailsProductServlet" method="post">
                    <div class="product-desc">
                        <h3>${products.nameProduct}</h3>
                        <p class="text-muted font-italic"><strong>${products.title}</strong></p>
                        <p class="price">
                            <span>${products.price}$</span>
                            <span class="rate">
									<i class="icon-star-full"></i>
									<i class="icon-star-full"></i>
									<i class="icon-star-full"></i>
									<i class="icon-star-full"></i>
									<i class="icon-star-half"></i>
									(74 Rating)
								</span>
                        </p>
                        <p>${products.description}</p>
                        <div class="size-wrap">
                            <div class="block-26 mb-2">
                                <h4>Size</h4>
                                <ul>
                                    <li class="${products.size == S ? "active" : ""}"><a href="#" class="active">S</a></li>
                                    <li class="${products.size == M ?'active':''}"><a href="#">M</a></li>
                                    <li class="${products.size == L ?'active':''}"><a href="#">L</a></li>
                                    <li class=" ${products.size == XL ?'active':''}"><a href="#">XL</a></li>
                                    <li class=" ${products.size == 39 ?'active':''}"><a href="#">39</a></li>
                                    <li class=" ${products.size == 40 ?'active':''}"><a href="#">40</a></li>
                                    <li class=" ${products.size == 41 ?'active':''}"><a href="#">41</a></li>
                                    <li class=" ${products.size == 42 ?'active':''}"><a href="#">42</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="input-group mb-4">
                        	<span class="input-group-btn">
                                <button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
                                    <i class="icon-minus2"></i>
                                </button>
                    		</span>
                            <input type="number" id="quantity" name="quantity" class="form-control input-number"
                                   value="1"
                                   min="1" max="100">
                            <span class="input-group-btn ml-1">
                                <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                                     <i class="icon-plus2"></i>
                                </button>
                     	    </span>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <p class="addtocart">
                                    <button formaction="CartServlet/AddToCart?id=${products.id}"
                                            class="btn btn-primary btn-addtocart btn-block">
                                        <span><i class="icon-shopping-cart"></i> Add to Cart</span>
                                    </button>
                                </p>
                                <c:choose>
                                    <c:when test="${idPF == products.id && idU == users.id}">
                                        <span><a href="favoritesServlet/Unlike?id=${products.id}"
                                                 class="btn btn-danger">Unlike</a><i class="bi bi-suit-heart"></i></span>
                                    </c:when>
                                    <c:when test="${idPF != products.id}">
                                        <span><a href="favoritesServlet/like?id=${products.id}"
                                                 class="btn btn-danger">Like</a><i class="bi bi-suit-heart"></i></span>
                                    </c:when>
                                    <c:otherwise>
                                         <span><a href="favoritesServlet/like?id=${products.id}"
                                                  class="btn btn-outline-danger">Like</a><i class="bi bi-suit-heart"></i></span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="row">
                    <div class="col-md-12 pills">
                        <div class="bd-example bd-example-tabs">
                            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

                                <li class="nav-item">
                                    <a class="nav-link active" id="pills-description-tab" data-toggle="pill"
                                       href="#pills-description" role="tab" aria-controls="pills-description"
                                       aria-expanded="true">Description</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="pills-manufacturer-tab" data-toggle="pill"
                                       href="#pills-manufacturer" role="tab" aria-controls="pills-manufacturer"
                                       aria-expanded="true">Manufacturer</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review"
                                       role="tab" aria-controls="pills-review" aria-expanded="true">Review</a>
                                </li>
                            </ul>

                            <div class="tab-content" id="pills-tabContent">
                                <div class="tab-pane border fade show active" id="pills-description" role="tabpanel"
                                     aria-labelledby="pills-description-tab">
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic life One day however a small line of blind text by the
                                        name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                    <p>When she reached the first hills of the Italic Mountains, she had a last view
                                        back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet
                                        Village and the subline of her own road, the Line Lane. Pityful a rethoric
                                        question ran over her cheek, then she continued her way.</p>
                                    <ul>
                                        <li>The Big Oxmox advised her not to do so</li>
                                        <li>Because there were thousands of bad Commas</li>
                                        <li>Wild Question Marks and devious Semikoli</li>
                                        <li>She packed her seven versalia</li>
                                        <li>tial into the belt and made herself on the way.</li>
                                    </ul>
                                </div>

                                <div class="tab-pane border fade" id="pills-manufacturer" role="tabpanel"
                                     aria-labelledby="pills-manufacturer-tab">
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic life One day however a small line of blind text by the
                                        name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                    <p>When she reached the first hills of the Italic Mountains, she had a last view
                                        back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet
                                        Village and the subline of her own road, the Line Lane. Pityful a rethoric
                                        question ran over her cheek, then she continued her way.</p>
                                </div>

                                <div class="tab-pane border fade" id="pills-review" role="tabpanel"
                                     aria-labelledby="pills-review-tab">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <h3 class="head">23 Reviews</h3>
                                            <div class="review">
                                                <div class="user-img"
                                                     style="background-image: url(${pageContext.request.contextPath}/views/user/images/person1.jpg)"></div>
                                                <div class="desc">
                                                    <h4>
                                                        <span class="text-left">Jacob Webb</span>
                                                        <span class="text-right">14 March 2018</span>
                                                    </h4>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-half"></i>
										   					<i class="icon-star-empty"></i>
									   					</span>
                                                        <span class="text-right"><a href="#" class="reply"><i
                                                                class="icon-reply"></i></a></span>
                                                    </p>
                                                    <p>When she reached the first hills of the Italic Mountains, she had
                                                        a last view back on the skyline of her hometown
                                                        Bookmarksgrov</p>
                                                </div>
                                            </div>
                                            <div class="review">
                                                <div class="user-img"
                                                     style="background-image: url(${pageContext.request.contextPath}/views/user/images/person2.jpg)"></div>
                                                <div class="desc">
                                                    <h4>
                                                        <span class="text-left">Jacob Webb</span>
                                                        <span class="text-right">14 March 2018</span>
                                                    </h4>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-half"></i>
										   					<i class="icon-star-empty"></i>
									   					</span>
                                                        <span class="text-right"><a href="#" class="reply"><i
                                                                class="icon-reply"></i></a></span>
                                                    </p>
                                                    <p>When she reached the first hills of the Italic Mountains, she had
                                                        a last view back on the skyline of her hometown
                                                        Bookmarksgrov</p>
                                                </div>
                                            </div>
                                            <div class="review">
                                                <div class="user-img"
                                                     style="background-image: url(${pageContext.request.contextPath}/views/user/images/person3.jpg)"></div>
                                                <div class="desc">
                                                    <h4>
                                                        <span class="text-left">Jacob Webb</span>
                                                        <span class="text-right">14 March 2018</span>
                                                    </h4>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-half"></i>
										   					<i class="icon-star-empty"></i>
									   					</span>
                                                        <span class="text-right"><a href="#" class="reply"><i
                                                                class="icon-reply"></i></a></span>
                                                    </p>
                                                    <p>When she reached the first hills of the Italic Mountains, she had
                                                        a last view back on the skyline of her hometown
                                                        Bookmarksgrov</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="rating-wrap">
                                                <h3 class="head">Give a Review</h3>
                                                <div class="wrap">
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					(98%)
									   					</span>
                                                        <span>20 Reviews</span>
                                                    </p>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-empty"></i>
										   					(85%)
									   					</span>
                                                        <span>10 Reviews</span>
                                                    </p>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					(70%)
									   					</span>
                                                        <span>5 Reviews</span>
                                                    </p>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					(10%)
									   					</span>
                                                        <span>0 Reviews</span>
                                                    </p>
                                                    <p class="star">
										   				<span>
										   					<i class="icon-star-full"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					<i class="icon-star-empty"></i>
										   					(0%)
									   					</span>
                                                        <span>0 Reviews</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
