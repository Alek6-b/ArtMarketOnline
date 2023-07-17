package model;

public class Format {
	public Format(String name, String size, String material) {
		super();
		this.name = name;
		this.size = size;
		this.material = material;
	}
	String name;
	String size;
	String material;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
