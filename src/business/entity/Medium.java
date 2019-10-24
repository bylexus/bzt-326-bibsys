package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract public class Medium implements Serializable{
	private static final long serialVersionUID = -7700997192162171490L;
	
	private Long id;
	private String titel;
	private int mediennummer;
	List<MediumExemplar> exemplare = new ArrayList<MediumExemplar>();
	
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
}
