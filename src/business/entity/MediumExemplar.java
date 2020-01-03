package business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medium_exemplar")
public class MediumExemplar implements Serializable{
	private static final long serialVersionUID = 6652066929809879914L;
	
	private Long id;
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	Medium medium;
	@ManyToOne
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	int exemplarNr;
	
	boolean istAusleihbar = true;
	String barcode;
	
	
	private Ausleihe ausleihe;
	@Transient
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
	@Transient
	public boolean istAusleihbar() {
		return this.ausleihe == null;
	}
	public void setIstAusleihbar(boolean istAusleihbar) {
		this.istAusleihbar = istAusleihbar;
	}
	
}
