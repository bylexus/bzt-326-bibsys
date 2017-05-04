package frontend;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import business.entity.Benutzer;
import business.entity.MediumExemplar;
import persistence.DBH;

public class TerminalAusleiheViewController extends ViewController {
	Benutzer loggedInUser = null;
	
	public TerminalAusleiheViewController(TerminalAusleiheView view, Benutzer loggedInUser) {
		super(view);
		this.loggedInUser = loggedInUser;
	}
	
	/**
	 * Wir erhalten von der View eine MediumExemplar-Nummer, und suchen diese in der Datenbank:
	 * - anhand der Exemplar
	 * - ist es ausleihbar?
	 * Wenn OK, wird die Ausleihe registriert / gebucht.
	 * 
	 * --> dies ist das Model, auf dem wir arbeiten (MVC)
	 */
	public MediumExemplar leiheAusMitNummer(String exemplarNr) throws Exception {
		MediumExemplar ex = null;
		EntityManager em = DBH.getInst().getEntityManager();
		try {
			// Transkation starten (Notwendig, sobald Daten geändert werden sollen):
			em.getTransaction().begin();
			ex = em.createQuery("SELECT m FROM MediumExemplar m WHERE exemplarNr = :nr",MediumExemplar.class).setParameter("nr", exemplarNr).getSingleResult();
			
			// Prüfen: Kann das Medium ausgeliehen werden?
			if (ex.getAusgeliehenAm() != null) {
				// Medium-Exemplar bereits ausgeliehen - das ist ein Fehler!
				throw new Exception("*** Medium bereits als Ausgeliehen registriert - Bitte melden Sie sich am Schalter.");
			}
			
			// Setze Ausleih-Daten:
			ex.setAusgeliehenAm(new Date());
			ex.setPerson(this.loggedInUser.getPerson());
			
			// Transaktion committen:
			em.getTransaction().commit();
			
		} catch (NoResultException e) {
			// Fehler an View zurückmelden via Exception: Nicht gefunden
			em.getTransaction().rollback();
			throw new Exception("*** Exemplar nicht gefunden - Scannerfehler? ***");
		} catch (Exception e) {
			// Fehler an View zurückmelden via Exception:
			em.getTransaction().rollback();
			throw e;
		}
		
		// ausgeliehenes Exemplar an View zurückgeben
		return ex;
	}
	
	@Override
	public void afterViewShow() {
		// Wenn der User alles eingegeben hat (View wird beended), verlassen wir das Programm:
		ProgramManager.getInstance().shutdown();
	}
}
