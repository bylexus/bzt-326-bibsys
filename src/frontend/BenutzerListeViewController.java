package frontend;

import java.util.List;
import javax.persistence.EntityManager;
import business.entity.Benutzer;
import persistence.DBH;

public class BenutzerListeViewController extends ViewController {
	private List<Benutzer> userList;
	
	public BenutzerListeViewController(BenutzerListeView view) {
		super(view);
	}
	
	@Override
	public void beforeViewShow() {
		userList = loadBenutzerListe();
		BenutzerListeView v = (BenutzerListeView)this.getView();
		v.setBenutzerListe(userList);
	};
	
	@Override
	public void afterViewShow() {
		BenutzerListeView view = (BenutzerListeView)this.getView();
		switch (view.getMenuSelection()) {
		case "n":
			// Neuen Benutzer erstellen:
			ProgramManager.getInstance().addNext(new BenutzerErstellenFormView(ProgramManager.getInstance().getBenutzer()));
			 break;
		case "0": break;
		default:
			// ausgewaehlten Benutzer holen, Form-controller starten:
			Benutzer editBenutzer = view.getSelectedBenutzer();
			ProgramManager.getInstance().addNext(new BenutzerFormView(ProgramManager.getInstance().getBenutzer(),editBenutzer));
			break;
		}
	}
	
	protected List<Benutzer> loadBenutzerListe() {
		EntityManager em = DBH.getInst().getEntityManager();
		List<Benutzer> userList = em.createQuery("from Benutzer order by id",Benutzer.class).getResultList();
		return userList;
	}
}
