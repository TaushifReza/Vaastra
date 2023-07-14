package com.vaastra.servlet.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Customer;

import Dao.OrderDao;

/**
 * Servlet implementation class GetCustomerOrder
 */
@WebServlet("/GetCustomerOrder")
public class GetCustomerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* String email = request.getParameter("email"); */

		HttpSession session = request.getSession();

		Customer customer = (Customer) session.getAttribute("currentCustomer");

		String email = customer.getEmail();

		String forward = "pages/profile.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		OrderDao orderDao = new OrderDao();
		request.setAttribute("orderlist", orderDao.getProductForHome(email));
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
