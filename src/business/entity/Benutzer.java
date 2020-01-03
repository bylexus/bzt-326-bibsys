package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import business.ISerializeXml;

public class Benutzer implements Serializable, ISerializeXml {
	private static final long serialVersionUID = -3927525614383424503L;

	private Long id;
	
	private String login;
	private String email;
	private String passwort;
	boolean admin = false;
	boolean bibMA = false;
	
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
	@Override
	/**
	 * Composite-Methode für XML-Export:
	 * exportiert dieses Element als XML. Für die
	 * Ausgabe der Beziehungen (Person, Ausleihe) wird die
	 * Composite-Methode der Kind-Klassen aufgerufen.
	 */
	public String toXml(int indentation) {
		String inStr = String.format("%"+indentation+"s","");
		ISerializeXml personXml = this.getPerson();
		String personXmlStr = personXml.toXml(indentation + 4);

		String ausleihenXmlStr = "";
		List<? extends ISerializeXml> ausleihenXml = this.getAusgelieheneMedien();
		for (ISerializeXml item : ausleihenXml) {
			ausleihenXmlStr += item.toXml(indentation + 4);
		}
		
		String ret = String.format(
				"%s<benutzer>\n"
				+ "%s<login>%s</login>\n"
				+ "%s%s"
				+ "%s<ausleihen>\n%s%s</ausleihen>\n"
				+ "%s</benutzer>\n",
				inStr,
				inStr,
				this.getLogin(),
				inStr,
				personXmlStr,
				inStr,
				ausleihenXmlStr,
				inStr,
				inStr
				) ;
		return ret;
	}	
}
