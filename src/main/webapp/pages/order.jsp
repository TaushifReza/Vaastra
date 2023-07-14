<%@page import="com.vaastra.model.Customer.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%
Admin admin = (Admin) session.getAttribute("Admin");
if (admin != null) {
	response.sendRedirect("login.jsp");
} else {
%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/admin.css" />
<title>Admin Pannel</title>

<!-- Favicon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/share.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/profile.css" />

<!-- IoIcon -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<header class="heading">
		<a href="admin.jsp"> <img
			src="${pageContext.request.contextPath}/img/logo-fav/logo-bg-remove.png"
			alt="Logo" class="logo" />
		</a>

		<div class="heading-right">
			<a href="#" class="heading-right-item">
			 <%="Admin"%></a> 
			 <a
				href="${pageContext.request.contextPath}/LogoutServlet" class="heading-right-item" id="logout-link"><ion-icon
					name="log-out-outline"></ion-icon>Log Out</a>
			
		</div>
	</header>

	<main class="main-div">
		<div class="admin-functions">
			<h1>Admin</h1>
			<div class="edit-btn-container">
				<a class="edit-profile-btn"
					href="${pageContext.request.contextPath}/GetOrderList?parm=orderlist"
					target="_self"> Orders</a>
			</div>
			<div class="edit-btn-container">
				<a class="edit-profile-btn"
					href="${pageContext.request.contextPath}/pages/addProduct.jsp"
					target="_self"> Add Product</a>
			</div>
			<div class="edit-btn-container">
				<a class="edit-profile-btn"
					href="${pageContext.request.contextPath}/pages/productList.jsp">
					Product List</a>
			</div>
		</div>
		<div class="user-transition">
			<h2>Recent Orders</h2>
			<table>
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Order Date</th>
						<th>Product Name</th>
						<th>Total Price</th>
						<th>Quantity Order</th>
						<th>Order Status</th>
					</tr>
				</thead>

				<tbody>
					<!--  -->
					<c:forEach items="${orderItem}" var="order">
						<tr>
							<th><c:out value="${order.getOrder_ID()}"></c:out></th>
							<td><c:out value="${order.getOrder_Date()}"></c:out></td>
							<td><c:out value="${order.getProduct_Name()}"></c:out></td>
							<td><c:out value="${order.getTotal_Price()}"></c:out></td>
							<td><c:out value="${order.getQuantity()}"></c:out></td>
							<td><c:out value="${order.getOrder_Status()}"></c:out></td>

						</tr>
					</c:forEach>
					<!--  -->
				</tbody>
			</table>
		</div>
	</main>

	<!-- JavaScript Link -->
	
</body>
</html>
<%-- <%
}
%> --%>