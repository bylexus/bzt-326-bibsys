package frontend;

import java.util.Observable;
import javax.persistence.EntityManager;
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
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
	}
	
	protected void deleteBenutzer(Benutzer b) {
		EntityManager em = DBH.getInst().getEntityManager();
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
	}
}
