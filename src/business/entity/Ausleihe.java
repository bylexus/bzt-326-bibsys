package business.entity;

import java.io.Serializable;
import java.util.Date;

import business.ISerializeXml;

public class Ausleihe implements Serializable, ISerializeXml {
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
	
	@Override
	/**
	 * Composite-Methode des Person-Objektes
	 */
	public String toXml(int indentation) {
		String inStr = String.format("%"+indentation+"s","");
		String inStr2 = String.format("%"+(indentation+4)+"s","");
		
		String ret = String.format(
				"%s<ausleihe>\n"
				+ "%s<von>%s</von\n"
				+ "%s<bis>%s</bis>\n"
				+ "%s</ausleihe>\n",
				inStr,
				inStr2,
				this.getAusgeliehenAm(),
				inStr2,
				this.getAusgeliehenBis(),
				inStr
				) ;
		return ret;
	}
}
