<%@page import="com.vaastra.model.Customer.Admin"%>
<%@page import="Dao.ProductDao"%>
<%@page import="com.vaastra.model.Customer.Product"%>
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
<script src="./admin.js" defer></script>
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
		<a href="admin.jsp"> <img src="../img2/logo-bg-remove.png"
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
					href="${pageContext.request.contextPath}/pages/productList.jsp">
					Product List</a>
			</div>
		</div>
		<%
		int id = Integer.parseInt(request.getParameter("Product_ID"));
		ProductDao dao = new ProductDao();
		Product p = dao.getAllProductByid(id);
		%>




		<div class="addProduct">
			<h1>Edit Product</h1>
			<form action="../UpdateProductServlet" method="post" class="formc"
				id="update-form" enctype="multipart/form-data" id="product-form">
				<div class="input-conatiner">
					<div>
						<div class="editForm-item">
							<label for="name">Name</label> <input type="text" name="name"
								id="name" value="<%=p.getProductName()%>" />
						</div>

						<div class="editForm-item">
							<label for="brand">Brand</label> <input type="text" name="brand"
								id="brand" value="<%=p.getBrand()%>" />
						</div>

						<div class="editForm-item">
							<label for="stock">Stock</label> <input type="number"
								name="stock" id="stock" value="<%=p.getStock()%>" />
						</div>
						<div class="editForm-item">
							<label for="sex">Sex</label> <select name="sex" id="sex"
								class="gender">
								<option value=""><%=p.getSex()%></option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
						</div>
					</div>
					<div>
						<div class="editForm-item">
							<label for="price">Price</label> <input type="number"
								name="price" id="price" value="<%=p.getProductPrice()%>" />
						</div>

						<div class="editForm-item">
							<label for="type">Type</label> <select name="type" id="type"
								class="gender">
								<option value=""><%=p.getClothType()%></option>
								<option value="t-shirt">T-Shirt</option>
								<option value="hoodie">Hoodie</option>
								<option value="sweatshirt">Sweatshirt</option>
								<option value="jacket">Jacket</option>
								<option value="pants">Pants</option>
							</select>
						</div>

						<div class="editForm-item">
							<label for="photo">Photo</label><input type="file" name="photo"
								id="Photo" value="<%=p.getProductImg()%>" />
						</div>

					</div>
				</div>

				<div class="description-container">
					<div class="editForm-item" id="editForm-item">
						<label for="description">Description</label>
						<textarea name="description" id="description" cols="10" rows="3"
							placeholder="<%=p.getProducrDescription()%>"></textarea>
					</div>
				</div>

				<input type="hidden" name=id value="<%=p.getProduct_ID()%>">
				<div class="btn-container" id="btn-container">
					<a href="productList.jsp" class="btn">Cancel</a> <input
						type="submit" class="btn" id="submit-btn" value="Update">

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
