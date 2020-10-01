package business.entity;

import java.io.Serializable;
import java.util.Date;

public class Ausleihe implements Serializable {
	private static final long serialVersionUID = 4145415894922804116L;
	Date ausgeliehenAm;
	Date ausgeliehenBis;
	Date zurueckAm;
	
	MediumExemplar exemplar;
	Benutzer benutzer;
	public Date getAusgeliehenAm() {
		return ausgeliehenAm;
	}
	public void setAusgeliehenAm(Date ausgeliehenAm) {
		this.ausgeliehenAm = ausgeliehenAm;
	}
	public Date getAusgeliehenBis() {
		return ausgeliehenBis;
	}
	public void setAusgeliehenBis(Date ausgeliehenBis) {
		this.ausgeliehenBis = ausgeliehenBis;
	}
	public Date getZurueckAm() {
		return zurueckAm;
	}
	public void setZurueckAm(Date zurueckAm) {
		this.zurueckAm = zurueckAm;
	}
	public MediumExemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(MediumExemplar exemplar) {
		this.exemplar = exemplar;
	}
	public Benutzer getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
}
