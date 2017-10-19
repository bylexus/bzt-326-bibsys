package frontend;

import java.util.Arrays;

import business.entity.Benutzer;

public class MainMenuView extends ConsoleView {
	String choose = "";
	Benutzer loggedInUser = null;
	
	public MainMenuView(Benutzer loggedInUser) {
		this.loggedInUser = loggedInUser;
		this.setController(new MainMenuViewController(this));
	}
	
	public String getChoose() {
		return choose;
	}
	

	@Override
	public void displayView() {
		clearScreen();
		String[] allowed = {"1","0"};
		choose = "";
		
		out("W E L C O M E   to   B-I-B-S-Y-S, "+this.loggedInUser.getLogin());
		out("==================================================================\n");
		out("1: Ausgeliehene Medien anzeigen");
		
		out("0: Beenden\n");
		
		while (!Arrays.asList(allowed).contains(choose)) {
			choose = ask("Ihre Wahl:");
		}
	}
}
