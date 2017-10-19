package business.entity;

import java.io.Serializable;

public class Autor implements Serializable{
	private static final long serialVersionUID = -2417465929359572604L;
	
	private String nachname;
	private String vorname;
	
	
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}
