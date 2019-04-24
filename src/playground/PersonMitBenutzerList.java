package playground;

import business.entity.Benutzer;
import business.entity.Person;
import persistence.DataContainer;

public class PersonMitBenutzerList {
	public static void main(String[] args) {
		DataContainer dc = DataContainer.getInst();
		
		System.out.println("Liste der Personen");
		System.out.println("=========================================");
		for (Person p2:dc.personList) {
			System.out.println(String.format("%s %s (%s)", 
					p2.getVorname(),
					p2.getNachname(),
					p2.getEmail()));
		}
		
		
		System.out.println("Liste der Benutzer mit zugehöriger Person");
		System.out.println("=========================================");
		for (Benutzer b : dc.benutzerList) {
			Person p = b.getPerson();
			if (p != null) {
				System.out.println(String.format("Benutzer: %s (%s), Person: %s %s (%s)", 
						b.getLogin(),
						b.getPasswort(),
						p.getVorname(),
						p.getNachname(),
						p.getEmail()));
			} else {
				System.out.println(String.format("Benutzer ohne Person: %s", b.getLogin()));
			}
		}
	}
}
