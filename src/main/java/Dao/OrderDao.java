package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vaastra.DBConnection.DatabaseConnection;
import com.vaastra.model.Customer.Order;
import com.vaastra.model.Customer.Product;

public class OrderDao {

	public static Connection con = DatabaseConnection.getConnection();

	// add product to order table
	public boolean checkOut(String productName, int customerId, int totalPrice, int quantity) {
		boolean flag = false;
		try {
			String query = "Insert into orders(Product_Name, Customer_ID, Total_Price, Quantity) Values(?,?,?,?)";

			PreparedStatement pst = OrderDao.con.prepareStatement(query);

			pst.setString(1, productName);
			pst.setInt(2, customerId);
			pst.setInt(3, quantity);
			pst.setInt(4, quantity);

			pst.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// get product from order table
	public List<Order> getProductForHome(String email) {
		List<Order> orderlist = new ArrayList<>();
		try {
			String query = "SELECT * FROM orders where (Select Customer_ID from customers where email = ?) order by Order_Date desc limit 5";

			PreparedStatement pst = AddToCartDao.con.prepareStatement(query);

			pst.setString(1, email);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Order order = new Order();

				order.setOrder_ID(set.getInt(1));
				order.setProduct_Name(set.getString(2));
				order.setCustomer_ID(set.getInt(3));
				order.setOrder_Date(set.getString(4));
				order.setTotal_Price(set.getInt(5));
				order.setOrder_Status(set.getString(6));
				order.setQuantity(set.getInt(7));

				orderlist.add(order);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderlist;
	}

	public List<Order> getAllOrderItems() {
		List<Order> orderItem = new ArrayList<>();
		try {
			String query = "SELECT * FROM orders";

			PreparedStatement pst = AddToCartDao.con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Order order = new Order();

				order.setOrder_ID(set.getInt(1));
				order.setProduct_Name(set.getString(2));
				order.setCustomer_ID(set.getInt(3));
				order.setOrder_Date(set.getString(4));
				order.setTotal_Price(set.getInt(5));
				order.setOrder_Status(set.getString(6));
				order.setQuantity(set.getInt(7));

				orderItem.add(order);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItem;
	}
}
