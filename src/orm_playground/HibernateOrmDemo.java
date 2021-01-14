package orm_playground;

import java.util.List;

import javax.persistence.EntityManager;

import business.ProgramManager;
import business.entity.Benutzer;

public class HibernateOrmDemo {

	public static void main(String[] args) {
		ProgramManager pm = ProgramManager.getInstance();
		EntityManager em = pm.getEntityManager();
		
		// Laden von Entitäten - hier findet ORM statt!
		List<Benutzer> benutzerliste = pm.getEntityManager().createQuery("select b from Benutzer b",Benutzer.class).getResultList();
		
		// Transaktion starten: Sobald wir Entitäten speichern wollen, ist das notwendig:
		em.getTransaction().begin();
		if (benutzerliste.size() == 0) {
			// Beispielbenutzer anlegen
			Benutzer b = new Benutzer();
			b.setLogin("benutzer1");
			b.setPasswort("1");
			
			// Persistieren in DB:
			em.persist(b);
			
			// Noch einer:
			b = new Benutzer();
			b.setLogin("benutzer2");
			b.setPasswort("2");
			
			// Persistieren in DB:
			em.persist(b);
		} else {
			// Vorhandene Benutzer ausgeben:
			for (Benutzer b : benutzerliste) {
				System.out.println(String.format("Vorhandener Benutzer: ID %s (%s)",b.getId(),b.getLogin()));
			}
		}
		
		// Transaktion abschliessen:
		em.getTransaction().commit();
		
		
		pm.shutdown();
	}

}
