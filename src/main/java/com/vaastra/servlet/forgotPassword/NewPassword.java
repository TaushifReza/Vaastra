package com.vaastra.servlet.forgotPassword;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.PasswordEncryption.PasswordEncryptionWithAes;

import Dao.CustomerDao;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String resetEmail = (String) session.getAttribute("resetEmail");

		String newEncryptedPassword = PasswordEncryptionWithAes.encrypt(resetEmail,
				request.getParameter("newPassword"));

		CustomerDao customerDao = new CustomerDao();

		if (customerDao.forgetPassword(resetEmail, newEncryptedPassword)) {
//			out.println("Password Change");

			session.removeAttribute("otpValue");
			session.removeAttribute("email");
			
			response.sendRedirect("pages/login.jsp");
		} else {
//			out.println("Password Not Change");

			session.removeAttribute("otpValue");
			session.removeAttribute("email");
			
			
			session.setAttribute("invalidCustomer", "Password Not Change!!!");

			response.sendRedirect("pages/login.jsp");
		}

	}

}
