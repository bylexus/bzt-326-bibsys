package prototyping;

import java.util.List;

import business.AusleiheXmlGenerator;
import business.entity.Benutzer;
import persistence.DataContainer;

public class TestCompositeBenutzerAusleiheListeXml {

	public static void main(String[] args) {
		DataContainer dc = DataContainer.getInst();
		List<Benutzer> benutzer = dc.benutzerList;
		
		AusleiheXmlGenerator xmlGen = new AusleiheXmlGenerator(benutzer);
		
		String xml = xmlGen.createXml();
		System.out.println(xml);
		
	}
}
