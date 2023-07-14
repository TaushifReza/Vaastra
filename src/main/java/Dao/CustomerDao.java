package Dao;

import java.sql.*;

import com.vaastra.DBConnection.DatabaseConnection;
import com.vaastra.PasswordEncryption.PasswordEncryptionWithAes;
import com.vaastra.model.Customer.Customer;

public class CustomerDao {

	private static Connection con = DatabaseConnection.getConnection();

	public boolean registerCustomer(Customer customer) {
		boolean flag = false;
		try {
			String query = "INSERT INTO Customers(First_Name, Last_Name, Email, Phone, Password, DOB, Profile_Pic,"
					+ "Gender, Address, Register_Date, User_Name) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = CustomerDao.con.prepareStatement(query);

			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getEmail());
			st.setLong(4, customer.getPhone());
			st.setString(5, customer.getPassword());
			st.setString(6, customer.getDob());
			st.setString(7, customer.getProfilePic());
			st.setString(8, customer.getGender());
			st.setString(9, customer.getAddress());
			st.setString(10, customer.getRegisterDate());
			st.setString(11, customer.getUserName());

			st.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// get customer details by email and password
	public Customer getCustomerEmailPassword(String email, String password) {
		Customer customer = null;
		try {
			String query = "SELECT * FROM customers WHERE Email = ?";

			PreparedStatement pst = CustomerDao.con.prepareStatement(query);
			pst.setString(1, email);

			ResultSet set = pst.executeQuery();

			if (set.next()) {
				customer = new Customer();

				customer.setCustomer_ID(set.getInt("Customer_ID"));

				// data from db
				String firstName = set.getString("First_Name");
				// set to user object
				customer.setFirstName(firstName);

				customer.setLastName(set.getString("Last_Name"));
				customer.setEmail(set.getString("Email"));
				customer.setPhone(set.getLong("Phone"));

				String password1 = set.getString("Password");
				String decryptPassword = PasswordEncryptionWithAes.decrypt(password1, email);
				customer.setPassword(decryptPassword);

				customer.setDob(set.getString("DOB"));
				String profilePicName = set.getString("Profile_Pic");
				customer.setProfilePic(profilePicName);
				customer.setGender(set.getString("Gender"));
				customer.setAddress(set.getString("Address"));
				customer.setRegisterDate(set.getString("Register_Date"));
				customer.setUserName(set.getString("User_Name"));
				customer.setDescription(set.getString("Description"));

				if (decryptPassword != null && set.getString("Email").equals(email)
						&& decryptPassword.equals(password)) {
					return customer;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Update Customer Details
	public boolean updateCustomer(Customer customer) {
		boolean flag = false;
		try {
			String query = "UPDATE customers set First_Name = ?, Last_Name = ?, Phone = ?, DOB = ?, Gender = ?, Address = ?, User_Name = ?, Description = ? WHERE Email = ?";
			PreparedStatement pst = CustomerDao.con.prepareStatement(query);

			pst.setString(1, customer.getFirstName());
			pst.setString(2, customer.getLastName());
			pst.setLong(3, customer.getPhone());
			pst.setString(4, customer.getDob());
			pst.setString(5, customer.getGender());
			pst.setString(6, customer.getAddress());
			pst.setString(7, customer.getUserName());
			pst.setString(8, customer.getDescription());
			pst.setString(9, customer.getEmail());

			pst.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateCustomerImg(Customer customer) {
		boolean flag = false;
		try {
			String query = "UPDATE customers SET Profile_Pic = ? WHERE Email = ?";

			PreparedStatement pst = CustomerDao.con.prepareStatement(query);

			pst.setString(1, customer.getProfilePic());
			pst.setString(2, customer.getEmail());

			pst.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean changePassword(Customer customer, String oldPassword, String newPassword) {
		boolean flag = false;
		try {
			if (customer.getPassword().equals(oldPassword)) {
				String query = "UPDATE customers set Password = ? WHERE Email = ?";

				PreparedStatement pst = CustomerDao.con.prepareStatement(query);

				pst.setString(1, newPassword);
				pst.setString(2, customer.getEmail());

				pst.executeUpdate();

				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean forgetPassword(String email, String newPassword) {
		boolean flag = false;
		try {
			String query = "UPDATE customers set Password = ? WHERE Email = ?";

			PreparedStatement pst = CustomerDao.con.prepareStatement(query);

			pst.setString(1, newPassword);
			pst.setString(2, email);

			pst.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
