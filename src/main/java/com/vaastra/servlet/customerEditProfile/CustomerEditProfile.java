package com.vaastra.servlet.customerEditProfile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Customer;

import Dao.CustomerDao;

/**
 * Servlet implementation class CustomerEditProfile
 */
@WebServlet("/CustomerEditProfile")
public class CustomerEditProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerEditProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Fetch the data from form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		long phone = Integer.parseInt(request.getParameter("phone"));
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String description = request.getParameter("description");

		// get user from session
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("currentCustomer");

		// Set the form data to the current customer
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUserName(userName);
		customer.setPhone(phone);
		customer.setDob(dob);
		customer.setAddress(address);
		customer.setGender(gender);
		customer.setDescription(description);

		// Update to Database
		CustomerDao customerDao = new CustomerDao();

		if (customerDao.updateCustomer(customer)) {
			response.sendRedirect("pages/profile.jsp");
		} else {
			out.println("<h1>Profile Not Updated</h1>");
		}
	}
}
