package business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="kategorie")
public class Kategorie {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy="kategorien")
	private List<Medium> medien = new ArrayList<>();

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
	
	public List<Medium> getMedien() {
		return this.medien;
	}
	
	public void addMedium(Medium m) {
		if (!this.getMedien().contains(m)) {
			this.getMedien().add(m);
			m.addKategorie(this);
		}
	}
	
	public void removeMedium(Medium m) {
		if (this.getMedien().contains(this)) {
			this.getMedien().remove(m);
			m.removeKategorie(this);
		}
	}
}
