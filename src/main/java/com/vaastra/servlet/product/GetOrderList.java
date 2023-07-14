package com.vaastra.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Customer;

import Dao.AddToCartDao;
import Dao.OrderDao;

/**
 * Servlet implementation class GetOrderList
 */
@WebServlet("/GetOrderList")
public class GetOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOrderList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String parm = request.getParameter("parm");

//		OrderDao orderDao = new OrderDao();
//
//		String forward = forward = "pages/order.jsp";
//
//		if (orderDao.getAllOrderItems().isEmpty()) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
//			request.setAttribute("orderItem", orderDao.getAllOrderItems());
//			dispatcher.forward(request, response);
//			out.println("empty");
//		} else {
//			out.println("not empty");
//		}
//
////		String forward = forward = "pages/order.jsp";
		String forward;
		if (parm.equalsIgnoreCase("orderlist")) {
			forward = "pages/order.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			OrderDao orderDao = new OrderDao();
			request.setAttribute("orderItem", orderDao.getAllOrderItems());
			dispatcher.forward(request, response);
		}

	}

}
