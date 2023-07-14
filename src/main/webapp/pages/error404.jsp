<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Not Found</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css" href="../css/share.css">
<link rel="stylesheet" type="text/css" href="../css/error404.css">

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
		<section class="error404-section">
			<div>
				<img src="../img/error/404 Error-bro.svg" alt="404 Error"
					class="error404-svg" /> <a class="home-btn"
					href="../../index.html">Go to Home</a>
			</div>
		</section>
	</main>

	<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>