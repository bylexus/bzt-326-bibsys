package business.entity;

import javax.persistence.*;

@Entity
public class Buch extends Medium {
	public static int ausleihTage = 30;
	
	private String isbn;
	private Autor autor;
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Embedded()
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
