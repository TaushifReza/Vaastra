<%@page import="com.vaastra.model.Customer.Customer"%>
<%
Customer customer = (Customer) session.getAttribute("currentCustomer");
if (customer == null) {
	response.sendRedirect("login.jsp");
} else {
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Change Password</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/changePassword.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>
	<header class="heading">
		<a href="index.jsp"> <img src="../img/logo-fav/logo-bg-remove.png"
			alt="Vaastra logo" class="logo" />
		</a>
	</header>

	<main class="container">
		<section class="edit-profile-section">
			<h1>Change Password</h1>
			<div class="overlay" id="overlay">
				<div class="overlay-content">
					<p class="error-message" id="errorMessage"></p>
					<button class="close-btn" id="closeBtn">OK</button>
				</div>
			</div>
			<form action="../ChangePasswordServlet" method="post"
				class="editForm">
				<div class="editForm-item">
					<div class="editForm-items">
						<%
						String errorMsg = (String) session.getAttribute("invalidPass");
						if (errorMsg != null) {
						%>
						<p><%=errorMsg%></p>
						<%
						session.removeAttribute("invalidPass");
						}
						%>
					</div>
					<div class="editForm-items">
						<label for="">Currrent Password</label> <input type="password"
							required name="oldPassword" />
					</div>
					<div class="editForm-items">
						<label for="">New Password</label> <input type="password" required
							id="newPasswor" name="newPassword" />
					</div>
					<div class="editForm-items">
						<label for="">Confirm Password</label> <input type="password"
							required id="confirmPassword" />
					</div>
				</div>
				<div class="btn">
					<input type="submit" value="Change" id="submit" />
				</div>
				<div class="btn">
					<a href="profile.jsp">Canacel</a>
				</div>
			</form>
		</section>
	</main>
</body>

<jsp:include page="../template/footer.jsp"></jsp:include>

<!-- JavaScript Link -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/share.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/javascript/changePassword.js"></script>
</html>
<%
}
%>
