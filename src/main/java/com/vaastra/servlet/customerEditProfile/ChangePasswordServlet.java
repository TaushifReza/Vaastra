package com.vaastra.servlet.customerEditProfile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.PasswordEncryption.PasswordEncryptionWithAes;
import com.vaastra.model.Customer.Customer;

import Dao.CustomerDao;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String oldPassword = request.getParameter("oldPassword");

		// get current user from session
		HttpSession session = request.getSession();

		Customer customer = (Customer) session.getAttribute("currentCustomer");

		String email = customer.getEmail();

		String newEncryptedPassword = PasswordEncryptionWithAes.encrypt(customer.getEmail(),
				request.getParameter("newPassword"));

		CustomerDao customerDao = new CustomerDao();

		if (customerDao.changePassword(customer, oldPassword, newEncryptedPassword)) {
			response.sendRedirect("pages/profile.jsp");
//			out.println("right");
//			out.println(oldPassword);
//			out.println(email);
		} else {
//			out.println("wrong");
//			out.println(oldPassword);
//			out.println(email);
			
			
			HttpSession errorSession = request.getSession();
			errorSession.setAttribute("invalidPass", "Current Password Incorrect!!! Please try Again.");

			response.sendRedirect("pages/changePassword.jsp");
		}
	}

}
