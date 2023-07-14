package com.vaastra.model.Customer;

import java.io.File;

import javax.servlet.http.Part;

public class Product {

	private int Product_ID;
	private String productName;
	private int productPrice;
	private String productImg;
	private String brand;
	private String producrDescription;
	private String rating;
	private int stock;
	private String sex;
	private String clothType;

	/*
	 * public Product(int product_ID, String productName, int productPrice, String
	 * productImg, String brand, String producrDescription, String rating, int
	 * stock, String sex, String ClothType) { super(); this.Product_ID = product_ID;
	 * this.productName = productName; this.productPrice = productPrice;
	 * this.productImg = productImg; this.brand = brand; this.producrDescription =
	 * producrDescription; this.rating = rating; this.stock = stock; this.sex = sex;
	 * this.clothType = ClothType; }
	 */

	public Product(String productName, int productPrice, String productImg, String brand, String producrDescription,
			String rating, int stock, String sex, String ClothType) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.brand = brand;
		this.producrDescription = producrDescription;
		this.rating = rating;
		this.stock = stock;
		this.sex = sex;
		this.clothType = ClothType;
	}

	public Product(int product_ID, String productName, int productPrice, String productImg, String brand,
			String producrDescription, String rating, int stock, String sex, String clothType) {
		super();
		Product_ID = product_ID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.brand = brand;
		this.producrDescription = producrDescription;
		this.rating = rating;
		this.stock = stock;
		this.sex = sex;
		this.clothType = clothType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClothType() {
		return clothType;
	}

	public void setClothType(String clothType) {
		this.clothType = clothType;
	}

	// Constructor without product ID
	public Product(String productName, int productPrice, String productImg, String brand, String producrDescription,
			String rating, int stock) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.brand = brand;
		this.producrDescription = producrDescription;
		this.rating = rating;
		this.stock = stock;
	}

	// Constructor with product ID
	public Product(int product_ID, String productName, int productPrice, String productImg, String brand,
			String producrDescription, String rating, int stock) {
		super();
		Product_ID = product_ID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.brand = brand;
		this.producrDescription = producrDescription;
		this.rating = rating;
		this.stock = stock;
	}

	// Empty Constructor
	public Product() {
		super();
	}

	// Getter Setter
	public int getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProducrDescription() {
		return producrDescription;
	}

	public void setProducrDescription(String producrDescription) {
		this.producrDescription = producrDescription;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static final String IMAGE_DIR = "xampp\\tomcat\\webapps\\Vaastra\\ProductImg\\";
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
}
