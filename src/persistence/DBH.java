package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBH {
	private static DBH _inst;
	
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager em = null;
	
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
			for (StackTraceElement s : e.getStackTrace()) {
				System.err.println(s.toString());
			}
			
		}
	}
	
	public EntityManager getEntityManager() {
		if (this.entityManagerFactory == null) {
			initSessionFactory();
		}
		if (this.em == null) {
			this.em = entityManagerFactory.createEntityManager(); 
		}
		return em;
	}

	
	public void shutdown() {
		if (em != null) {
			em.close();
			em = null;
		}
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
