package playground;

import javax.persistence.EntityManager;

import business.entity.MediumExemplar;
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
		MediumExemplar b1 = new MediumExemplar(); b1.setExemplarNr("1");
		MediumExemplar b2 = new MediumExemplar(); b2.setExemplarNr("2");
		
		// Ausleihen --> Zuordnen der many-Entitäten an die 1-Entität Person:
		p.leiheAus(b1);
		p.leiheAus(b2);
		
		// Ausführen der Transaktion:
		em.getTransaction().commit();
		
		// Kontrolle: können die "hasMany"-Entitäten geladen werden?
		p = em.createQuery("from Person where name = 'Schenkel' and vorname = 'Alexander'", Person.class).getSingleResult();
		for(MediumExemplar b : p.getAusleihen() ) {
			System.out.println("MediumExemplar: "+b.getId()+": "+b.getExemplarNr());
		}
		
		ProgramManager.getInstance().shutdown();
	}
}
