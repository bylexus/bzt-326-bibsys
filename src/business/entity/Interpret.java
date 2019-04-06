package business.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Interpret implements Serializable{
	private static final long serialVersionUID = 8170896098991979418L;
	private String name;
	private String vorname;
	private String geburtsdatum;
	private List<Medium> werke = new ArrayList<>();
	
	public Interpret(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public List<Medium> getWerke() {
		return werke;
	}
	
	public void addWerk(Medium m) {
		if (this.werke.contains(m) != true) {
			this.werke.add(m);
		}
	}
}
