package playground;

import business.entity.Person;
import persistence.DataContainer;
import persistence.PersonModelManager;

/**
 * Löscht eine Person mit zugehörigem Benutzer, 
 * und speichert diese Änderung persistent.
 * 
 */
public class PersonLoeschen {

	public static void main(String[] args) {
		DataContainer dc = DataContainer.getInst();
		PersonModelManager pm = new PersonModelManager();
		
		//Person via Login laden:
		Person p = pm.findPersonByLogin("BW8724.0");
		if (p != null) {
			// Person löschen:
			pm.deletePerson(p);
			
			System.out.println("Person gelöscht");	
		}
		
		// Persistieren:
		dc.shutdown();
	}
}
