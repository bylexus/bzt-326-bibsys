package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Benutzer implements Serializable{
	private static final long serialVersionUID = -3927525614383424503L;

	private Long id;
	
	private String login;
	private String email;
	private String passwort;
	boolean admin = false;
	boolean bibMA = false;
	
	List<Reservation> reservationen = new ArrayList<>();
	
	public List<Reservation> getReservationen() {
		return reservationen;
	}
	Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	List<Ausleihe> ausgelieheneMedien = new ArrayList<>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	public List<Ausleihe> getAusgelieheneMedien() {
		return ausgelieheneMedien;
	}
	public void setAusgelieheneMedien(List<Ausleihe> ausgelieheneMedien) {
		this.ausgelieheneMedien = ausgelieheneMedien;
	}	
}
