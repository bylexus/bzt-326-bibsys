package business.entity;

import java.io.Serializable;

abstract public class Medium implements Serializable{
	private static final long serialVersionUID = -7700997192162171490L;
	
	private Long id;
	private String titel;
	private Benutzer ausgeliehenVon;
	private String barcode;
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public Benutzer getAusgeliehenVon() {
		return ausgeliehenVon;
	}
	public void setAusgeliehenVon(Benutzer ausgeliehenVon) {
		this.ausgeliehenVon = ausgeliehenVon;
	}
}
