package frontend.controller.login;

import org.hibernate.Session;

import business.entity.Benutzer;
import frontend.ProgramManager;
import frontend.controller.ConsoleViewController;
import frontend.controller.admin.AdminMenuViewController;
import frontend.controller.user.AusleiheListViewController;
import frontend.view.login.LoginView;
import persistence.DBH;

public class LoginViewController extends ConsoleViewController<LoginView> {
	
	public LoginViewController() {
		this.setView(new LoginView());
	}
	
	@Override
	protected void afterViewShow() {
		LoginView view = (LoginView)this.getView();
		switch (view.getChoose()) {
		case "1": startAsUser(); break;
		case "2": System.out.println("Menu-Wahl: Bibliotheksangestellter"); break;
		case "3": startAsAdmin(); break;
		}
	}
	
	protected void startAsUser() {
		Benutzer b;
		Session session = DBH.getInst().openSession();
		b = (Benutzer)session.createQuery("from Benutzer where admin IS NOT TRUE and bibMA IS NOT TRUE").getSingleResult();
		session.close();
		if (b != null) {
			ProgramManager.getInstance().setBenutzer(b);
		} else {
			System.err.println("Sorry, normal user not found. Exit.");
			System.exit(1);
		}
		ProgramManager.getInstance().addNext(new AusleiheListViewController());
	}
	
	protected void startAsAdmin() {
		Benutzer b;
		Session session = DBH.getInst().openSession();
		b = (Benutzer)session.createQuery("from Benutzer where admin IS TRUE").getSingleResult();
		session.close();
		if (b != null) {
			ProgramManager.getInstance().setBenutzer(b);
		} else {
			System.err.println("Sorry, normal user not found. Exit.");
			System.exit(1);
		}
		ProgramManager.getInstance().addNext(new AdminMenuViewController());
	}
}
