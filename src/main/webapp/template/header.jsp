<%@page import="com.vaastra.model.Customer.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<header class="heading">
	<a href="${pageContext.request.contextPath}/pages/index.jsp"> <img
		src="${pageContext.request.contextPath}/img/logo-fav/logo-bg-remove.png"
		alt="Vaastra logo" class="logo" />
	</a>

	<div class="heading-right">
		<div>
			<form
				action="${pageContext.request.contextPath}/ProductSearchServlet"
				method="get" class="search-bar">
				<input type="text" class="search-field"
					placeholder="Serch in Vaastra" name="serchItem" />
				<button class="search-btn">
					<ion-icon name="search-outline" class="search-btn-icon"></ion-icon>
				</button>
			</form>
		</div>

		<%
		Customer customer = (Customer) session.getAttribute("currentCustomer");
		if (customer != null) {
		%>
		<a
			href="${pageContext.request.contextPath}/GetCustomerOrder?email=email"
			class="heading-right-item"> <img
			src="http://localhost:8081/Vaastra/CustomersImg/<%=customer.getProfilePic()%>"
			alt="Customer Image" class="user-icon" /> <%=customer.getUserName()%>
		</a>
		<%
		}
		%>

		<%
		if (customer == null) {
		%>
		<a href="${pageContext.request.contextPath}/pages/signup.jsp"
			class="heading-right-item"> <ion-icon name="person-add-outline"></ion-icon>
			Sign up
		</a> <a href="${pageContext.request.contextPath}/pages/login.jsp"
			class="heading-right-item"> <ion-icon name="person-outline"></ion-icon>
			Login
		</a>
		<%
		}
		%>
		<%
		if (customer != null) {
		%>
		<a
			href="${pageContext.request.contextPath}/GetProductCartServlet?parm=getAllCartItems"
			class="heading-right-item"> <ion-icon name="cart-outline"></ion-icon>
			Cart
		</a>
		<%
		} else {
		%>
		<a href="${pageContext.request.contextPath}/pages/login.jsp"
			class="heading-right-item"> <ion-icon name="cart-outline"></ion-icon>
			Cart
		</a>
		<%
		}
		%>
		<%-- <a
			href="${pageContext.request.contextPath}/GetProductCartServlet?parm=getAllCartItems"
			class="heading-right-item"> <ion-icon name="cart-outline"></ion-icon>
			Cart
		</a> --%>
	</div>
</header>