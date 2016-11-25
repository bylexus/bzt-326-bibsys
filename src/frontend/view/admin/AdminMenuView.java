package frontend.view.admin;

import java.util.Arrays;

import business.entity.Benutzer;
import frontend.view.ConsoleView;

public class AdminMenuView extends ConsoleView {
	private String menuSelection = "";
	private Benutzer benutzer;
	
	public AdminMenuView(Benutzer b) {
		this.benutzer = b;
	}
	
	public String getMenuSelection() {
		return menuSelection;
	}
	
	@Override
	public void printView() {
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
