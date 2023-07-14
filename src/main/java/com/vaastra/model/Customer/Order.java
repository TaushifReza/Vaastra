package com.vaastra.model.Customer;

public class Order {

	// Order_ID Product_ID Product_Name Customer_ID Order_Date Total_Price
	// Order_Status Quantity

	private int Order_ID;
	private String Product_Name;
	private int Customer_ID;
	private String Order_Date;
	private int Total_Price;
	private String Order_Status;
	private int Quantity;

	public Order(int order_ID, String product_Name, int customer_ID, String order_Date, int total_Price,
			String order_Status, int quantity) {
		super();
		Order_ID = order_ID;
		Product_Name = product_Name;
		Customer_ID = customer_ID;
		Order_Date = order_Date;
		Total_Price = total_Price;
		Order_Status = order_Status;
		Quantity = quantity;
	}

	public Order() {
		super();
	}

	public int getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(int order_ID) {
		Order_ID = order_ID;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}

	public int getTotal_Price() {
		return Total_Price;
	}

	public void setTotal_Price(int total_Price) {
		Total_Price = total_Price;
	}

	public String getOrder_Status() {
		return Order_Status;
	}

	public void setOrder_Status(String order_Status) {
		Order_Status = order_Status;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
