package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Standort implements Serializable {
	private Long id;
	private String name;
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
		if (this.medien.contains(m)) {
			return;
		}
		this.medien.add(m);
	}
}
