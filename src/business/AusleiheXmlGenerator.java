package business;

import java.util.List;

import business.entity.Benutzer;

public class AusleiheXmlGenerator {
	List<? extends ISerializeXml> benutzerListe;
	
	public AusleiheXmlGenerator(List<Benutzer> benutzerliste) {
		this.benutzerListe = benutzerliste;
	}
	
	public String createXml() {
		
		String benutzer = "";
		for (ISerializeXml s : benutzerListe) {
			benutzer += s.toXml(4);
		}
		String s = "<benutzerliste>\n"+ benutzer + "</benutzerliste>\n";
		return s;
	}
}
