package business.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ausweis")
public class Ausweis {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="austestellt_am")
	
	private Date ausgestelltAm;
	@Column(unique=true)
	private String nummer;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAusgestelltAm() {
		return ausgestelltAm;
	}
	public void setAusgestelltAm(Date ausgestelltAm) {
		this.ausgestelltAm = ausgestelltAm;
	}
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	

}
