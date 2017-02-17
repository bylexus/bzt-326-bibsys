package frontend;

import java.util.Arrays;

import business.entity.Benutzer;

public class AdminMenuView extends ConsoleView {
	private String menuSelection = "";
	private Benutzer benutzer;
	
	public AdminMenuView(Benutzer b) {
		this.benutzer = b;
		this.setController(new AdminMenuViewController(this));
	}
	
	public String getMenuSelection() {
		return menuSelection;
	}
	
	@Override
	public void displayView() {
		clearScreen();
		String[] allowed = {"1","0"};
		String input = "";
		out("Hauptmenu - Willkommen, " + benutzer.getLogin());
		out("=================================================================================\n");
		out("1: Benutzer-Administration\n");
		out("0: Beenden");
		while (!Arrays.asList(allowed).contains(input)) {
			input = ask("Ihre Wahl:");
		}
		menuSelection = input;
	}
}
