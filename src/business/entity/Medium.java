package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import business.PrintListComposite;

abstract public class Medium implements Serializable, PrintListComposite {
	private static final long serialVersionUID = -7700997192162171490L;
	
	private Long id;
	private String titel;
	private String mediennummer;
	
	private List<MediumExemplar> exemplare = new ArrayList<MediumExemplar>();
	
	public List<MediumExemplar> getExemplare() {
		return exemplare;
	}
	public void setExemplare(List<MediumExemplar> exemplare) {
		this.exemplare = exemplare;
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
	
	public String getMediennummer() {
		return mediennummer;
	}
	public void setMediennummer(String mediennummer) {
		this.mediennummer = mediennummer;
	}
}
