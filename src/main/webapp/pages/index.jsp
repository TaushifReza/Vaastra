<%@page import="com.vaastra.model.Customer.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
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

	<jsp:include page="../template/productLink.jsp"></jsp:include>

	<main>
		<!-- Image Slider -->
		<figure class="${pageContext.request.contextPath}/img-slider">
			<img src="${pageContext.request.contextPath}/img/product/add.jpg"
				alt="Product" class="slider-img" />
			<!-- <h1 style="font-size: 3rem; text-align: center">Image Slider</h1> -->
		</figure>

		<!-- New Arrival -->
		<%-- 		<section>
			<h1 class="new-arrival-heading">New Arrival</h1>
			<div class="new-arrival-container">

				<c:forEach items="${productList}" var="product">
					<div>
						<img
							src="http://localhost:8081/Vaastra/ProductImg/<c:out value="${product.getProductImg()}"></c:out>"
							alt="Product" class="new-arrival-img" />
						<h3>
							<c:out value="${product.getProductName()}"></c:out>
						</h3>
						<p>
							<c:out value="${product.getProductPrice()}"></c:out>
						</p>
					</div>
				</c:forEach>

			</div>
		</section> --%>

		<!-- Trending -->
		<section>
			<h1 class="tredning-heading">Trending</h1>
			<div class="trending-container">

				<%
				ProductDao productDao = new ProductDao();
				ArrayList<Product> tredingProduct = (ArrayList<Product>) productDao.getTrendingProduct();
				for (Product p : tredingProduct) {
				%>

				<div>
					<img
						src="http://localhost:8081/Vaastra/ProductImg/<%=p.getProductImg()%>"
						alt="Product" class="trending-img" />
					<h3>
						<%=p.getProductName()%>
					</h3>
					<p>
						RS.
						<%=p.getProductPrice()%>
					</p>
				</div>
				<%
				}
				%>
			</div>
		</section>

		<!-- Sale -->
		<section>
			<h1 class="sale-heading">Sale</h1>
			<div class="sale-container">
				<c:forEach items="${applicationScope.saleProductList}"
					var="saleProductList">
					<div>
						<img
							src="http://localhost:8081/Vaastra/ProductImg/${saleProductList.getProductImg()}"
							alt="Product" class="sale-img" />
						<h3>${saleProductList.getProductName()}</h3>
						<p>${saleProductList.getProductPrice()}</p>
					</div>

				</c:forEach>
			</div>
		</section>

		<!-- 		<section>
			<h1 class="shop-brand-heading">Shop By Brand</h1>
		</section> -->
	</main>

	<jsp:include page="../template/footer.jsp"></jsp:include>

	<!-- JavaScript Link -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/share.js"></script>
</body>
</html>