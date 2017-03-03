package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBH {
	private static DBH _inst;
	
	private EntityManagerFactory entityManagerFactory = null;
	
	public static DBH getInst() {
		if (DBH._inst == null) {
			DBH._inst = new DBH();
		}
		return DBH._inst;
	}
	
	private DBH() {
	}
	
	private void initSessionFactory() {
		try {
			// A EntityManagerFactory is set up once for an application!
			entityManagerFactory = Persistence.createEntityManagerFactory("BibSys");
		}
		catch (Exception e) {
			System.err.println("Oooops, DB Error!");
			System.err.println(e.getMessage());
		}
	}
	
	public EntityManager openSession() {
		if (this.entityManagerFactory == null) {
			initSessionFactory();
		}
		return entityManagerFactory.createEntityManager();
	}

	
	public void shutdown() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
	}
	
	public void finalize() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}
