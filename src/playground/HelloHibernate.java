package playground;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import business.entity.Benutzer;
import business.entity.Buch;
import business.entity.Medium;


public class HelloHibernate {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		
		
		
		
		
		
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Benutzer> result = session.createQuery( "from Benutzer" ).getResultList();
		for ( Benutzer benutzer : (List<Benutzer>) result ) {
			System.out.println( "Benutzer (" + benutzer.getLogin() + ") : " + benutzer.getId() );
		}
		System.out.println("Output done");
		
		/*Buch b1 = new Buch();
		b1.setTitel("Ender's Game");
		b1.setIsbn("1232349234234");
		
		
		Benutzer ben1 = new Benutzer();
		ben1.setLogin("fooo");
		session.persist(ben1);
		
		b1.setAusgeliehenVon(ben1);
		session.persist(b1);
		*/
		
		Benutzer ben6 = session.load(Benutzer.class, 6L);
		
        session.getTransaction().commit();
        System.out.println("Transaction commited");
        session.close();
        System.out.println("Session closed");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(ben6);
        for (Medium m : ben6.getAusgelieheneMedien()) {
        	System.out.println("Medium: "+m.getId()+":"+m.getTitel());
        	m.setAusgeliehenVon(null);
        }
        
        session.delete(ben6);
        session.getTransaction().commit();
        session.close();
        
        
        
        sessionFactory.close();
	}
}
