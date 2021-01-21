package orm_playground;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import business.ProgramManager;
import business.entity.Benutzer;
import business.entity.Medium;
import business.entity.MediumExemplar;
import business.entity.Person;

public class HibernateOrmDemo {

	public static void main(String[] args) {
		ProgramManager pm = ProgramManager.getInstance();
		EntityManager em = pm.getEntityManager();

		/** *********************** Benutzer - Personen ********************* */

		List<Person> personen = pm.getEntityManager()
				.createQuery("select p from Person p LEFT JOIN FETCH p.benutzer", Person.class).getResultList();

		// Transaktion starten: Sobald wir Entitäten speichern wollen, ist das
		// notwendig:
		em.getTransaction().begin();
		if (personen.size() == 0) {
			// Beispiel Personen mit Benutzer anlegen:
			for (int i = 1; i <= 5; i++) {
				Person p = new Person();
				p.setName("Name " + i);
				p.setVorname("Vorname " + i);
				p.setGeburtsdatum(LocalDate.of(1979, 04, 01));

				// Benutzer anlegen und zuweisen:
				Benutzer b = new Benutzer();
				b.setLogin("benutzer" + i);
				b.setPasswort(Integer.toString(i));
				// Objektmodell in beide Richtungen aktualisieren:
				p.setBenutzer(b);
				b.setPerson(p);

				// Persistieren:
				em.persist(p);
			}
		} else {
			// Vorhandene Prsonen mit Benutzern ausgeben:
			for (Person p : personen) {
				System.out.println(String.format("Vorhandene Person: ID %s: %s %s (%s), Benutzer: ID %s (%s)",
						p.getId(), p.getVorname(), p.getName(), p.getGeburtsdatum(), p.getBenutzer().getId(),
						p.getBenutzer().getLogin()));
			}
		}

		// Transaktion abschliessen:
		em.getTransaction().commit();

		/** *********************** Medium - Exemplare ********************* */
		em.getTransaction().begin();
		List<Medium> medien = em.createQuery("SELECT m FROM Medium m", Medium.class).getResultList();

		if (medien.size() == 0) {
			for (int i = 1; i <= 5; ++i) {
				Medium m = new Medium();
				m.setTitel("Medium #" + i);
				for (int j = 1; j <= 5; ++j) {
					MediumExemplar ex = new MediumExemplar();
					ex.setBarcode(j + "-" + j + "-" + j);
					ex.setMedium(m);
					m.getExemplare().add(ex);
				}
				em.persist(m);
			}
		} else {
			// Vorhandene Medien mit Exemplaren ausgeben:
			for (Medium m : medien) {
				System.out.println(String.format("Medium: %s: %s, Exemplare: %s", m.getId(), m.getTitel(),
						m.getExemplare().size()));
				for (MediumExemplar me : m.getExemplare()) {
					System.out.println(String.format("  Ex: %s, Barcode: %s", me.getId(), me.getBarcode()));
				}
			}
		}

		em.getTransaction().commit();
		pm.shutdown();
	}
}
