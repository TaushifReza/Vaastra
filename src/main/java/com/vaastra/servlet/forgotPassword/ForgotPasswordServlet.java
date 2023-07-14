package com.vaastra.servlet.forgotPassword;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		if (email != null || !email.equals("")) {
			// generate otp code
			Random rand = new Random();
			int otpValue = rand.nextInt(1255650);

			String to = email;// change accordingly
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("vaastrafit@gmail.com", "eklxcovjmarapnxs");
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				message.setSubject("Verification OTP");

				String msg = "<div style='text-align: center'>"
						+ "<p style='font-size: 24px; color: red'>Verification OTP</p>" + "<h1>" + otpValue + "</h1>"
						+ "<p>Please use the above OTP to verify.</p>"
						+ " <p>© 2023 Vaastra Inc. All rights reserved.</p>" + "</div>";
				message.setContent(msg, "text/html; charset=utf-8");

				// send message
				Transport.send(message);
			}

			catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			HttpSession session1 = request.getSession();
			
//			session1.setAttribute("errorMsg", "Invalid Email Address");

			session1.setAttribute("otpValue", otpValue);
			session1.setAttribute("resetEmail", email);
			
			response.sendRedirect("pages/enterOtp.jsp");
		}

	}

}
