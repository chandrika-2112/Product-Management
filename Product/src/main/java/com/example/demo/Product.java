package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	@Id
	private int pid;
	private String name;
	private String image;
	private int costPrice;
	private int quantity;
	private String origin;
	
	private float profit;
	private int sellPrice;
	private float gst;
	private int amount;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String name, String image, int costPrice, int quantity, String origin, float profit,
			int sellPrice, float gst, int amount) {
		super();
		this.pid = pid;
		this.name = name;
		this.image = image;
		this.costPrice = costPrice;
		this.quantity = quantity;
		this.origin = origin;
		this.profit = profit;
		this.sellPrice = sellPrice;
		this.gst = gst;
		this.amount = amount;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", image=" + image + ", costPrice=" + costPrice
				+ ", quantity=" + quantity + ", origin=" + origin + ", profit=" + profit + ", sellPrice=" + sellPrice
				+ ", gst=" + gst + ", amount=" + amount + "]";
	}
	
	
}
