package playground;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import business.entity.Benutzer;
import business.entity.Person;
import frontend.ProgramManager;
import persistence.DBH;

public class AssociationManyToOne {

	public static void main(String[] args) {
		// Holen des Entity Managers und Starten der Transaktion:
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		
		// Holen / Erstellen der "Gehört-Zu"-Entität Person:
		Person p;
		try {
			// Gibts bereits eine existierende Person "Schenkel Alexander"?
			p = em.createQuery("from Person where name = 'Schenkel' and vorname = 'Alexander'", Person.class).getSingleResult();
		} catch (NoResultException r) {
			// Wenn nicht: neu erstellen, persistieren:
			p = new Person();
			p.setName("Schenkel");
			p.setVorname("Alexander");
			Calendar c = Calendar.getInstance();
			c.set(1979, 3, 8);
			p.setGeburtsdatum(c.getTime());
			// JPA: Neue Objekte persistieren:
			em.persist(p);
		}
		
		// Holen der Entität mit der "belongs-To"-Assoziation:
		Benutzer b = em.createQuery("from Benutzer where login = :login", Benutzer.class).setParameter("login", "alex").getSingleResult();
		
		// Setzen der "belongs-To"-Entität:
		b.setPerson(p);
		
		// Ausführen der Transaktion:
		em.getTransaction().commit();
		
		// Kontrolle: kann die "belongsTo"-Entität geladen werden?
		b = em.createQuery("from Benutzer where login = :login", Benutzer.class).setParameter("login", "alex").getSingleResult();
		p = b.getPerson();
		System.out.println("Person: "+p.getId()+": "+p.getName()+", "+p.getVorname());
		
		
		ProgramManager.getInstance().shutdown();
	}
}
