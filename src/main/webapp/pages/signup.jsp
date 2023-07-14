<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../img/logo-fav/favicon.png"
	type="image/x-icon" />

<!-- Css Link -->
<link rel="stylesheet" type="text/css" href="../css/share.css">
<link rel="stylesheet" type="text/css" href="../css/signup.css">

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
			<h1>Sign Up</h1>
			<form action="../SignupServlet" method="post"
				enctype="multipart/form-data" id="signup-form">
				<div class="form-detail-container">
					<div class="form-detail-container1">
						<div>
							<label for="name">First Name</label> <input type="text"
								name="firstName" id="firstName" required />
						</div>
						<div>
							<label for="name">Last Name</label> <input type="text"
								name="lastName" id="lastName" required />
						</div>
						<div>
							<label for="userName">User Name</label> <input type="text"
								name="userName" id="userName" required />
						</div>
						<div>
							<label for="email">Email</label> <input type="email" name="email"
								id="email" required />
						</div>
						<div>
							<label for="phone">Phone</label> <input type="number"
								name="phone" id="phone" required />
						</div>
					</div>
					<div class="form-detail-container2">
						<div>
							<label for="profilePic">Profile Picture</label> <input
								type="file" name="profilePic" id="profilePic" required />
						</div>
						<div>
							<label for="dob">Date of Birth</label> <input type="date"
								name="dob" id="dob" />
						</div>
						<div>
							<label for="gender">Select Gender:</label> <select name="gender"
								id="gender">
								<option value="Not Select">Select Your Gender</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Others">Others</option>
							</select>
						</div>
						<div>
							<label for="address">Address</label> <input type="text"
								name="address" id="address" required />
						</div>
						<div>
							<label for="password">Password</label>
							<div class="password-wrapper">
								<input type="password" name="password" id="password" required />
								<button type="button" id="show-password">
									<i class="fas fa-eye"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="terms">
					<input type="checkbox" name="terms" id="terms" required /> <label
						for="terms">I agree to the terms and conditions</label>
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
				<div>
					<div class="btn">
						<input type="submit" value="Sign Up" id="submit-btn" />
					</div>
				</div>

				<div class="signup_link">
					Already a member? <a href="login.jsp">Login</a>
				</div>
			</form>
		</div>
	</main>

	<!-- Ajax Jquery CDN Link -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

	<!-- sweetalert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- JavaScript Link -->
	<script src="../javascript/signup.js"></script>
</body>
</html>