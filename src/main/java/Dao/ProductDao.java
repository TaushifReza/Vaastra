package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.vaastra.DBConnection.DatabaseConnection;
import com.vaastra.model.Customer.Product;

public class ProductDao {

	private static Connection con = DatabaseConnection.getConnection();

	public List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));
				product.setClothType(set.getString(10));
				product.setSex(set.getString(9));
				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getAllProductByBrand(String brand) {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products WHERE Brand = ?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			pst.setString(1, brand);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getSerchItem(String serchItem) {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products WHERE CONCAT(Name, Brand,Rating, Sex) LIKE ?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			pst.setString(1, "%" + serchItem + "%");

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getAllProductByRating(int rating) {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products WHERE Rating = ?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			pst.setInt(1, rating);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getAllProductByPrice(int startPrice, int endPrice) {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products WHERE Price BETWEEN ? AND ?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			pst.setInt(1, startPrice);
			pst.setInt(2, endPrice);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getAllProductBySex(String sex) {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products WHERE Sex = ?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			pst.setString(1, sex);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getProductForHome() {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products ORDER BY Product_ID DESC ";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				productList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public boolean registerProduct(Product product) {
		boolean flag = false;
		try {
			String query = "INSERT INTO products(Name, Price, Product_img, Brand, Description, Rating, Stock,sex,Cloth_type) VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = ProductDao.con.prepareStatement(query);

			st.setString(1, product.getProductName());
			st.setLong(2, product.getProductPrice());
			st.setString(3, product.getProductImg());
			st.setString(4, product.getBrand());
			st.setString(5, product.getProducrDescription());
			st.setString(6, product.getRating());
			st.setInt(7, product.getStock());
			st.setString(8, product.getSex());
			st.setString(9, product.getClothType());

			st.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteProduct(int id) {

		boolean flag = false;
		try {
			String query = "delete from products where Product_ID=?";

			PreparedStatement st = ProductDao.con.prepareStatement(query);
			st.setInt(1, id);
			;

			st.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	public Product getAllProductByid(int id) {
		Product product = null;
		try {
			String query = "SELECT * FROM products where Product_ID=?";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet set = pst.executeQuery();

			while (set.next()) {
				product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));
				product.setClothType(set.getString(10));
				product.setSex(set.getString(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public boolean UpdateProduct(Product product) {
		boolean flag = false;
		try {
			String query = "Update products set Name=?, Price=?,Brand=?, Description=?, Stock=?,sex=?,Cloth_type=? where Product_id=?";

			PreparedStatement st = ProductDao.con.prepareStatement(query);

			st.setString(1, product.getProductName());
			st.setLong(2, product.getProductPrice());
			st.setString(3, product.getBrand());
			st.setString(4, product.getProducrDescription());
			st.setInt(5, product.getStock());
			st.setString(6, product.getSex());
			st.setString(7, product.getClothType());
			st.setInt(8, product.getProduct_ID());
			st.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// get 5 trending product
	public List<Product> getTrendingProduct() {
		List<Product> trendingProductList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products ORDER BY RAND() LIMIT 5";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				trendingProductList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trendingProductList;
	}

	// get 5 trending product
	public List<Product> getSaleProduct() {
		List<Product> saleProductList = new ArrayList<>();
		try {
			String query = "SELECT * FROM products ORDER BY Price ASC LIMIT 5";

			PreparedStatement pst = ProductDao.con.prepareStatement(query);

			ResultSet set = pst.executeQuery();

			while (set.next()) {
				Product product = new Product();

				product.setProduct_ID(set.getInt(1));
				product.setProductName(set.getString(2));
				product.setProductPrice(set.getInt(3));
				product.setProductImg(set.getString(4));
				product.setBrand(set.getString(5));
				product.setProducrDescription(set.getString(6));
				product.setRating(set.getString(7));
				product.setStock(set.getInt(8));

				saleProductList.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleProductList;
	}

}
