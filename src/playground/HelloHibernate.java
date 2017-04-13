package playground;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import business.entity.Benutzer;
import business.entity.Buch;
import business.entity.Medium;


public class HelloHibernate {
	public static void main(String[] args) {
		EntityManagerFactory sessionFactory = null;
		try {
			sessionFactory = Persistence.createEntityManagerFactory("BibSys");
		}
		catch (Exception e) {
			System.err.println("Oooops, DB Error!");
			System.err.println(e.getMessage());
		}
		
		
		
		
		
		
		EntityManager session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        List<Benutzer> result = session.createQuery( "from Benutzer",Benutzer.class ).getResultList();
		for ( Benutzer benutzer : (List<Benutzer>) result ) {
			System.out.println( "Benutzer (" + benutzer.getLogin() + ") : " + benutzer.getId() );
		}
		System.out.println("Output done");
		
		Buch b1 = new Buch();
		b1.setTitel("Ender's Game");
		b1.setIsbn("1232349234234");
		
		
		Benutzer ben1 = session.find(Benutzer.class, 1L);
		/*ben1.setLogin("fooo");
		session.persist(ben1);*/
		
		//b1.setAusgeliehenVon(ben1);
		session.persist(b1);
		
		/*Benutzer ben6 = session.find(Benutzer.class, 6L);*/
		
        session.getTransaction().commit();
        System.out.println("Transaction commited");
        
        
        
        session.close();
        System.out.println("Session closed");
        
        b1.setTitel("Geänderter Titel");
        

        session = sessionFactory.createEntityManager();
        session.getTransaction().begin();
        session.persist(session.merge(b1));
        session.getTransaction().commit();
        session.close();
        
        
        session = sessionFactory.createEntityManager();
        List<Buch> result2 = session.createQuery( "from Buch",Buch.class ).getResultList();
		for ( Buch buch : (List<Buch>) result2 ) {
			System.out.println( "Bucg (" + buch.getTitel() + ") : " + buch.getId() );
		}
        session.close();
        sessionFactory.close();
	}
}
