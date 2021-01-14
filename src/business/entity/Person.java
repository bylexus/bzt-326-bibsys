package business.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business.ISerializeXml;

public class Person implements Serializable, ISerializeXml{
	private static final long serialVersionUID = -8731847388527114130L;
	
	String name;
	String vorname;
	LocalDate   geburtsdatum;
	String adresse;
	String plz;
	String ort;
	String email;
	Benutzer benutzer;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Benutzer getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Override
	/**
	 * Composite-Methode des Person-Objektes
	 */
	public String toXml(int indentation) {
		String inStr = String.format("%"+indentation+"s","");
		String inStr2 = String.format("%"+(indentation+4)+"s","");
		
		String ret = String.format(
				"%s<person>\n"
				+ "%s<name>%s</name\n"
				+ "%s<vorname>%s</vorname>\n"
				+ "%s<adresse>%s</adresse>\n"
				+ "%s</person>\n",
				inStr,
				inStr2,
				this.getName(),
				inStr2,
				this.getVorname(),
				inStr2,
				this.getAdresse(),
				inStr
				) ;
		return ret;
	}
}
