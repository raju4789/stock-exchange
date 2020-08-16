package com.iVoyant.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class InpStock {
	
	@Id
	private String order_id;
	private String stock_name;
	private String type;
	private int quantity;
	private int price;
	private String time;
	
	public InpStock() {}
	
	public InpStock(String order_id, String stock_name, String type, int quantity, int price, String time) {
		super();
		this.order_id = order_id;
		this.stock_name = stock_name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.time = time;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "InpStock [order_id=" + order_id + ", stock_name=" + stock_name + ", type=" + type + ", quantity="
				+ quantity + ", price=" + price + ", time=" + time + "]";
	}
	
}
