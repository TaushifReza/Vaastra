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
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductSearchServlet() {
		super();

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

		String serchItem = request.getParameter("serchItem");

		String pageName = request.getHeader("referer");

		String forward;
//		if (serchItem == null || serchItem.trim().isEmpty()) {
////			forward = pageName;
////			RequestDispatcher patcher = request.getRequestDispatcher(forward);
////			patcher.forward(request, response);
//			response.sendRedirect(pageName);
//		}
		forward = "pages/product.jsp";
		RequestDispatcher patcher = request.getRequestDispatcher(forward);
		ProductDao productDao = new ProductDao();
		request.setAttribute("productList", productDao.getSerchItem(serchItem));
		patcher.forward(request, response);

	}

}
