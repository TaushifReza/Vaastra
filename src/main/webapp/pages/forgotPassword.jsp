<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/forgotPassword.css">

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
			<h1>Forgot Password</h1>
			<form action="../ForgotPasswordServlet" method="get" class="editForm">
				<div class="editForm-item">
					<div class="editForm-items">
						<p>Please enter the account that you want to reset the
							password.</p>
					</div>
					<div class="editForm-items">
						<label for="">Email</label> <input type="email" required
							name="email" />
					</div>
				</div>
				<div class="btn">
					<input type="submit" value="Send OTP" id="submit" />
				</div>
				<div class="btn">
					<a href="login.jsp">Canacel</a>
				</div>
			</form>
		</section>
	</main>
</body>
</html>