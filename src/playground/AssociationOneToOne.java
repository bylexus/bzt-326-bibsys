package playground;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import business.entity.Ausweis;
import business.entity.Benutzer;
import business.entity.Person;
import frontend.ProgramManager;
import persistence.DBH;

public class AssociationOneToOne {

	public static void main(String[] args) {
		// Holen des Entity Managers und Starten der Transaktion:
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		
		// Holen / Erstellen der "hat-ein"-Entität Ausweis:
		Ausweis a = new Ausweis();
		a.setNummer("123456");
		
		// Holen der Entität mit der "Hat-ein"-Assoziation:
		Benutzer b = em.createQuery("from Benutzer where login = :login", Benutzer.class).setParameter("login", "alex").getSingleResult();
		
		// Setzen der "hat-ein"-Entität:
		b.setAusweis(a);
		
		// Ausführen der Transaktion:
		em.getTransaction().commit();
		
		// Kontrolle: kann die "hat-ein"-Entität geladen werden?
		b = em.createQuery("from Benutzer where login = :login", Benutzer.class).setParameter("login", "alex").getSingleResult();
		a = b.getAusweis();
		System.out.println("Ausweis: "+a.getId()+": "+a.getNummer());
		
		
		ProgramManager.getInstance().shutdown();
	}
}
