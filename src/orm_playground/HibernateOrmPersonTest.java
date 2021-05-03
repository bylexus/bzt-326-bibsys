package orm_playground;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import business.ProgramManager;
import business.entity.Person;

public class HibernateOrmPersonTest {

	public static void main(String[] args) {
		
		
		
		ProgramManager pm = ProgramManager.getInstance();
		
		
		
		
		EntityManager em = pm.getEntityManager();
		
		
		
		
		
		
		// Transaktion starten: Sobald wir Entitäten speichern wollen, ist das
		// notwendig:
		em.getTransaction().begin();
		
		
		
		
		Person pers = new Person();
		pers.setName("Skywalker");
		pers.setVorname("Luke");
		pers.setGeburtsdatum(LocalDate.of(1979, 04, 01));

		// Persistieren:
		em.persist(pers);
		
		
		// Vorhandene Personen:
		List<Person> personen = em.createQuery("select p from Person p", Person.class).getResultList();
		for (Person p : personen) {
			System.out.println(String.format("Vorhandene Person: ID %s: %s %s (%s)",
					p.getId(), p.getVorname(), p.getName(), p.getGeburtsdatum()));
		}
		
		
		

		// Transaktion abschliessen:
		em.getTransaction().commit();

		pm.shutdown();
	}
}
