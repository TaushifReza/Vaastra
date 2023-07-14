package com.vaastra.servlet.addToCart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Customer;

import Dao.AddToCartDao;

/**
 * Servlet implementation class AddProductToCartServlet
 */
@WebServlet("/AddProductToCartServlet")
public class AddProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int productId = Integer.parseInt(request.getParameter("productId"));

		// get the referrer URL
		String referer = request.getHeader("referer");

		int quantity = 1;

		// get current customer from session
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("currentCustomer");

		// get current customerId from customer Object
		int customerID = customer.getCustomer_ID();

		AddToCartDao addToCartDao = new AddToCartDao();

		if (addToCartDao.addProductToCart(customerID, productId, quantity)) {
			out.println("Product added to cart");
//			out.println(referer);

			// redirect the user back to the previous page
			response.sendRedirect(referer);
		} else {
			out.println("Product not added to cart");
		}
	}

}
