package frontend.controller.admin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import business.entity.Benutzer;
import frontend.ProgramManager;
import frontend.controller.ConsoleViewController;
import frontend.view.admin.BenutzerErstellenFormView;
import persistence.DBH;

public class BenutzerErstellenFormViewController extends ConsoleViewController<BenutzerErstellenFormView> {
	
	public BenutzerErstellenFormViewController() {
		this.setView(new BenutzerErstellenFormView(ProgramManager.getInstance().getBenutzer()));
	}
	
	@Override
	protected void afterViewShow() {
		BenutzerErstellenFormView view = this.getView();
		if (view.login.equals("")) return;

		// Neuen Benutzer erstellen:
		Benutzer newUser = createBenutzer();
		ProgramManager.getInstance().popCurrent(); // to remove it from stack, so it is not shown again when next view closes
		ProgramManager.getInstance().addNext(new BenutzerFormViewController(newUser));
	}
	
	protected Benutzer createBenutzer() {
		BenutzerErstellenFormView view = this.getView();
		
		Session session = DBH.getInst().openSession();
		Transaction t = session.beginTransaction();
		Benutzer b = new Benutzer();
		b.setLogin(view.login);
		b.setVorname(view.vorname);
		b.setNachname(view.nachname);
		b.setEmail(view.email);
		session.save(b);
		t.commit();
		session.close();
		return b;
	}
}
