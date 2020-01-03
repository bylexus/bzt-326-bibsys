package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import business.ISerializeXml;

@Entity
@Table(name = "BENUTZER")
public class Benutzer implements Serializable  {
	private static final long serialVersionUID = -3927525614383424503L;

	private Long id;
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	private String login;
	private String email;
	private String passwort;
	boolean admin = false;
	boolean bibMA = false;
	
	@Transient
	Person person;
	
	
	@Transient
	List<Ausleihe> ausgelieheneMedien = new ArrayList<>();
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
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
	
	@Transient
	public List<Ausleihe> getAusgelieheneMedien() {
		return ausgelieheneMedien;
	}
	
	public void setAusgelieheneMedien(List<Ausleihe> ausgelieheneMedien) {
		this.ausgelieheneMedien = ausgelieheneMedien;
	}
}
