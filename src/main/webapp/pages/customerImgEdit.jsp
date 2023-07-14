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
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Customer Profile</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" href="../css/share.css" />
<link rel="stylesheet" href="../css/customerImgEdit.css" />

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
		<a href="index.jsp"> <img src="../img/logo-fav/logo-bg-remove.png"
			alt="" class="logo" />
		</a>
	</header>

	<main class="container">
		<section class="edit-profile-section">
			<h1>Change Profile</h1>
			<form action="../customerImgEdit" method="post" class="editForm"
				enctype="multipart/form-data">
				<!-- enctype="multipart/form-data" -->
				<div class="editForm-item">
					<div class="profileImage-container">
						<img
							src="http://localhost:8081/Vaastra/CustomersImg/<%=customer.getProfilePic()%>"
							alt="" class="profileImg" id="profileImg" />
						<p>Select 500 x 500 Pixel Image size.</p>
						<input type="file" name="profileImg" id="profileImgInput"
							class="file-input" required />
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

	<jsp:include page="../template/footer.jsp" />

	<!-- JavaScript Link -->
	<script type="text/javascript" src="../javascript/share.js"></script>
	<script type="text/javascript" src="../javascript/customerImgEdit.js"></script>
</body>
</html>
<%
}
%>
