package playground;

import javax.persistence.EntityManager;

import business.entity.Buch;
import business.entity.Kategorie;
import business.entity.Medium;
import frontend.ProgramManager;
import persistence.DBH;

public class AssociationManyToMany {

	public static void main(String[] args) {
		// Holen des Entity Managers und Starten der Transaktion:
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		
		Buch b = new Buch();
		b.setTitel("A long story shortly told");
		Kategorie k1 = new Kategorie(); k1.setName("Krimi"); em.persist(k1);
		Kategorie k2 = new Kategorie(); k2.setName("Romanze"); em.persist(k2);
		
		b.addKategorie(k1);
		b.addKategorie(k2);
		
		em.persist(b);
		
		// Ausführen der Transaktion:
		em.getTransaction().commit();
		
		// Kontrolle: kann die "belongsTo"-Entität geladen werden?
		b = em.find(Buch.class, b.getId());
		for (Kategorie k : b.getKategorien()) {
			System.out.println("Kategorie: "+k.getId()+": "+k.getName());
		}
		
		// alle Bücher einer Kategorie ausgeben (Hier: Krimi):
		System.out.println("Medien der Kategorie "+k1.getId()+": "+k1.getName());
		for (Medium m : k1.getMedien()) {
			System.out.println("Medium: "+m.getId()+": "+m.getTitel());
		}
		ProgramManager.getInstance().shutdown();
	}
}
