package frontend.controller.admin;

import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import business.entity.Benutzer;
import frontend.ProgramManager;
import frontend.controller.ConsoleViewController;
import frontend.view.admin.BenutzerFormView;
import persistence.DBH;

public class BenutzerFormViewController extends ConsoleViewController<BenutzerFormView> implements Observer {
	
	public BenutzerFormViewController(Benutzer editBenutzer) {
		BenutzerFormView v = new BenutzerFormView(ProgramManager.getInstance().getBenutzer());
		v.addObserver(this);
		v.setEditBenutzer(editBenutzer);
		this.setView(v);
	}
	
	
	@Override
	protected void afterViewShow() {
		switch (view.getMenuSelection()) {
		case "d": break;
			
		case "0": break;
		default:
			
			break;
		}
		view.deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object event) {
		if (o == this.getView()) {
			if (event == BenutzerFormView.ACTION.SAVE) {
				storeBenutzer(this.getView().getEditBenutzer());
			}
			if (event == BenutzerFormView.ACTION.DELETE) {
				deleteBenutzer(this.getView().getEditBenutzer());
				this.getView().setEditBenutzer(null);
			}
		}
	}
	
	protected void storeBenutzer(Benutzer b) {
		Session session = DBH.getInst().openSession();
		Transaction t = session.beginTransaction();
		session.update(b);
		session.save(b);
		t.commit();
		session.close();
	}
	
	protected void deleteBenutzer(Benutzer b) {
		Session session = DBH.getInst().openSession();
		Transaction t = session.beginTransaction();
		session.delete(b);
		t.commit();
		session.close();
	}
}
