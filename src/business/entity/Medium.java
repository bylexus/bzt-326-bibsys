package business.entity;

import javax.persistence.*;

@Entity
@Table(name="Medium")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="typ")
abstract public class Medium {
	private Long id;
	private String titel;
	private Benutzer ausgeliehenVon;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="ausgeliehen_benutzer_id")
	public Benutzer getAusgeliehenVon() {
		return ausgeliehenVon;
	}
	public void setAusgeliehenVon(Benutzer ausgeliehenVon) {
		this.ausgeliehenVon = ausgeliehenVon;
	}
}
