package com.vaastra.servlet.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vaastra.model.Customer.Product;

import Dao.ProductDao;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String Name = request.getParameter("name");
		String stock = request.getParameter("stock");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String sex = request.getParameter("sex");
		String type = request.getParameter("type");
		String desc = request.getParameter("description");
		String photo = request.getParameter("photo");
		int id = Integer.parseInt(request.getParameter("id"));

		Product product = new Product(id, Name, Integer.parseInt(price), photo, brand, desc, "0",
				Integer.parseInt(stock), sex, type);
		ProductDao productDao = new ProductDao();

		if (productDao.UpdateProduct(product)) {
			String referer = request.getHeader("referer");

			response.sendRedirect("pages/productList.jsp");

//			out.println(referer);
		} else {
			out.println("Something went wrong. Try again!!!");
		}

	}

}
