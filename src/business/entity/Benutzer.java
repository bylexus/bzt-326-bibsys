package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Benutzer implements Serializable{
	private static final long serialVersionUID = -3927525614383424503L;

	private Long id;
	
	private String login;
	private String passwort;
	boolean admin = false;
	boolean bibMA = false;
	
	
	
	Person person;
	
	List<Medium> ausgelieheneMedien = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean isBibMA() {
		return bibMA;
	}
	
	public void setBibMA(boolean bibMA) {
		this.bibMA = bibMA;
	}
	
	public List<Medium> getAusgelieheneMedien() {
		return ausgelieheneMedien;
	}
	public void setAusgelieheneMedien(List<Medium> ausgelieheneMedien) {
		this.ausgelieheneMedien = ausgelieheneMedien;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	/**
	 * Demo-Funktion zum Löschen dieses Objektes
	 * Hier würden Benutzer-spezifische Operatione durchgeführt, welche
	 * beim Löschen eines Benutzer-Objektes noch anfallen.
	 */
	public void delete() {
		System.out.println("Deleting user: " + this.getLogin());
	}
}
