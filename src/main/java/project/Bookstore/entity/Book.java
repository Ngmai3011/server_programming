package project.Bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(name="Title")
	private  String title; 
	
	@Column(name="Author")
	private String author; 
	
	@Column(name="Year")
	private Integer year; 
	
	@Column(name="ISBN")
	private String isbn; 
	
	@Column(name="Price")
	private Float price;
	
	public Book() { } 
	
	public Book(Long id, String author, String title, String isbn, Integer year) {
		super();
		this.id=id;
		this.author=author;
		this.title=title;
		this.year=year;
		this.isbn=isbn;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	@Override
	 public String toString() {
	 return "Book id = " + id + ", author = " + author + ", title = " + title + ", year = " + year + ", isbn = " + isbn;
	 }
}

