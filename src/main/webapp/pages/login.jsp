<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In Page</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css" href="../css/share.css">
<link rel="stylesheet" type="text/css" href="../css/login.css">

<!-- IoIcon Link -->
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</head>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header class="heading">
		<a href="index.jsp"> <img src="../img/logo-fav/logo-bg-remove.png"
			alt="Vaastra logo" class="logo" />
		</a>
	</header>

	<main>
		<div class="center">
			<h1>Login</h1>
			<%
			String errorMsg = (String) session.getAttribute("invalidCustomer");
			if (errorMsg != null) {
			%>
			<p><%=errorMsg%></p>
			<%
			session.removeAttribute("invalidCustomer");
			}
			%>
			<form action="../LoginServlet" method="post">
				<div class="txt_field">
					<input type="email" required name="email" /> <span></span> <label>Email</label>
				</div>
				<div class="txt_field">
					<input type="password" required name="password" /> <span></span> <label>Password</label>
				</div>
				<div class="pass">
					<a href="forgotPassword.jsp">Forgot Password?</a>
				</div>
				<input type="submit" value="Login" />
				<div class="signup_link">
					Not a member? <a href="signup.jsp">Sign up</a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>