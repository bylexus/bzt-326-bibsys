package playground;

import javax.persistence.EntityManager;
import business.entity.Benutzer;
import business.entity.Person;
import frontend.ProgramManager;
import persistence.DBH;

public class AssociationOneToMany {

	public static void main(String[] args) {
		// Holen des Entity Managers und Starten der Transaktion:
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		
		// Holen / Erstellen der "hat-viele"-Entität Person:
		Person p;
		p = em.createQuery("from Person where name = 'Schenkel' and vorname = 'Alexander'", Person.class).getSingleResult();
		
		// Hinzufügen von neuen "many"-Entitäten:
		Benutzer b1 = new Benutzer(); b1.setLogin("b1");b1.setPerson(p);
		Benutzer b2 = new Benutzer(); b2.setLogin("b2");b2.setPerson(p);
		
		p.getBenutzer().add(b1);
		p.getBenutzer().add(b2);
		
		// Ausführen der Transaktion:
		em.getTransaction().commit();
		
		// Kontrolle: können die "hasMany"-Entitäten geladen werden?
		p = em.createQuery("from Person where name = 'Schenkel' and vorname = 'Alexander'", Person.class).getSingleResult();
		for(Benutzer b : p.getBenutzer() ) {
			System.out.println("Benutzer: "+b.getId()+": "+b.getLogin());
		}
		
		ProgramManager.getInstance().shutdown();
	}
}
