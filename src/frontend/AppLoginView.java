package frontend;

import business.entity.Benutzer;

public class AppLoginView extends View {
	String choose = "";
	Benutzer loggedInUser = null;
	
	public AppLoginView() {
		this.setController(new AppLoginViewController(this));
	}
	
	public String getChoose() {
		return choose;
	}
	

	@Override
	public void displayView() {
		String login,pass;
		AppLoginViewController ctrl = (AppLoginViewController)this.getController();
		
		
		clearScreen();
		this.loggedInUser = null;
		
		out("W E L C O M E   to   B-I-B-S-Y-S");
		out("================================\n");
		
		while (this.loggedInUser == null) {
			login = ask("Login:");
			pass = ask("Passwort:");
			
			this.loggedInUser = ctrl.checkLogin(login, pass);
			
			if (this.loggedInUser == null) {
				out("*** Falsches Passwort. Nochmals. ***");
			}
		}
	}
}
