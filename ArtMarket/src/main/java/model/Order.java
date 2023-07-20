package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Order implements Comparable<Order> {
	int id;
	String user;
	Date date;
	BigDecimal price;



	String description;

	public Order(int id, String user, Date date, BigDecimal price, String description) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int compareTo(Order o) {
		return this.date.compareTo(date);
	}
}
