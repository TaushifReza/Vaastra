<%@page import="com.vaastra.model.Customer.Customer"%>
<%-- <%
Customer customer = (Customer) session.getAttribute("currentCustomer");
if (customer == null) {
	response.sendRedirect("login.jsp");
} else {
%> --%>

<%
Customer customer = (Customer) session.getAttribute("currentCustomer");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Customer Profile</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/share.css" />
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
		<a href="${pageContext.request.contextPath}/pages/index.jsp"> <img
			src="${pageContext.request.contextPath}/img/logo-fav/logo-bg-remove.png"
			alt="" class="logo" />
		</a>

		<div class="heading-right">
			<!-- <div>
				<form action="#" class="search-bar">
					<input type="text" class="search-field"
						placeholder="Serch in Vaastra" />
					<button class="search-btn">
						<ion-icon name="search-outline" class="search-btn-icon"></ion-icon>
					</button>
				</form>
			</div> -->
			<!-- <ion-icon name="person-circle-outline" class="user-icon"></ion-icon  ../img/profile-img/customer-img/customer-2.jpg-->
			<a href="#" class="heading-right-item"><img
				src="http://localhost:8081/Vaastra/CustomersImg/<%=customer.getProfilePic()%>"
				alt="Customer Image" class="user-icon" /> <%=customer.getUserName()%></a>
			<a href="${pageContext.request.contextPath}/LogoutServlet"
				class="heading-right-item" id="logout-link"><ion-icon
					name="log-out-outline"></ion-icon>Log Out</a>
			<!-- 			<div id="confirmation-overlay" class="overlay">
				<div class="overlay-content">
					<p>Are you sure you want to log out?</p>
					<div class="button-container">
						<button id="yes-button">Yes</button>
						<button id="no-button">No</button>
					</div>
				</div>
			</div> -->

			<a
				href="${pageContext.request.contextPath}/GetProductCartServlet?parm=getAllCartItems"
				class="heading-right-item"><ion-icon name="cart-outline"></ion-icon>Cart</a>
		</div>
	</header>

	<main>
		<section class="heading-img-section">
			<div class="heading-img-container">
				<img
					src="${pageContext.request.contextPath}/img/profile-img/profile-background.jpg"
					alt="Profile heading Image" class="profile-heading-img" />
			</div>
		</section>

		<section class="user-profile-section">
			<div class="user-img-container">
				<img
					src="http://localhost:8081/Vaastra/CustomersImg/<%=customer.getProfilePic()%>"
					alt="Profile User Image" class="profile-user-img" />
			</div>
			<div class="user-detail">
				<h1><%=customer.getUserName()%></h1>
				<h4><%=customer.getDescription()%></h4>
				<p>
					<ion-icon name="location-outline"></ion-icon>
					<%=customer.getAddress()%>
				</p>
			</div>
			<div class="img-edit-container">
				<a class="edit-img-link"
					href="${pageContext.request.contextPath}/pages/customerImgEdit.jsp">Edit
					Img</a>
			</div>
		</section>

		<section class="profile-body-section">
			<div class="profile-body-section-main-div">
				<div class="more-user-details">
					<h1>User Details</h1>
					<p class="user-details-item-heading"><%=customer.getFirstName()%></p>
					<p class="user-details-item-heading"><%=customer.getLastName()%></p>
					<p class="user-details-item-heading">
						<ion-icon name="mail-outline" class="icon"></ion-icon>
						<%=customer.getEmail()%>
					</p>
					<p class="user-details-item-heading">
						<ion-icon name="call-outline" class="icon"></ion-icon>
						<%=customer.getPhone()%>
					</p>
					<p class="user-details-item-heading">
						<ion-icon name="calendar-outline" class="icon"></ion-icon>
						<%=customer.getDob()%>
					</p>
					<p class="user-details-item-heading">
						<ion-icon name="transgender-outline" class="icon"></ion-icon>
						<%=customer.getGender()%>
					</p>
					<p class="user-details-item-heading">
						<ion-icon name="calendar-outline" class="icon"></ion-icon>
						<%=customer.getRegisterDate()%>
					</p>
					<p class="user-details-item-heading">
						<ion-icon name="calendar-outline" class="icon"></ion-icon>
						<%=customer.getPassword()%>
					</p>
					<div class="edit-btn-container">
						<a class="edit-profile-btn" href="customerProfileEdit.jsp">Edit
							Profile</a>
					</div>
					<div class="edit-btn-container">
						<a class="edit-profile-btn" href="changePassword.jsp">Change
							Password</a>
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
								<th>Quantity</th>
								<th>Order Status</th>
							</tr>
						</thead>

						<tbody>
							<!--  -->
							<c:forEach items="${orderlist}" var="order">
								<tr>
									<th><c:out value="${order.getOrder_ID()}"></c:out></th>
									<td><c:out value="${order.getOrder_Date()}"></c:out></td>
									<td><c:out value="${order.getProduct_Name()}"></c:out></td>
									<td><c:out value="${order.getTotal_Price()}"></c:out></td>
									<td><c:out value="${order.getOrder_Status()}"></c:out></td>
								</tr>
							</c:forEach>
							<!--  -->
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</main>

	<jsp:include page="../template/footer.jsp" />

	<!-- JavaScript Link -->
	<%-- 	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/profile.js"></script> --%>
	<%-- 	<%
	}
	%> --%>
</body>
</html>
