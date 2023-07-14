<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="product-list">
	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Brand</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${pageContext.request.contextPath}/ProductServlet?parm=Nike">Nike</a>
			<a href="${pageContext.request.contextPath}/ProductServlet?parm=Zara">Zara</a>
			<a
				href="${pageContext.request.contextPath}/ProductServlet?parm=Gucci">Gucci</a>
			<a href="${pageContext.request.contextPath}/ProductServlet?parm=Puma">Puma</a>
		</div>
	</div>
	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Men Fashion</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="#">Brand 5</a> <a href="#">Brand 6</a> <a href="#">Brand
				7</a> <a href="#">Brand 8</a>
		</div>
	</div>
	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Women Fashion</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="#">Brand 5</a> <a href="#">Brand 6</a> <a href="#">Brand
				7</a> <a href="#">Brand 8</a>
		</div>
	</div>
	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Rating</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${pageContext.request.contextPath}/ProductServlet?parm=1"><span
				class="material-symbols-outlined">star </span></a> <a
				href="${pageContext.request.contextPath}/ProductServlet?parm=2"><span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span></a> <a
				href="${pageContext.request.contextPath}/ProductServlet?parm=3"><span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span></a> <a
				href="${pageContext.request.contextPath}/ProductServlet?parm=4"><span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span> <span
				class="material-symbols-outlined">star </span></a> <a
				href="${pageContext.request.contextPath}/ProductServlet?parm=5"><span
				class="material-symbols-outlined">star </span><span
				class="material-symbols-outlined">star </span><span
				class="material-symbols-outlined">star </span><span
				class="material-symbols-outlined">star </span><span
				class="material-symbols-outlined">star </span></a>
		</div>
	</div>
</section>