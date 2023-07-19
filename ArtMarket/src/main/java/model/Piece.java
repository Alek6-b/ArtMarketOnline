package model;

public class Piece {
	public Piece() {
		super();
	}
	int id;
	String title;
	String author;
	String imageSource;
	public Piece(int id, String title, String author, String imageSource) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.imageSource = imageSource;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	
}
