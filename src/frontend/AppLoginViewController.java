package frontend;

import business.entity.Benutzer;
import persistence.BenutzerMM;

public class AppLoginViewController extends ViewController {
	
	public AppLoginViewController(AppLoginView view) {
		super(view);
	}
	
	@Override
	public void beforeViewShow() {
		ProgramManager.getInstance().setBenutzer(null);
	};
	
	@Override
	public void afterViewShow() {
		AppLoginView view = (AppLoginView)this.getView();
		ProgramManager.getInstance().setBenutzer(view.loggedInUser);
		ProgramManager.getInstance().addNext(new MainMenuView(view.loggedInUser));
	}
	
	public Benutzer checkLogin(String login, String password) {
		if (password.equals("")) {
			ProgramManager.getInstance().shutdown();
		}
		
		BenutzerMM benutzerManager = new BenutzerMM();
		return benutzerManager.findUserByLogin(login, password);
	}
}
