package com.vaastra.model.Customer;

import java.io.File;

import javax.servlet.http.Part;

public class Customer {

	private int Customer_ID;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String password;
	private String dob;
	private String profilePic;
	private String gender;
	private String address;
	private String registerDate;
	private String userName;
	private String description;

	// Constructor without customer ID
	public Customer(String firstName, String lastName, String email, long phone, String password, String dob,
			String profilePic, String gender, String address, String registerDate, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.dob = dob;
		this.profilePic = profilePic;
		this.gender = gender;
		this.address = address;
		this.registerDate = registerDate;
		this.userName = userName;
	}

	// Constructor with customer ID
	public Customer(int customer_ID, String firstName, String lastName, String email, long phone, String password,
			String dob, String profilePic, String gender, String address, String registerDate, String userName) {
		super();
		Customer_ID = customer_ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.dob = dob;
		this.profilePic = profilePic;
		this.gender = gender;
		this.address = address;
		this.registerDate = registerDate;
		this.userName = userName;
	}

	public Customer() {
		super();
	}

	// Getter Setter
	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static final String IMAGE_DIR = "xampp\\tomcat\\webapps\\Vaastra\\CustomersImg\\";
	public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR;

	public static String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	// Delete file
	public static boolean deleteImg(String path) {
		boolean flag = false;
		try {
			File file = new File(path);
			flag = file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
