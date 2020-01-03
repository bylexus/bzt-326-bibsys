package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MEDIUM")
public class Medium implements Serializable{
	private static final long serialVersionUID = -7700997192162171490L;
	
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
	
	private String titel;
	private int mediennummer;
	
	List<MediumExemplar> exemplare = new ArrayList<MediumExemplar>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medium", orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	public List<MediumExemplar> getExemplare() {
		return exemplare;
	}
	public void setExemplare(List<MediumExemplar> exemplare) {
		this.exemplare = exemplare;
	}

	public int getMediennummer() {
		return mediennummer;
	}
	public void setMediennummer(int mediennummer) {
		this.mediennummer = mediennummer;
	}
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
}
