package com.vaastra.servlet.forgotPassword;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateOtp
 */
@WebServlet("/ValidateOtp")
public class ValidateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateOtp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();

		int enterOtpValue = Integer.parseInt(request.getParameter("enterOtpValue"));

		HttpSession session = request.getSession();

		int sendOtpValue = (int) session.getAttribute("otpValue");
		session.getAttribute("resetEmail");

		if (enterOtpValue == sendOtpValue) {
			response.sendRedirect("pages/newPassword.jsp");
		} else {
			session.setAttribute("errorOtpMsg", "Invalid OTP!!!");
			response.sendRedirect("pages/enterOtp.jsp");
		}
	}

}
