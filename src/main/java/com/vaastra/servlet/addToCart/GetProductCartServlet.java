package com.vaastra.servlet.addToCart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.AddToCart;
import com.vaastra.model.Customer.Customer;

import Dao.AddToCartDao;
import Dao.OrderDao;
import Dao.ProductDao;

/**
 * Servlet implementation class GetProductCartServlet
 */
@WebServlet("/GetProductCartServlet")
public class GetProductCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProductCartServlet() {
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

		String forward;
		if (parm.equalsIgnoreCase("getAllCartItems")) {

			// get current customer from session
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("currentCustomer");

			// get current customerId from customer Object
			int customerID = customer.getCustomer_ID();

			forward = "pages/addToCart.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			AddToCartDao addToCartDao = new AddToCartDao();
			request.setAttribute("cartList", addToCartDao.getAllCartProduct(customerID));
			dispatcher.forward(request, response);
		}
		if (parm.equalsIgnoreCase("deleteCartItem")) {
			// get the referrer URL
			String referer = request.getHeader("referer");
			int cartId = Integer.parseInt(request.getParameter("parm1"));

			AddToCartDao addToCartDao = new AddToCartDao();

			if (addToCartDao.deleteCartProduct(cartId)) {

				response.sendRedirect(referer);
			} else {
				out.println("Not deleted");
			}
		}
		if (parm.equalsIgnoreCase("checkOut")) {
//			parm1=${cartID}&parm2=${productName}&parm3=${productPrice}&parm4=${prductQuantity}
			int cartID = Integer.parseInt(request.getParameter("parm1"));
			String productName = request.getParameter("parm2");
			int productPrice = Integer.parseInt(request.getParameter("parm3"));
			int prductQuantity = Integer.parseInt(request.getParameter("parm4"));
			String referer = request.getHeader("referer");

			// get user from session
			HttpSession session = request.getSession();

			Customer customer = (Customer) session.getAttribute("currentCustomer");

			int customerId = customer.getCustomer_ID();

			OrderDao orderDao = new OrderDao();

			if (orderDao.checkOut(productName, customerId, productPrice, prductQuantity)) {
				AddToCartDao addToCart = new AddToCartDao();
				out.println("product added");
				if (addToCart.deleteCartProduct(cartID)) {
					response.sendRedirect(referer);
				} else {
					// error
					out.println("product added and cart not deleted");
				}
			} else {
				// error
				out.println("product not");
			}
		}
	}
}
