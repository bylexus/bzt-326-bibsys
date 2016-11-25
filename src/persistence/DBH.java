package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBH {
	private static DBH _inst;
	
	private SessionFactory sessionFactory = null;
	
	public static DBH getInst() {
		if (DBH._inst == null) {
			DBH._inst = new DBH();
		}
		return DBH._inst;
	}
	
	private DBH() {
	}
	
	private void initSessionFactory() {
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
	}
	
	public Session openSession() {
		if (this.sessionFactory == null) {
			initSessionFactory();
		}
		return sessionFactory.openSession();
	}

	
	public void shutdown() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
	
	public void finalize() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
