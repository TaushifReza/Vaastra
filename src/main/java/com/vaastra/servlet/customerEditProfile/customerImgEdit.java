package com.vaastra.servlet.customerEditProfile;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaastra.model.Customer.Customer;

import Dao.CustomerDao;

/**
 * Servlet implementation class customerImgEdit
 */
@WebServlet("/customerImgEdit")
@MultipartConfig
public class customerImgEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public customerImgEdit() {
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Part part = request.getPart("profileImg");

		String originalFileName = Customer.getFileName(part);

		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String newFileName = timeStamp + fileExtension;

		// get user from session
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("currentCustomer");

		// Delete the previous img
		Customer.deleteImg(Customer.IMAGE_DIR_SAVE_PATH + customer.getProfilePic());

		// set new img in customer object
		customer.setProfilePic(newFileName);

		// Update new img to customer database
		CustomerDao customerDao = new CustomerDao();

		// if img update to database redirect to profile page
		if (customerDao.updateCustomerImg(customer)) {

			// Save the image
			part.write(Customer.IMAGE_DIR_SAVE_PATH + File.separator + newFileName);
			// go to profile page
			response.sendRedirect("pages/profile.jsp");
		} else {
			response.sendRedirect("pages/customerImgEdit.jsp");
		}
	}

}
