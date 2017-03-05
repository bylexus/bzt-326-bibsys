package frontend;

import javax.persistence.EntityManager;

import business.entity.Benutzer;
import persistence.DBH;

public class BenutzerErstellenFormViewController extends ViewController {
	
	public BenutzerErstellenFormViewController(BenutzerErstellenFormView view) {
		super(view);
	}
	
	@Override
	public void afterViewShow() {
		BenutzerErstellenFormView view = (BenutzerErstellenFormView)this.getView();
		if (view.login.equals("")) return;

		// Neuen Benutzer erstellen:
		Benutzer newUser = createBenutzer();
		ProgramManager.getInstance().popCurrentView(); // to remove it from stack, so it is not shown again when next view closes
		ProgramManager.getInstance().addNext(new BenutzerFormView(ProgramManager.getInstance().getBenutzer(),newUser));
	}
	
	protected Benutzer createBenutzer() {
		BenutzerErstellenFormView view = (BenutzerErstellenFormView)this.getView();
		
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		Benutzer b = new Benutzer();
		b.setLogin(view.login);
		b.setVorname(view.vorname);
		b.setNachname(view.nachname);
		b.setEmail(view.email);
		em.persist(b);
		em.getTransaction().commit();
		return b;
	}
}
