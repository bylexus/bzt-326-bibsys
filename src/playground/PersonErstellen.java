package playground;

import business.entity.Person;
import persistence.DataContainer;
import persistence.PersonModelManager;

/**
 * Erstellt eine Person mit zugehörigem Benutzer und Passwort, 
 * und speichert diese persistent.
 * 
 */
public class PersonErstellen {

	public static void main(String[] args) {
		DataContainer dc = DataContainer.getInst();
		PersonModelManager pm = new PersonModelManager();
		
		// Person erstellen (lassen):
		Person p = pm.createPerson("Willlis", "Bruce", "bruce@willis.com");
		
		// Kontrolle:
		System.out.println("Person erstellt:");
		System.out.println(
			String.format("%s %s (%s)",
				p.getVorname(),
				p.getNachname(),
				p.getEmail()
		));
		System.out.println("Zugehörige Benutzerdaten:");
		System.out.println("Username: " + p.getBenutzer().getLogin());
		System.out.println("Passwort: " + p.getBenutzer().getPasswort());
		
		// Persistieren:
		dc.shutdown();
	}
}
