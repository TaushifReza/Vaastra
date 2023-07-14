<%@page import="com.vaastra.model.Customer.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<a class="edit-profile-btn" href="addProduct.jsp" target="_self">
					Add Product</a>
			</div>
			<div class="edit-btn-container">
				<a class="edit-profile-btn" href="productList.jsp"> Product List</a>
			</div>
		</div>
		<div class="addProduct">
			<h1>Add Product</h1>
			<form action="../AddProductServlet" method="post" class="formc"
				id="update-form" enctype="multipart/form-data" id="product-form">
				<div class="input-conatiner">
					<div>
						<div class="editForm-item">
							<label for="name">Name</label> <input type="text" name="name"
								id="name" />
						</div>

						<div class="editForm-item">
							<label for="brand">Brand</label> <input type="text" name="brand"
								id="brand" />
						</div>

						<div class="editForm-item">
							<label for="stock">Stock</label> <input type="number"
								name="stock" id="stock" />
						</div>
						<div class="editForm-item">
							<label for="sex">Sex</label> <select name="sex" id="sex"
								class="gender">
								<option value="">Select sex</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
						</div>
					</div>
					<div>
						<div class="editForm-item">
							<label for="price">Price</label> <input type="number"
								name="price" id="price" />
						</div>

						<div class="editForm-item">
							<label for="type">Type</label> <select name="type" id="type"
								class="gender">
								<option value="">Select Type</option>
								<option value="t-shirt">T-Shirt</option>
								<option value="hoodie">Hoodie</option>
								<option value="sweatshirt">Sweatshirt</option>
								<option value="jacket">Jacket</option>
								<option value="pants">Pants</option>
							</select>
						</div>

						<div class="editForm-item">
							<label for="photo">Photo</label><input type="file" name="photo"
								id="Photo" required />
						</div>

					</div>
				</div>

				<div class="description-container">
					<div class="editForm-item" id="editForm-item">
						<label for="description">Description</label>
						<textarea name="description" id="description" cols="10" rows="3"></textarea>
					</div>
				</div>
				<div class="btn-container" id="btn-container">
					<a href="addProduct.jsp" class="btn">Cancel</a> <input
						type="submit" class="btn" id="submit-btn" value="Add">

				</div>
			</form>
		</div>

	</main>
	<!-- JavaScript Link -->
	<script type="text/javascript" src="../javascript/profile.js"></script>
</body>
</html>
<%-- <%
}
%> --%>
