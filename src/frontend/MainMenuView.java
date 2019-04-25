package frontend;

import java.util.Arrays;

import business.entity.Benutzer;
import business.entity.Person;

public class MainMenuView extends View {
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
		String[] allowed = {"1","2", "0"};
		choose = "";
		
		Person p = this.loggedInUser.getPerson();
		if (p != null) {
			out(String.format("W E L C O M E   to   B-I-B-S-Y-S, %s %s (%s)",
					p.getVorname(),
					p.getNachname(),
					p.getEmail()));	
		} else {
			out("W E L C O M E   to   B-I-B-S-Y-S");
		}
		
		out("==================================================================\n");
		out("1: Ausgeliehene Medien anzeigen");
		out("2: Person-Manager");
		
		out("0: Beenden\n");
		
		while (!Arrays.asList(allowed).contains(choose)) {
			choose = ask("Ihre Wahl:");
		}
	}
}
