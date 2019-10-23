package prototyping;

import java.text.SimpleDateFormat;

import business.entity.Benutzer;
import business.entity.Person;
import persistence.DataContainer;
import persistence.PersonManager;

public class TestPersonManager {

	public static void main(String[] args) throws Exception {
		/**
		 * Wir testen hier die Facade-Klasse PersonManager:
		 * 
		 * Beim Erstellen einer Person soll auch gleich ein zugehöriger Benutzer
		 * (1:1-Beziehung mit Person) erstellt werden, und die Verknüpfung dazwischen
		 * korrekt hergestellt werden.
		 */
		DataContainer dc = DataContainer.getInst();
		
		// Instanzieren eines PersonManager-Objektes:
		PersonManager pm = new PersonManager();
		
		// Erstellen einer Person via PersonManager:
		Person p = pm.createPerson("Schenkel", "Alexander", new SimpleDateFormat("yyyy-MM-dd").parse("1979-04-08"));
		Benutzer b = p.getBenutzer();
		
		System.out.println("Person erstellt: " + p.getName() + " " + p.getVorname());
		System.out.println("Benutzer erstellt: " + b.getLogin()+ ": " + b.getId());
		System.out.println("Traversierbarkeit Benutzer->Person: " + b.getPerson().getName());
		
		// Löschen eines Person-Objektes:
		// Auch hier setzen wir wirder auf die Facade-Klasse PersonManager, welche alle notwendige
		//Business-Logik übernimmt:
		System.out.println("... und wieder Löschen der Person:");
		pm.deletePerson(p);
		System.out.println("In DataContainer.personList: " + dc.personList.contains(p));
		System.out.println("In DataContainer.benutzerList: " + dc.benutzerList.contains(b));
		
		
		DataContainer.getInst().shutdown();
	}
}
