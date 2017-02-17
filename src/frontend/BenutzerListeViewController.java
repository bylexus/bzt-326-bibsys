package frontend;

import java.util.List;

import org.hibernate.Session;

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
		Session session = DBH.getInst().openSession();
		List<Benutzer> userList = (List<Benutzer>)session.createQuery("from Benutzer order by id").getResultList();
		session.close();
		return userList;
	}
}
