package business.entity;

import java.io.Serializable;

import business.Toolbox;

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
	@Override
	public String createHtml(int indent) {
		String indentStr = Toolbox.repeatStr(" ", indent);
		String indentStr2 = Toolbox.repeatStr(" ", indent + 4);
		String ret = indentStr + "<div class='buch'>\n";
		ret += indentStr2 + String.format("'%s', von %s %s (ISBN: %s)\n", this.getTitel(), this.getAutor().getVorname(), this.getAutor().getNachname(), this.getIsbn());
		return ret + indentStr + "</div>\n";
	}
}
