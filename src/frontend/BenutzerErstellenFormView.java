package frontend;

import business.entity.Benutzer;

public class BenutzerErstellenFormView extends ConsoleView {
	private Benutzer benutzer;
	public String login = "";
	public String vorname = "";
	public String nachname = "";
	public String email = "";
	
	public BenutzerErstellenFormView(Benutzer b) {
		this.benutzer = b;
		this.setController(new BenutzerErstellenFormViewController(this));
	}
	
	
	@Override
	public void displayView() {
		clearScreen();
		if (benutzer.isAdmin() != true) return;
		
		out("Neuen Benutzer erstellen");
		out("========================\n");

		login = ask("Login (leer für abbrechen):").trim();
		if (login.equals("")) return;
		
		vorname = ask("Vorname:").trim();
		nachname = ask("Nachname:").trim();
		email = ask("Email:").trim();
	}
}
