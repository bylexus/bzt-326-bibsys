package persistence;

import java.util.Date;

import business.entity.Benutzer;
import business.entity.Person;

public class PersonManager extends ModelManager<Person> {
	
	/**
	 * Diese Facade-Methode übernimmt das Erstellen einer Person: Sie übernimmt das
	 * korrekte Erstellen der notwendigen Entitäten (Person- und Benutzer-Objekt),
	 * und kapselt / versteckt somit die notwendigen komplexen Schritte dieser Aktion.
	 * 
	 * Zurück erhält man ein Person-Objekt mit dazugehörigem Benutzer.
	 */
	public Person createPerson(String name, String vorname, Date geburtsdatum) {
		Person p = new Person();
		p.setName(name);
		p.setVorname(vorname);
		p.setGeburtsdatum(geburtsdatum);
		this.store(p);
		return p;
	}
	
	/**
	 * Hier wird die gesamte Business-Logik zum Löschen einer Person abgehandelt, wie:
	 * - sicherstellen, dass keine offenen Ausleihen / Rechnungen mehr vorhanden sind
	 * - Löschen des zugehörigen Benutzer-Objektes
	 * - Entfernen aus der Datenbank
	 * @param p
	 * @throws Exception 
	 */
	public void deletePerson(Person p) throws Exception {
		Benutzer b = p.getBenutzer();
		DataContainer dc = DataContainer.getInst();
		
		// Ausleihen prüfen:
		if (b.getAusgelieheneMedien().size() > 0) {
			throw new Exception("Person hat noch offene Ausleihen");
		}
		
		// Objekt-Links löschen:
		b.setPerson(null);
		p.setBenutzer(null);
		
		// aus DB entfernen:
		dc.benutzerList.remove(b);
		dc.personList.remove(p);
	}

	@Override
	public void store(Person entity) {
		
		if (!this.getDataContainer().personList.contains(entity)) {
			this.getDataContainer().personList.add(entity);
		}

		if (entity.getBenutzer() == null) {
			BenutzerMM benutzerManager = new BenutzerMM();
			Benutzer b = benutzerManager.createBenutzer(entity);
			entity.setBenutzer(b);	
		}
	}
}
