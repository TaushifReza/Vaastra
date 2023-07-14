package com.vaastra.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaastra.model.Customer.Product;

import Dao.ProductDao;

/**
 * Servlet implementation class ProductHomeServlet
 */
@WebServlet("/ProductHomeServlet")
public class ProductHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		// fetch data
		ProductDao productDao = new ProductDao();

		ArrayList<Product> saleProductList = (ArrayList<Product>) productDao.getSaleProduct();

		getServletContext().setAttribute("saleProductList", saleProductList);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "pages/home.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		ProductDao productDao = new ProductDao();
		request.setAttribute("productList", productDao.getProductForHome());
		dispatcher.forward(request, response);
	}

}
