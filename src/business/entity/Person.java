package business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String vorname;
	private Date geburtsdatum;
	private String adresse;
	private String plz;
	private String ort;
	
	@OneToMany(mappedBy="person",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Benutzer> benutzer = new ArrayList<>();
	
	@OneToMany(mappedBy="person",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<MediumExemplar> ausleihen = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
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
	public List<Benutzer> getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(List<Benutzer> benutzer) {
		this.benutzer = benutzer;
	}
	
	public List<MediumExemplar> getAusleihen() {
		return this.ausleihen;
	}
	
	public void leiheAus(MediumExemplar m) {
		if (m.getPerson() != this) {
			m.setPerson(this);
			m.setAusgeliehenAm(new Date());
			this.getAusleihen().add(m);
		}
	}
	
	public void gibZurueck(MediumExemplar m) {
		if (m.getPerson() == this && m.getAusgeliehenAm() != null) {
			m.setPerson(null);
			m.setAusgeliehenAm(null);
			this.getAusleihen().remove(m);
		}
	}
}
