package business.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Autor {
	private String nachname;
	private String vorname;
	
	
	@Column(name="autor_nachname")
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	@Column(name="autor_vorname")
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
