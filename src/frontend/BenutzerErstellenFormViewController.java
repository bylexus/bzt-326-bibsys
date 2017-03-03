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
		
		EntityManager session = DBH.getInst().openSession();
		session.getTransaction().begin();
		Benutzer b = new Benutzer();
		b.setLogin(view.login);
		b.setVorname(view.vorname);
		b.setNachname(view.nachname);
		b.setEmail(view.email);
		session.persist(b);
		session.getTransaction().commit();
		session.close();
		return b;
	}
}
