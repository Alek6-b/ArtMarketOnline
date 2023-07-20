package model;

import java.math.BigDecimal;

public class Product {
	public Product() {
		
	}
	public Product(int opera, String formato, BigDecimal prezzo) {
		super();
		this.piece = opera;
		this.format = formato;
		this.price = prezzo;
	}
	int id;
	int piece;
	String format;
	BigDecimal price;
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	
}
