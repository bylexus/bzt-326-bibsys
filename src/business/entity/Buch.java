package business.entity;

import java.io.Serializable;

public class Buch extends Medium implements Serializable{
	private static final long serialVersionUID = 2638816301465844779L;

	public static int ausleihTage = 30;
	
	private String isbn;
	private Autor autor;
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
