package com.vaastra.model.Customer;

public class AddToCart {

	private int cart_ID;
	private int quantity;
	private int totalPrice;
	private int customer_ID;
	private int product_ID;

	// Constructor
	public AddToCart(int cart_ID, int quantity, int totalPrice, int customer_ID, int product_ID) {
		super();
		this.cart_ID = cart_ID;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.customer_ID = customer_ID;
		this.product_ID = product_ID;
	}

	// Getter and Setter
	public int getCart_ID() {
		return cart_ID;
	}

	public void setCart_ID(int cart_ID) {
		this.cart_ID = cart_ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public int getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
}
