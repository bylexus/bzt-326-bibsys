package business.entity;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -2205697479729045531L;
	private String nachname;
	private String vorname;
	private String email;
	private Benutzer benutzer;
	
	
	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	public String getNachname() {
		return this.nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return this.vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void delete() {
		System.out.println("Deleting Person: " + this.getNachname());
	}
	
	
}
