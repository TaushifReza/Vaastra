
<%
Customer customer = (Customer) session.getAttribute("currentCustomer");
if (customer == null) {
	response.sendRedirect("pages/login.jsp");
} else {
%>
<%@page import="com.vaastra.model.Customer.Customer"%>
<!-- Import JSTL Libary -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add To Cart</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/addToCart.css">

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
		<!-- <section class="empty-msg">
			<p>There are no items in this cart.</p>
			<button class="check-out-btn">Continue Shopping</button>
		</section> -->


		<c:choose>
			<c:when test="${empty cartList}">
				<section id="continue-shoping-btn">
					<div class="empty-msg">
						<p>There are no items in this cart.</p>
						<a class="check-out-btn"
							href="${pageContext.request.contextPath}/ProductServlet?parm=allProduct">Continue
							Shopping</a>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<section>
					<div class="cart-heading">
						<ion-icon name="bag-handle-outline" class="cart-icon"></ion-icon>
						<h1>Shopping Cart</h1>
						<h1>
							(
							<c:out value="${cartList.size()}" />
							items)
						</h1>
					</div>
					<div class="cart-contaoner">
						<div class="cart-details-heading">
							<div class="cart-heading-list">Product Image</div>
							<div class="cart-heading-list">Product Name</div>
							<div class="cart-heading-list">Product Price</div>
							<div class="cart-heading-list">Quantity</div>
							<div class="cart-heading-list">Check Out</div>
							<div class="cart-heading-list">Delete</div>
						</div>
						<c:forEach items="${cartList}" var="cartItems">
							<c:set value="${cartItems.getCartId()}" var="cartID"></c:set>
							<c:set value="${cartItems.getProductName()}" var="productName"></c:set>
							<c:set value="${cartItems.getProductPrice()}" var="productPrice"></c:set>
							<c:set value="${cartItems.getProductQuantity()}"
								var="prductQuantity"></c:set>
							<div class="cart-items">
								<form action="" class="cart-from">
									<div class="cart-items-1">
										<img
											src="http://localhost:8081/Vaastra/ProductImg/<c:out value="${cartItems.getProductImage()}"></c:out>"
											alt="Product Image" />
									</div>
									<div class="cart-items-2">
										<c:out value="${cartItems.getProductName()}"></c:out>
									</div>
									<div class="cart-items-3">
										<c:out value="${cartItems.getProductPrice()}"></c:out>
									</div>
									<div class="cart-items-4">
										<button class="minus-btn" type="button">-</button>
										<input type="number" class="cart-input"
											value="<c:out value="${cartItems.getProductQuantity()}"/>"
											min="1" max="999" />

										<button class="plus-btn" type="button">+</button>
									</div>

									<div class="cart-items-6">
										<a class="check-out-btn"
											href="${pageContext.request.contextPath}/GetProductCartServlet?parm=checkOut&parm1=${cartID}&parm2=${productName}&parm3=${productPrice}&parm4=${prductQuantity}">Check
											Out</a>
									</div>
									<div class="cart-items-6">
										<a
											href="${pageContext.request.contextPath}/GetProductCartServlet?parm=deleteCartItem&parm1=${cartID}">
											<ion-icon name="trash-outline" class="del-icon"></ion-icon>
										</a>
									</div>
								</form>
							</div>
						</c:forEach>
					</div>
				</section>
			</c:otherwise>
		</c:choose>
	</main>


	<jsp:include page="../template/footer.jsp"></jsp:include>

	<!-- JavaScript Link -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/share.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/addToCart.js"></script>

</body>
</html>
<%
}
%>