package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.vaastra.DBConnection.DatabaseConnection;
import com.vaastra.model.Customer.AddToCartDataSet;

public class AddToCartDao {

	public static Connection con = DatabaseConnection.getConnection();

	// add product to cart
	public boolean addProductToCart(int customerId, int producrId, int quantity) {
		boolean flag = false;
		try {
			String mainQuery = "Insert into cart(Quantity, Total_Price, Customer_ID, Product_ID) values(?, ?, ?, ?)";
			String subQuery = "SELECT Price FROM products WHERE Product_ID = ?";

			PreparedStatement subPst = AddToCartDao.con.prepareStatement(subQuery);

			subPst.setInt(1, producrId);

			ResultSet set = subPst.executeQuery();

			int productPrice;
			if (set.next()) {
				productPrice = set.getInt(1);
			} else {
				return flag;
			}

			int totalPrice = quantity * productPrice;

			PreparedStatement mainPst = AddToCartDao.con.prepareStatement(mainQuery);

			mainPst.setInt(1, quantity);
			mainPst.setInt(2, totalPrice);
			mainPst.setInt(3, customerId);
			mainPst.setInt(4, producrId);

			mainPst.executeUpdate();

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// get cart product in array list
	public List<AddToCartDataSet> getAllCartProduct(int customerID) {
		List<AddToCartDataSet> cartList = new ArrayList<>();
		try {
			String query = "SELECT c.Cart_ID,p.Product_Img,p.Name,p.Price, c.Quantity, c.Total_Price\r\n"
					+ "FROM cart c\r\n" + "JOIN products p ON c.Product_ID = p.Product_ID\r\n"
					+ "JOIN customers cu ON c.Customer_ID = cu.Customer_ID\r\n" + "WHERE cu.Customer_ID = ?";
			PreparedStatement pst = AddToCartDao.con.prepareStatement(query);

			pst.setInt(1, customerID);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				AddToCartDataSet addToCartDataSet = new AddToCartDataSet();

				addToCartDataSet.setCartId(set.getInt(1));
				addToCartDataSet.setProductImage(set.getString(2));
				addToCartDataSet.setProductName(set.getString(3));
				addToCartDataSet.setProductPrice(set.getInt(4));
				addToCartDataSet.setProductQuantity(set.getInt(5));
				addToCartDataSet.setProducttotalPrice(set.getInt(6));

				cartList.add(addToCartDataSet);

				// Debug print statement
//				System.out.println("Got cart item: " + addToCartDataSet.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	// Delete product from cart
	public boolean deleteCartProduct(int cartId) {
		boolean flag = false;
		try {
			String query = "DELETE FROM cart WHERE Cart_ID = ?";

			PreparedStatement pst = AddToCartDao.con.prepareStatement(query);

			pst.setInt(1, cartId);

			pst.executeUpdate();

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
