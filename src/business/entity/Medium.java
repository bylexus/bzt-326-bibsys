package business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Medium")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, name="typ")
abstract public class Medium {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany
	@JoinTable(
			name="medium_kategorie",
			joinColumns=@JoinColumn(name="medium_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="kategorie_id", referencedColumnName="id")
    )
	private List<Kategorie> kategorien = new ArrayList<>();
	
	private String titel;
	
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
	public List<Kategorie> getKategorien() {
		return kategorien;
	}
	public void setKategorien(List<Kategorie> kategorien) {
		this.kategorien = kategorien;
	}
}
