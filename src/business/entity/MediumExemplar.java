package business.entity;

import java.io.Serializable;

public class MediumExemplar implements Serializable{
	private static final long serialVersionUID = 6652066929809879914L;
	int exemplarNr;
	Medium medium;
	boolean istAusleihbar = true;
	String barcode;
	private Ausleihe ausleihe;
	
	public Ausleihe getAusleihe() {
		return ausleihe;
	}
	public void setAusleihe(Ausleihe ausleihe) {
		this.ausleihe = ausleihe;
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getExemplarNr() {
		return exemplarNr;
	}
	public void setExemplarNr(int exemplarNr) {
		this.exemplarNr = exemplarNr;
	}
	public boolean istAusleihbar() {
		return this.ausleihe == null;
	}
	public void setIstAusleihbar(boolean istAusleihbar) {
		this.istAusleihbar = istAusleihbar;
	}
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
}
