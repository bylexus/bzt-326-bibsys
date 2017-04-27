package frontend;
/**
 * Die TerminalLoginView ist die Maske, welche den Benutzer nach einem
 * Ausweis-Barcode fragt.
 * 
 * Wir verwenden das MVC-Pattern hier: Diese View kommuniziert für die Logik
 * mit ihrem Controller (TerminalLoginViewController). Dieser wiederum arbeitet
 * auf einem Model, dem Benutzer.
 */
public class TerminalLoginView extends ConsoleView {
	public TerminalLoginView() {
		this.setController(new TerminalLoginViewController(this));
	}
	
	@Override
	public void displayView() {
		TerminalLoginViewController controller = (TerminalLoginViewController)this.controller;
		String ausweisNr;
		clearScreen();
		
		out("W E L C O M E   to   B-I-B-S-Y-S");
		out("================================\n");
		
		while (controller.getLoggedInUser() == null) {
			ausweisNr = ask("Ausweis-Barcode:");
			// MVC: Wir informieren den Controller über die Eingabe:
			controller.credentialsEntered(ausweisNr);
			
			// MVC: Model: Wir fragen, ob wir ein Model haben (Hier: Benutzer):
			if (controller.getLoggedInUser() == null) {
				out("*** Falscher Ausweis. Nochmals. ***");
			}
		}
	}
}
