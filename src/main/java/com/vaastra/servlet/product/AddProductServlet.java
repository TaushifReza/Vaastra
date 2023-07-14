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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
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

		File fileSaveDir = new File(Product.IMAGE_DIR_SAVE_PATH);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part part = request.getPart("photo");
		String originalFileName = Product.getFileName(part);

		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String newFileName = timeStamp + fileExtension;

		part.write(Product.IMAGE_DIR_SAVE_PATH + File.separator + newFileName);

		Product product = new Product(Name, Integer.parseInt(price), newFileName, brand, desc, "0",
				Integer.parseInt(stock), sex, type);
		ProductDao productDao = new ProductDao();

		if (productDao.registerProduct(product)) {
			response.sendRedirect("pages/addProduct.jsp");
		} else {
			out.println("Something went wrong. Try again!!!");
		}
	}

}
