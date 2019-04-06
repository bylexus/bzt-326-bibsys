package playground;

import business.entity.Benutzer;
import business.entity.Person;
import persistence.BenutzerMM;
import persistence.DataContainer;

/**
 * Dieses Programm migriert die bestehenden Benutzer benutzer1-3:
 * Es erstellt ein Person-Objekt zum Benutzer-Account.
 * 
 */
public class Benutzer1_to_3_Migration {

	public static void main(String[] args) {
		BenutzerMM bm = new BenutzerMM();
		
		Benutzer benutzer1 = bm.findUserByLogin("benutzer1", "1");
		Benutzer benutzer2 = bm.findUserByLogin("benutzer2", "2");
		Benutzer benutzer3 = bm.findUserByLogin("benutzer3", "3");
		
		if (benutzer1 != null && benutzer1.getPerson() == null) {
			System.out.println("Migriere benutzer1...");
			Person p = new Person();
			p.setVorname("Alex");
			p.setNachname("Schenkel");
			p.setEmail("a@alexi.ch");
			benutzer1.setPerson(p);
		}
		if (benutzer2 != null && benutzer2.getPerson() == null) {
			System.out.println("Migriere benutzer2...");
			Person p = new Person();
			p.setVorname("Luke");
			p.setNachname("Skywalker");
			p.setEmail("luke@tatooine.org");
			benutzer2.setPerson(p);
		}
		if (benutzer3 != null && benutzer3.getPerson() == null) {
			System.out.println("Migriere benutzer3...");
			Person p = new Person();
			p.setVorname("Chuck");
			p.setNachname("Norris");
			p.setEmail("i-am-the-internet@me.com");
			benutzer3.setPerson(p);
		}
		
		// Daten persistieren:
		DataContainer.getInst().shutdown();
	}
}
