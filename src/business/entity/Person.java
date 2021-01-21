package business.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import business.ISerializeXml;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable, ISerializeXml {
	private static final long serialVersionUID = -8731847388527114130L;

	private Long id;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	String name;
	String vorname;
	LocalDate geburtsdatum;
	String adresse;
	String plz;
	String ort;
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Benutzer benutzer;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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
		String inStr = String.format("%" + indentation + "s", "");
		String inStr2 = String.format("%" + (indentation + 4) + "s", "");

		return String.format(
				"%s<person>\n" + "%s<name>%s</name\n" + "%s<vorname>%s</vorname>\n" + "%s<adresse>%s</adresse>\n"
						+ "%s</person>\n",
				inStr, inStr2, this.getName(), inStr2, this.getVorname(), inStr2, this.getAdresse(), inStr);
	}
}
