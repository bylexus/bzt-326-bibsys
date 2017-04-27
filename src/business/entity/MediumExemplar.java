package business.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MediumExemplar")
public class MediumExemplar {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String exemplarNr;
	private Date ausgeliehenAm;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="person_id")
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExemplarNr() {
		return exemplarNr;
	}

	public void setExemplarNr(String exemplarNr) {
		this.exemplarNr = exemplarNr;
	}

	public Date getAusgeliehenAm() {
		return ausgeliehenAm;
	}

	public void setAusgeliehenAm(Date ausgeliehenAm) {
		this.ausgeliehenAm = ausgeliehenAm;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
