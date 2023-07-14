package com.vaastra.servlet.signup;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vaastra.PasswordEncryption.PasswordEncryptionWithAes;
import com.vaastra.model.Customer.Customer;

import Dao.CustomerDao;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
@MultipartConfig
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");

		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String phone1 = request.getParameter("phone");
		long phone = Long.parseLong(phone1);

		String password = PasswordEncryptionWithAes.encrypt(email, request.getParameter("password"));

		String gender = request.getParameter("gender");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String registerDate = formatter.format(date);

		File fileSaveDir = new File(Customer.IMAGE_DIR_SAVE_PATH);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part part = request.getPart("profilePic");
		String originalFileName = Customer.getFileName(part);

		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String newFileName = timeStamp + fileExtension;

		part.write(Customer.IMAGE_DIR_SAVE_PATH + File.separator + newFileName);

		Customer customer = new Customer(firstName, lastName, email, phone, password, dob, newFileName, gender, address,
				registerDate, userName);

		CustomerDao customerDao = new CustomerDao();

		if (customerDao.registerCustomer(customer)) {
			out.println("You have registered successfully.");
		} else {
			out.println("Something went wrong. Try again!!!");
		}
	}

}
