<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Password</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/newPassword.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>
	<main class="container">
		<section class="edit-profile-section">
			<h1>Create New Password</h1>
			<div class="overlay" id="overlay">
				<div class="overlay-content">
					<p class="error-message" id="errorMessage"></p>
					<button class="close-btn" id="closeBtn">OK</button>
				</div>
			</div>
			<form action="../NewPassword" method="post" class="editForm">
				<div class="editForm-item">
					<!-- <div class="editForm-items">
              <p></p>
            </div> -->
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
					<input type="submit" value="Reset Password" id="submit" />
				</div>
				<div class="btn">
					<a href="profile.jsp">Canacel</a>
				</div>
			</form>
		</section>
	</main>

	<!-- JavaScript Link -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/share.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/javascript/changePassword.js"></script>
</body>
</html>