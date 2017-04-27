package frontend;

import javax.persistence.EntityManager;

import business.entity.Benutzer;
import persistence.DBH;

public class TerminalLoginViewController extends ViewController {
	// MVC: Das Model, auf dem wir arbeiten werden:
	Benutzer loggedInUser = null;
	
	public TerminalLoginViewController(TerminalLoginView view) {
		super(view);
	}
	
	public void credentialsEntered(String ausweisNr) {
		if (ausweisNr.equals("")) {
			ProgramManager.getInstance().shutdown();
		}
		loggedInUser = this.loadBenutzer(ausweisNr);
	}
	
	protected Benutzer loadBenutzer(String ausweisNr) {
		Benutzer b = null;
		EntityManager em = DBH.getInst().getEntityManager();
		
		// MVC: Wir holen uns das Model, auf dem wir arbeiten wollen:
		try {
			b = em
					// Query über einen Wert der "fremdem" Entität Ausweis (Benutzer hat Ausweis)
					// Siehe Beispiel: https://en.wikibooks.org/wiki/Java_Persistence/Querying#Joining.2C_querying_on_a_OneToMany_relationship
				.createQuery("SELECT b from Benutzer b JOIN b.ausweis a where a.nummer = :nr", Benutzer.class)
				.setParameter("nr", ausweisNr)
				.getSingleResult();
		} catch(Exception e) {
			loggedInUser = null;
		}
		return b;
	}
	
	@Override
	public void beforeViewShow() {
		ProgramManager.getInstance().setBenutzer(null);
	};
	
	@Override
	public void afterViewShow() {
		ProgramManager.getInstance().setBenutzer(loggedInUser);
		ProgramManager.getInstance().addNext(new RoleSelectView(loggedInUser));
	}
	
	public Benutzer getLoggedInUser() {
		return loggedInUser;
	}
}
