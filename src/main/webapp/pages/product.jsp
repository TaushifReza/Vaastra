<%@page import="com.vaastra.model.Customer.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Import JSTL Libary -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/product.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/profile.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<jsp:include page="../template/header.jsp"></jsp:include>

	<main>
		<div class="pro-car-container">
			<section class="cat-section">
				<div class="cat-container">
					<h1>Shop By Category</h1>
					<div class="cat-list">
						<p>Sex</p>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Male">Male</a>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Female">Female</a>
					</div>
					<div class="cat-list">
						<p>Brand</p>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Nike">Nike</a>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Zara">Zara</a>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Gucci">Gucci</a>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=Puma">Puma</a>
					</div>
					<div class="cat-list">
						<p>Price Range</p>
						<a
							href="${pageContext.request.contextPath}/ProductServlet?parm=0&parm2=1000">0
							- 1000</a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=1000&parm2=2000">1000
							- 2000</a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=2000&parm2=3000">2000
							- 3000</a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=3000&parm2=4000">3000
							- 4000</a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=4000&parm2=5000">4000
							- 5000</a>
					</div>
					<div class="cat-list">
						<p>Rating</p>
						<a href="${pageContext.request.contextPath}/ProductServlet?parm=1">
							<span class="material-symbols-outlined">star </span>
						</a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=2"><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span></a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=3"><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span></a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=4"><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span></a> <a
							href="${pageContext.request.contextPath}/ProductServlet?parm=5"><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span><span
							class="material-symbols-outlined">star </span></a>
					</div>
				</div>
			</section>
			<section id="product1" class="section-p1">
				<c:choose>
					<c:when test="${empty productList}">
						<div class="pro-container-no-search">
							<img alt="No search result."
								src="${pageContext.request.contextPath}/img/error/no-search-result.png">
						</div>
					</c:when>
					<c:otherwise>
						<p class="item-count">
							<c:out value="${productList.size()}" />
							items found.
						</p>
						<c:forEach items="${productList}" var="product">
							<div class="pro-container">
								<div class="pro">
									<img
										src="http://localhost:8081/Vaastra/ProductImg/<c:out value="${product.getProductImg()}"></c:out>"
										alt="Product Image" class="pro-img" />
									<div class="des">
										<span><c:out value="${product.getBrand()}"></c:out></span>
										<h5>
											<c:out value="${product.getProductName()}"></c:out>
										</h5>
										<div class="star">
											<c:choose>
												<c:when test="${product.getRating() == 1}">
													<span class="material-symbols-outlined">star</span>
												</c:when>
												<c:when test="${product.getRating() == 2}">
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
												</c:when>
												<c:when test="${product.getRating() == 3}">
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
												</c:when>
												<c:when test="${product.getRating() == 4}">
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
												</c:when>
												<c:when test="${product.getRating() == 5}">
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
													<span class="material-symbols-outlined">star</span>
												</c:when>
												<c:otherwise>
													<span>No Rating</span>
												</c:otherwise>
											</c:choose>

										</div>
										<h4>
											RS.
											<c:out value="${product.getProductPrice()}"></c:out>
										</h4>
									</div>
									<c:set var="customer" value="${sessionScope.currentCustomer}" />
									<c:if test="${not empty customer}">
										<!-- Typecast the customer object to the Customer class -->
										<c:set var="customerObj" value="${Customer}" />
									</c:if>
									<c:choose>
										<c:when test="${empty customer}">
											<a href="${pageContext.request.contextPath}/pages/login.jsp">
												<span class="material-symbols-outlined cart">add_shopping_cart</span>
											</a>

										</c:when>
										<c:otherwise>
											<c:set var="productId" value="${product.getProduct_ID()}"></c:set>
											<a
												href="${pageContext.request.contextPath}/AddProductToCartServlet?productId=${productId}">
												<span class="material-symbols-outlined cart">add_shopping_cart</span>
											</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</section>
		</div>
	</main>

	<jsp:include page="../template/footer.jsp"></jsp:include>

	<!-- JavaScript Link -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/share.js"></script>
</body>
</html>