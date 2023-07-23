package model;

import java.math.BigDecimal;

public class Product {
	public Product() {
		
	}
	public Product(int id,Piece opera, String formato, BigDecimal prezzo) {
		this.id=id;
		this.piece = opera;
		this.format = formato;
		this.price = prezzo;
	}
	public Product(Piece opera, String formato, BigDecimal prezzo) {
		this.id=-1;
		this.piece = opera;
		this.format = formato;
		this.price = prezzo;
	}

	int id;
	Piece piece;
	String format;
	BigDecimal price;
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
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
