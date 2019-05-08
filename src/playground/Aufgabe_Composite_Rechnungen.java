package playground;

import java.util.ArrayList;
import java.util.List;

import business.RechnungXmlGenerator;
import business.entity.*;
import persistence.PersonModelManager;

/**
 * Fuer Aufgabe Lektion 9 - Implementation von Kompositionen - Person, Benutzer, Rechnungen
 * Fuer Aufgabe Lektion 11 - Composite-Pattern
 * 
 * - Erzeugt eine Person, dabei gleichzeitig einen Benutzer
 * - Erzeugt 2 Rechnungen von unterschiedlichem Typ
 * - Erzeugt 1 Rechnung mit existierendem Typ --> Fehler
 * 
 * Gibt die Rechnungen als XML aus, unter Verwendung des Composite-Pattern
 *
 */
public class Aufgabe_Composite_Rechnungen {
	public static void main(String[] args) {
		PersonModelManager pm = new PersonModelManager();
		
		// Person erzeugen, erzeugt gleich Benutzer mit:
		Person p = pm.createPerson("Duck", "Donald", "donald@ducks.com");
		Benutzer b = p.getBenutzer();
		
		System.out.println(String.format("Person: %s %s, Benutzer: %s", p.getVorname(), p.getNachname(), b.getLogin()));
		
		// Rechnungen erzeugen:
		List<Rechnung> rechnungen = new ArrayList<Rechnung>();
		Rechnung r = null;
		try {
			r = b.createRechnung(15.5, "Jahresgebuehr");
			r.setBenutzer(b);
			rechnungen.add(r);
			r = b.createRechnung(2.5, "Mahnung");
			r.setBenutzer(b);
			rechnungen.add(r);
			r = b.createRechnung(15.5, "Jahresgebuehr");
			r.setBenutzer(b);
			rechnungen.add(r);
		} catch (Exception e) {
			System.err.println("Oops, Rechnung konnte nicht erzeugt werden:" + e.getMessage());
		}
		
		System.out.println("Rechnungen:");
		for (Rechnung re : b.getRechnungen()) {
			System.out.println(String.format("Nr: %d: %s: CHF %1.2f", re.getRechnungNr(), re.getTyp(), re.getBetrag()));
		}
		
		// Ausgabe mittels Composite-Pattern:
		RechnungXmlGenerator rg = new RechnungXmlGenerator();
		System.out.println(rg.createXml(rechnungen));
		
		
		
		// Person inkl. abhängiger Objekte löschen:
		pm.deletePerson(p);
		p = null;
		
	}
}
