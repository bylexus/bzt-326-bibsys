package playground;

import business.entity.*;
import persistence.PersonModelManager;

/**
 * Fuer Aufgabe Lektion 9 - Implementation von Kompositionen - Person, Benutzer, Rechnungen
 * 
 * - Erzeugt eine Person, dabei gleichzeitig einen Benutzer
 * - Erzeugt 2 Rechnungen von unterschiedlichem Typ
 * - Erzeugt 1 Rechnung mit existierendem Typ --> Fehler
 *
 */
public class PersonBenutzerRechnungTest {
	public static void main(String[] args) {
		PersonModelManager pm = new PersonModelManager();
		
		Person p = pm.createPerson("Duck", "Donald", "donald@ducks.com");
		Benutzer b = p.getBenutzer();
		
		System.out.println(String.format("Person: %s %s, Benutzer: %s", p.getVorname(), p.getNachname(), b.getLogin()));
		
		// Rechnungen erzeugen:
		try {
			Rechnung r1 = b.createRechnung(15.5, "Jahresgebuehr");
			Rechnung r2 = b.createRechnung(2.5, "Mahnung");
			Rechnung r3 = b.createRechnung(15.5, "Jahresgebuehr");
			
		} catch (Exception e) {
			System.err.println("Oops, Rechnung konnte nicht erzeugt werden:" + e.getMessage());
		}
		
		System.out.println("Rechnungen:");
		for (Rechnung r : b.getRechnungen()) {
			System.out.println(String.format("Nr: %d: %s: CHF %1.2f", r.getRechnungNr(), r.getTyp(), r.getBetrag()));
		}
		
		
		// Person inkl. abhängiger Objekte löschen:
		pm.deletePerson(p);
		p = null;
		
	}
}
