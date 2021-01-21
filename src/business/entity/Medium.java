package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import persistence.DataContainer;

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
	private List<Reservation> reservationen = new ArrayList<>();
	
	public Medium() {
	}
	
	public Medium(int mediennummer) {
		this(); // Default-Konstruktor aufrufen
		this.mediennummer = mediennummer;

		/** Hier erstellen wir gleich ein erstes Exemplar: */
		this.createNewExemplar();
	}

	
	private List<MediumExemplar> exemplare = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medium", orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	public List<MediumExemplar> getExemplare() {
		return exemplare;
	}
	public void setExemplare(List<MediumExemplar> exemplare) {
		this.exemplare = exemplare;
	}
	
	/** 
	 * Diese Methode erzeugt ein neues MediumExemplar, als Aufgabe der Kompositions-Hauptklasse Medium.
	 * Sie sorgt für die richtige Numerierung der Exemplare.
	 * @return
	 */
	public MediumExemplar createNewExemplar() {
		int nr = this.getExemplare().size() + 1;
		MediumExemplar ex = new MediumExemplar();
		ex.setExemplarNr(nr);
		ex.setMedium(this);
		ex.setBarcode("code-" + this.getMediennummer() + "-" + nr);
		this.getExemplare().add(ex);
		return ex;
	}
	
	/**
	 * Demonstriert ein Löschen eines Mediums: Wenn das Medium gelöscht wird,
	 * müssen mehrere Schritte passieren:
	 * 
	 * 1. das Medium muss aus der Persistenz-Schicht (sprich: DB) gelöscht werden
	 * 2. Es sollen auch alle Exemplare mitgelöscht werden
	 */
	public void delete() {
		//TODO: Umbau für Hibernate
		/*
		System.out.println("Medium " + this.mediennummer + " wird gelöscht");
		System.out.println("Löschen aller Exemplare ...");
		this.exemplare.forEach(ex -> {
			ex.delete();
		});
		this.exemplare.clear();
		
		// Medium von Persistenz löschen:
		DataContainer.getInst().medienList.remove(this);
		*/
	}
	
	/**
	 * Kompositions-Methode zum Entfernen einex Exemplars
	 * 
	 * Sorgt dafür, dass mind. 1 Exemplar stehen bleibt
	 */
	public void removeExemplar(MediumExemplar ex) {
		// Habe ich das Exemplar in der Liste?
		if (this.exemplare.contains(ex)) {
			// darf ich es löschen? Habe ich dann noch mind. 1?
			if (this.exemplare.size() > 1) {
				this.exemplare.remove(ex);
			} else {
				System.err.println("Oops, nicht möglich: mind. 1 Exemplar muss existieren!");
			}
		}
	}

	
	@Transient
	public List<Reservation> getReservationen() {
		return reservationen;
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
