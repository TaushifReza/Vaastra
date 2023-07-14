package com.vaastra.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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

		String productCat = request.getParameter("parm");
		String productCat2 = request.getParameter("parm2");

		String forward;
		if (productCat.equalsIgnoreCase("Zara")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByBrand(productCat));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("Nike")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByBrand(productCat));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("Gucci")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByBrand(productCat));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("Puma")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByBrand(productCat));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("1") || productCat.equalsIgnoreCase("2") || productCat.equalsIgnoreCase("3")
				|| productCat.equalsIgnoreCase("4") || productCat.equalsIgnoreCase("5")) {
			int rating = Integer.parseInt(productCat);
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByRating(rating));
			patcher.forward(request, response);
		}
		if ((productCat.equalsIgnoreCase("0") && productCat2.equalsIgnoreCase("1000"))
				|| (productCat.equalsIgnoreCase("1000") && productCat2.equalsIgnoreCase("2000"))
				|| (productCat.equalsIgnoreCase("2000") && productCat2.equalsIgnoreCase("3000"))
				|| (productCat.equalsIgnoreCase("3000") && productCat2.equalsIgnoreCase("4000"))
				|| (productCat.equalsIgnoreCase("4000") && productCat2.equalsIgnoreCase("5000"))) {
			int startPrice = Integer.parseInt(productCat);
			int endPrice = Integer.parseInt(productCat2);
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductByPrice(startPrice, endPrice));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("Male") || productCat.equalsIgnoreCase("Female")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProductBySex(productCat));
			patcher.forward(request, response);
		}
		if (productCat.equalsIgnoreCase("allProduct")) {
			forward = "pages/product.jsp";
			RequestDispatcher patcher = request.getRequestDispatcher(forward);
			ProductDao productDao = new ProductDao();
			request.setAttribute("productList", productDao.getAllProduct());
			patcher.forward(request, response);
		}
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
