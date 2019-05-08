package business.entity;

import java.io.Serializable;

import business.RechnungXmlComposite;

public class Person implements Serializable, RechnungXmlComposite{
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

	@Override
	/**
	 * Aufgabe aus Lektion 11 - Composite: XML mittels Composite-Pattern implementieren
	 */
	public String createXml(int indent) {
		String indentStr = String.format(indent > 0 ? "%"+indent+"s" : "", " ");
		String innerIndentStr = String.format("%" + (indent + 4) +"s", " ");
		
		String res = indentStr + "<person>\n";
		res += innerIndentStr + "<name>"+this.getNachname()+"</name>\n";
		res += innerIndentStr + "<vorname>"+this.getVorname()+"</vorname>\n";
		res += innerIndentStr + "<email>"+this.getEmail()+"</email>\n";
		
		res += indentStr + "</person>\n";
		return res;
	}
}
