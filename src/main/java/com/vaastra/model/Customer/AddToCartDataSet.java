package com.vaastra.model.Customer;

public class AddToCartDataSet {

//	SELECT c.Cart_ID,p.Product_Img,p.Name,p.Price, c.Quantity, c.Total_Price
//	FROM cart c
//	JOIN products p ON c.Product_ID = p.Product_ID
//	JOIN customers cu ON c.Customer_ID = cu.Customer_ID
//	WHERE cu.Email = "taushif1teza@gmail.com";

	private int cartId;
	private String productImage;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private int productTotalPrice;

	// Constructor
	public AddToCartDataSet() {
		super();
	}

	// Getter and Setter
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProducttotalPrice() {
		return productTotalPrice;
	}

	public void setProducttotalPrice(int producttotalPrice) {
		this.productTotalPrice = producttotalPrice;
	}

}
