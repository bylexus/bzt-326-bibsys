package frontend;

import java.util.Arrays;

import business.entity.Benutzer;

public class RoleSelectView extends ConsoleView {
	String choose = "";
	Benutzer loggedInUser = null;
	
	public RoleSelectView(Benutzer loggedInUser) {
		this.loggedInUser = loggedInUser;
		this.setController(new RoleSelectViewController(this));
	}
	
	public String getChoose() {
		return choose;
	}
	

	@Override
	public void displayView() {
		clearScreen();
		String[] allowed = {"1","0","_","_"};
		choose = "";
		
		out("W E L C O M E   to   B-I-B-S-Y-S, "+this.loggedInUser.getLogin());
		out("==================================================================\n");
		out("1: Als Benutzer verbinden");
		if (loggedInUser.isBibMA()) {
			out("2: Als Bibliotheksangestellter verbinden");
			allowed[2] = "2";
		}
		if (loggedInUser.isAdmin()) {
			out("3: Als Admin verbinden\n");
			allowed[3] = "3";
		}
		out("0: Beenden\n");
		
		while (!Arrays.asList(allowed).contains(choose)) {
			choose = ask("Ihre Wahl:");
		}
	}
}
