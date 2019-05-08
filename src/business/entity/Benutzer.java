package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import business.RechnungXmlComposite;

public class Benutzer implements Serializable, RechnungXmlComposite{
	private static final long serialVersionUID = -1735997746554873279L;

	private Long id;
	
	private String login;
	private String passwort;
	boolean admin = false;
	boolean bibMA = false;
	
	Person person;
	List<Rechnung> rechnungen = new ArrayList<>();
	List<MediumExemplar> ausgelieheneMedien = new ArrayList<>();
	
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
	
	public List<MediumExemplar> getAusgelieheneMedien() {
		return ausgelieheneMedien;
	}
	public void setAusgelieheneMedien(List<MediumExemplar> ausgelieheneMedien) {
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
		for (Rechnung r : this.rechnungen) {
			r.delete();
		}
		System.out.println("Deleting user: " + this.getLogin());
	}
	
	/**
	 * Erzeugt eine neue Rechnung für den Benutzer, wobei geprüft wird:
	 * - es darf nur 1 offene Rechnung pro Typ (und Nutzer) geben
	 * 
	 * @throws Exception
	 */
	public Rechnung createRechnung(Double betrag, String typ) throws Exception {
		// Pruefen, ob noch eine offene Rechnung vom selben Typ bereits vorhanden ist:
		for (Rechnung r : this.rechnungen) {
			if (r.getBezahltAm() == null && typ.equals(r.getTyp())) {
				throw new Exception("Offene Rechnug vom selben Typ vorhanden!");
			}
		}
		// OK, wir erstellen die Rechnung:
		Rechnung r = new Rechnung();
		r.setBetrag(betrag);
		r.setTyp(typ);
		this.rechnungen.add(r);
		return r;
	}
	public List<Rechnung> getRechnungen() {
		return rechnungen;
	}
	
	
	@Override
	/**
	 * Aufgabe aus Lektion 11 - Composite: XML mittels Composite-Pattern implementieren
	 */
	public String createXml(int indent) {
		String indentStr = String.format(indent > 0 ? "%"+indent+"s" : "", " ");
		String innerIndentStr = String.format("%" + (indent + 4) +"s", " ");
		
		String res = indentStr + "<benutzer>\n";
		res += innerIndentStr + "<login>"+this.getLogin()+"</login>\n";
		res += innerIndentStr + "<istBibMitarbeiter>"+this.isBibMA()+"</istBibMitarbeiter>\n";
		if (this.getPerson() != null) {
			res += this.getPerson().createXml(indent + 4);
		}
		res += indentStr + "</benutzer>\n";
		return res;
	}
}
