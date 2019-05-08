package business.entity;

import java.io.Serializable;
import java.util.Date;

import business.RechnungXmlComposite;

public class Rechnung implements Serializable, RechnungXmlComposite{
	private static long nextRechnungNr = 1;
	
	private static final long serialVersionUID = -2205697479724545511L;
	private long rechnungNr;
	private Date rechnungDatum;
	private String typ;
	private double betrag;
	private Date bezahltAm;
	
	private Benutzer benutzer;
	
	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}


	public Rechnung() {
		this.setRechnungNr(Rechnung.nextRechnungNr++);
		this.setRechnungDatum(new Date());
	}
	
	
	public long getRechnungNr() {
		return rechnungNr;
	}
	public void setRechnungNr(long rechnungNr) {
		this.rechnungNr = rechnungNr;
	}
	public Date getRechnungDatum() {
		return rechnungDatum;
	}
	public void setRechnungDatum(Date rechnungDatum) {
		this.rechnungDatum = rechnungDatum;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public double getBetrag() {
		return betrag;
	}
	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
	public Date getBezahltAm() {
		return bezahltAm;
	}
	public void setBezahltAm(Date bezahltAm) {
		this.bezahltAm = bezahltAm;
	}
	
	public void delete() {
		System.out.println("Deleting Rechnung: " + this.getRechnungNr());
	}


	@Override
	/**
	 * Aufgabe aus Lektion 11 - Composite: XML mittels Composite-Pattern implementieren
	 */
	public String createXml(int indent) {
		String identStr = String.format(indent > 0 ? "%"+indent+"s" : "", " ");
		String innerIndentStr = String.format("%" + (indent + 4) +"s", " ");
		
		// Ausgabe des Rechnung-Tags
		String res = identStr + "<rechnung>\n";
		
		// Ausgabe der Rechnugs-eigenen Informationen:
		res += innerIndentStr + "<rechnungNr>"+this.rechnungNr+"</rechnungNr>\n";
		res += innerIndentStr + "<rechnungDatum>"+this.rechnungDatum+"</rechnungDatum>\n";
		res += innerIndentStr + "<typ>"+this.typ+"</typ>\n";
		res += innerIndentStr + "<betrag>"+this.betrag+"</betrag>\n";
		
		// Ausgabe der abhängigen Knoten
		if (this.getBenutzer() != null) {
			res += this.getBenutzer().createXml(indent + 4);
		}
		res += identStr + "</rechnung>\n";
		return res;
	}
}
