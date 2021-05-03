package com.ssafy.book.dto;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn 			;
	private String title 			;
	private String catalogue 		;
	private String nation 			;
	private String publish_date 	;
	private String publisher 		;
	private String author 			;
	private int    price 			;
	private String currency 		;
	private String description 	    ;
	public Book() {}
	
	public Book(String isbn, String title, String publisher, String author, int price, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", catalogue=")
				.append(catalogue).append(", nation=").append(nation).append(", publish_date=").append(publish_date)
				.append(", publisher=").append(publisher).append(", author=").append(author).append(", price=")
				.append(price).append(", currency=").append(currency).append(", description=").append(description)
				.append("]");
		return builder.toString();
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}




