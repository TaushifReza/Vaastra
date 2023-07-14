package com.vaastra.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Admin;
import com.vaastra.model.Customer.Customer;

import Dao.CustomerDao;
import Dao.OrderDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin admin = new Admin();

		CustomerDao customerDao = new CustomerDao();

		Customer customer = customerDao.getCustomerEmailPassword(email, password);

		if ((customer == null) && !(admin.getEmail().equals(email) && admin.getPassword().equals(password))) {
			HttpSession errorSession = request.getSession();
			errorSession.setAttribute("invalidCustomer", "Invalid Email ");
			response.sendRedirect("pages/login.jsp");

		} else if (customer != null) {
			HttpSession session = request.getSession();
			session.setAttribute("currentCustomer", customer);
//			response.sendRedirect("pages/profile.jsp");
			String forward = "pages/profile.jsp";
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			OrderDao orderDao = new OrderDao();
			request.setAttribute("orderlist", orderDao.getProductForHome(email));
			dispatcher.forward(request, response);

		} else if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("Admin", admin);
			response.sendRedirect("pages/admin.jsp");
		}

	}
}
