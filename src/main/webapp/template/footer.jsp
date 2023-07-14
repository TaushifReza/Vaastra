<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<footer>
	<div class="col">
		<a href="${pageContext.request.contextPath}/pages/index.jsp"><img
			src="${pageContext.request.contextPath}/img/logo-fav/logo-bg-remove.png"
			alt="" class="logo" /></a>

		<h4>Contact</h4>
		<p>
			<strong>Address:</strong> Kamal Marg, Kathmandu
		</p>
		<p>
			<strong>Phone:</strong> (+977) 9809645846
		</p>
		<p>
			<strong>Hours:</strong> 10:00 - 18:00, Sun - Fri
		</p>
		<div class="follow">
			<h4>Follow US</h4>
			<div class="icon">
				<div>
					<img
						src="${pageContext.request.contextPath}/img/footer/instagram.png"
						alt="Instagram icon" class="social-icon" />
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath}/img/footer/facebook.png"
						alt="Facebook icon" class="social-icon" />
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath}/img/footer/youtube.png"
						alt="Youtube icon" class="social-icon" />
				</div>
				<div>
					<img
						src="${pageContext.request.contextPath}/img/footer/twitter.png"
						alt="twitter icon" class="social-icon" />
				</div>
			</div>
		</div>
	</div>
	<div class="col">
		<h4>About</h4>
		<a>About Us</a> <a>Delivery Information</a> <a>Privacy Policy</a> <a>Terms
			& Conditions</a> <a>Contact Us</a>
	</div>

	<div class="col">
		<h4>My Account</h4>
		<a>Sign In</a> <a>View Cart</a> <a>My Wishlist</a> <a>Track My
			Order</a> <a>Help</a>
	</div>
	<div class="col install">
		<h4>Install App</h4>
		<p>From App Store or Google Play</p>
		<div class="row">
			<img src="${pageContext.request.contextPath}/img/footer/app.jpg"
				alt="" /> <img
				src="${pageContext.request.contextPath}/img/footer/play.jpg" alt="" />
		</div>
		<p>Secured Payment Gateway</p>
		<div class="payment-container">
			<img
				src="${pageContext.request.contextPath}/img/footer/khalti-logo.svg"
				alt="" /> <img
				src="${pageContext.request.contextPath}/img/footer/esewa_logo.webp"
				alt="" />
		</div>
	</div>
</footer>
<div class="copyright">
	<p>
		Copyright &copy; <span id="currentYear"></span> Vaastra Inc. All
		rights reserved.
	</p>
</div>