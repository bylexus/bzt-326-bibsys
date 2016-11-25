package frontend.view.admin;

import business.entity.Benutzer;
import frontend.view.ConsoleView;

public class BenutzerErstellenFormView extends ConsoleView {
	private Benutzer benutzer;
	public String login = "";
	public String vorname = "";
	public String nachname = "";
	public String email = "";
	
	public BenutzerErstellenFormView(Benutzer b) {
		this.benutzer = b;
	}
	
	
	@Override
	public void printView() {
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
