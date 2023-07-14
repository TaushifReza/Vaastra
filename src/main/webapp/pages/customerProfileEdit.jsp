<%@page import="com.vaastra.model.Customer.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Customer customer = (Customer) session.getAttribute("currentCustomer");
if (customer == null) {
	response.sendRedirect("login.jsp");
} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Edit</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/customerProfileEdit.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>

	<%-- <jsp:include page="../template/header.jsp"></jsp:include> --%>

	<main class="container">
		<section class="edit-profile-section">
			<h1>Edit Profile</h1>
			<form action="../CustomerEditProfile" method="get" class="editForm"
				id="update-form">
				<div class="input-conatiner">
					<div>
						<div class="editForm-item">
							<label for="name">First Name</label> <input type="text"
								name="firstName" id="name" value="<%=customer.getFirstName()%>" />
						</div>

						<div class="editForm-item">
							<label for="name">Last Name</label> <input type="text"
								name="lastName" id="name" value="<%=customer.getLastName()%>" />
						</div>

						<div class="editForm-item">
							<label for="name">User Name</label> <input type="text"
								name="userName" id="name" value="<%=customer.getUserName()%>" />
						</div>

						<div class="editForm-item">
							<label for="email">Email</label> <input
								value="<%=customer.getEmail()%>(Cannot Change)" readonly>
						</div>
					</div>
					<div>
						<div class="editForm-item">
							<label for="phone">Phone</label> <input type="number"
								name="phone" id="phone" value="<%=customer.getPhone()%>" />
						</div>

						<div class="editForm-item">
							<label for="address">Date fo Birth</label> <input type="date"
								name="dob" id="dob" value="<%=customer.getDob()%>" />
						</div>

						<div class="editForm-item">
							<label for="address">Address</label> <input type="text"
								name="address" id="address" value="<%=customer.getAddress()%>" />
						</div>

						<div class="editForm-item">
							<label for="gender">Gender</label> <select name="gender"
								id="gender" class="gender" value="<%=customer.getGender()%>">
								<option value="">Select your Gender</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Others">Others</option>
							</select>
						</div>
					</div>
				</div>

				<div description-container>
					<div class="editForm-item" id="editForm-item">
						<label for="description">Description</label>
						<textarea name="description" id="description" cols="10" rows="3"><%=customer.getDescription()%></textarea>
					</div>
				</div>

				<div class="loader-container" id="loader" style="display: none;">
					<div class="lds-roller">
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
						<div></div>
					</div>
					<p>Please wait...</p>
				</div>

				<div class="btn-container" id="btn-container">
					<a href="profile.jsp" class="btn">Cancel</a>
					<button type="submit" class="btn" id="submit-btn">Modify</button>
				</div>
			</form>
		</section>
	</main>

	<jsp:include page="../template/footer.jsp"></jsp:include>

	<!-- Ajax Jquery CDN Link -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<!-- sweetalert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- JavaScript Link -->
	<script type="text/javascript"
		src="../javascript/customerProfileEdit.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/share.js"></script>
	<%
	}
	%>
</body>
</html>