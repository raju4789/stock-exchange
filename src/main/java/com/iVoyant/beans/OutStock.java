package com.iVoyant.beans;

public class OutStock {
	
	private String sell_id;
	private String buy_id;
	private long price;
	private long quantity;
	
	public String getSell_id() {
		return sell_id;
	}
	public void setSell_id(String sell_id) {
		this.sell_id = sell_id;
	}
	public String getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OutStock [sell_id=" + sell_id + ", buy_id=" + buy_id + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
}
