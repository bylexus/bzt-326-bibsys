package business.entity;

import java.io.Serializable;
import java.util.Date;

public class Rechnung implements Serializable{
	private static long nextRechnungNr = 1;
	
	private static final long serialVersionUID = -2205697479724545511L;
	private long rechnungNr;
	private Date rechnungDatum;
	private String typ;
	private double betrag;
	private Date bezahltAm;
	
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
}
