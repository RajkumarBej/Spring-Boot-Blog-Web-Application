package in.su.main.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BlogAppDb")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String tittle;
	@Column
	private String content;
	@Column
	private String author;
	@Column
	private Date date;
	
	public User() {
		this.date = Date.valueOf(LocalDate.now());
	}
	public User(String tittle, String content, String author) {
		this.tittle = tittle;
		this.content=content;
		this.author = author;
	}
	public long getId() {
		return id;
	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate() {
		this.date =Date.valueOf(LocalDate.now());
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", tittle=" + tittle + ", content=" + content + ", author=" + author + ", date=" + date
				+ "]";
	}
	
}
