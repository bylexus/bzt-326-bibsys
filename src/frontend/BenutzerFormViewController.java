package frontend;

import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import business.entity.Benutzer;
import persistence.DBH;

public class BenutzerFormViewController extends ViewController {
	
	public BenutzerFormViewController(BenutzerFormView view) {
		super(view);
	}
	
	
	@Override
	public void afterViewShow() {
		BenutzerFormView view = (BenutzerFormView)this.getView(); 
		switch (view.getMenuSelection()) {
		case "d": break;
			
		case "0": break;
		default:
			
			break;
		}
	}

	@Override
	public void update(Observable o, Object event) {
		BenutzerFormView view = (BenutzerFormView)this.getView();
		
		super.update(o, event);
		if (o == this.getView()) {
			if (event == BenutzerFormView.ACTION.SAVE) {
				storeBenutzer(view.getEditBenutzer());
			}
			if (event == BenutzerFormView.ACTION.DELETE) {
				deleteBenutzer(view.getEditBenutzer());
				view.setEditBenutzer(null);
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
