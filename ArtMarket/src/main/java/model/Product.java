package model;

import java.math.BigDecimal;

public class Product {
	public Product(Piece o, Format f, BigDecimal p) {
		super();
		this.o = o;
		this.f = f;
		this.p = p;
	}
	int id;
	Piece o;
	Format f;
	BigDecimal p;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Piece getO() {
		return o;
	}
	public void setO(Piece o) {
		this.o = o;
	}
	public Format getF() {
		return f;
	}
	public void setF(Format f) {
		this.f = f;
	}
	public BigDecimal getP() {
		return p;
	}
	public void setP(BigDecimal p) {
		this.p = p;
	}
}
