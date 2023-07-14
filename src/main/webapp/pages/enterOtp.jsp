<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter OTP</title>

<!-- FavIcon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/share.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/enterOtp.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>
<body>
	<main class="container">
		<section class="edit-profile-section">
			<h1>Email Verification</h1>
			<form id="register-form" action="../ValidateOtp" method="post"
				role="form" autocomplete="off" class="editForm">
				<div class="editForm-item">
					<%
					String resetEmail = (String) session.getAttribute("resetEmail");
					String errorMsg = (String) session.getAttribute("errorOtpMsg");
					if (errorMsg != null) {
					%>
					<div class="error">
						<p><%=errorMsg%></p>
					</div>
					<%
					session.removeAttribute("errorOtpMsg");
					}
					%>
					<div class="editForm-items">
						<p>
							We have sent a code to your email <b><%=resetEmail%></b>
						</p>
					</div>
					<div class="editForm-items">
						<input type="number" required name="enterOtpValue" />
					</div>
				</div>
				<div class="btn">
					<input type="submit" value="Verify Account" id="submit" />
				</div>
				<div class="btn">
					<a href="login.jsp">Cancel</a>
				</div>
			</form>
		</section>
	</main>
</body>
</html>