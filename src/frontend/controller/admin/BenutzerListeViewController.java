package frontend.controller.admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import business.entity.Benutzer;
import frontend.ProgramManager;
import frontend.controller.ConsoleViewController;
import frontend.controller.admin.AdminMenuViewController;
import frontend.controller.user.AusleiheListViewController;
import frontend.view.admin.BenutzerListeView;
import frontend.view.login.LoginView;
import javassist.convert.Transformer;
import persistence.DBH;

public class BenutzerListeViewController extends ConsoleViewController<BenutzerListeView> {
	private List<Benutzer> userList;
	
	public BenutzerListeViewController() {
		this.setView(new BenutzerListeView(ProgramManager.getInstance().getBenutzer()));
	}
	
	@Override
	protected void beforeViewShow() {
		userList = loadBenutzerListe();
		BenutzerListeView v = this.getView();
		v.setBenutzerListe(userList);
	};
	
	@Override
	protected void afterViewShow() {
		BenutzerListeView view = this.getView();
		switch (view.getMenuSelection()) {
		case "n":
			// Neuen Benutzer erstellen:
			ProgramManager.getInstance().addNext(new BenutzerErstellenFormViewController());
			 break;
		case "0": break;
		default:
			// ausgewaehlten Benutzer holen, Form-controller starten:
			Benutzer editBenutzer = view.getSelectedBenutzer();
			ProgramManager.getInstance().addNext(new BenutzerFormViewController(editBenutzer));
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
