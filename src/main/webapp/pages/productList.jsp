<%@page import="com.vaastra.model.Customer.Admin"%>
<%@page import="Dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@page import="com.vaastra.model.Customer.Product"%>
<%-- <%
Admin admin = (Admin) session.getAttribute("Admin");
if (admin != null) {
	response.sendRedirect("login.jsp");
} else {
%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/admin.css" />
<title>Admin Pannel</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" href="../css/share.css" />
<link rel="stylesheet" href="../css/admin.css" />

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
			<a href="#" class="heading-right-item"> <%="Admin"%></a> <a
				href="../LogoutServlet" class="heading-right-item" id="logout-link"><ion-icon
					name="log-out-outline"></ion-icon>Log Out</a>
			<div id="confirmation-overlay" class="overlay">
				<div class="overlay-content">
					<p>Are you sure you want to log out?</p>
					<div class="button-container">
						<button id="yes-button">Yes</button>
						<button id="no-button">No</button>
					</div>
				</div>
			</div>
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
					href="${pageContext.request.contextPath}/pages/productList.html">
					Product List</a>
			</div>
		</div>
		<div class="productList">
			<h1>Product List</h1>
			<section class="product-contaoner">
				<div class="product-heading">
					<div class="cart-heading-list">Product ID</div>
					<div class="cart-heading-list">Name</div>
					<div class="cart-heading-list">Brand</div>
					<div class="cart-heading-list">Quantity</div>
					<div class="cart-heading-list">Price(Rs)</div>
					<div class="cart-heading-list">Sex</div>
					<div class="cart-heading-list">Edit</div>
					<div class="cart-heading-list">Delete</div>
				</div>

			</section>
			<div class="plist">
				<%
				ProductDao dao = new ProductDao();
				List<Product> list = dao.getAllProduct();
				for (Product p : list) {
				%><div class="numbersp">
					<h1><%=p.getProduct_ID()%></h1>
					<h1><%=p.getProductName()%></h1>
					<h1><%=p.getBrand()%></h1>
					<h1><%=p.getStock()%></h1>
					<h1><%=p.getProductPrice()%></h1>
					<h1><%=p.getSex()%></h1>
					<a href="editProduct.jsp?Product_ID=<%=p.getProduct_ID()%>"
						class="btn-a edit">Edit</a> <a
						href="../Delete?Product_ID=<%=p.getProduct_ID()%>"
						class="btn-a del">Delete</a>
				</div>

				<%
				}
				%>

			</div>
		</div>
	</main>

	<!-- JavaScript Link -->
	<script type="text/javascript" src="../javascript/profile.js"></script>
</body>
</html>
<%-- <%
}
%> --%>