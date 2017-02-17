package frontend;

import java.util.Arrays;

import business.entity.Benutzer;

public class BenutzerFormView extends ConsoleView {
	public static enum ACTION  {
			SAVE,
			DELETE
	};
	private String menuSelection = "";
	private Benutzer benutzer;
	private Benutzer editBenutzer;
	
	private boolean exit = false;
	
	public BenutzerFormView(Benutzer benutzer, Benutzer editBenutzer) {
		this.benutzer = benutzer;
		this.editBenutzer = editBenutzer;
		this.setController(new BenutzerFormViewController(this));
	}
	
	public String getMenuSelection() {
		return menuSelection;
	}
	
	public void setEditBenutzer(Benutzer b) {
		this.editBenutzer = b;
	}
	
	public Benutzer getEditBenutzer() {
		return this.editBenutzer;
	}
	
	
	@Override
	public void displayView() {
		clearScreen();
		if (benutzer.isAdmin() != true) return;
		if (editBenutzer== null) return;
		
		String[] allowed = {"1","2","3","4","5","d","save","0"};
		while(!exit) {
			String input = "";
			clearScreen();
			out("Bearbeite Benutzer-ID: "+editBenutzer.getId());
			out("=======================================\n");
			
			out("   Login: "+editBenutzer.getLogin());
			out("1: Name: "+editBenutzer.getNachname());
			out("2: Vorname: "+editBenutzer.getVorname());
			out("3: Email: "+editBenutzer.getEmail());
			out("4: ist Admin: "+(editBenutzer.isAdmin() == true ? "Ja" : "Nein"));
			out("5: ist Bib-MA: "+(editBenutzer.isBibMA() == true ? "Ja" : "Nein"));
			out("\nd: Benutzer löschen\n");
			out("save: Speichern");
			out("0: Zurück");
			
			while (!Arrays.asList(allowed).contains(input)) {
				input = ask("Ihre Wahl:");
			}
			
			switch (input) {
			case "1": editNachname(editBenutzer); break;
			case "2": editVorname(editBenutzer); break;
			case "3": editEmail(editBenutzer); break;
			case "4": editBenutzer.setAdmin(!editBenutzer.isAdmin()); setChanged();break;
			case "5": editBenutzer.setBibMA(!editBenutzer.isBibMA()); setChanged();break;
			case "0": exit = true; break;
			case "save": 
				this.notifyObservers(ACTION.SAVE);
				break;
			case "d":
				String yes = ask("Sicher?");
				if (yes.equals("j")) {
					this.setChanged();
					this.notifyObservers(ACTION.DELETE);
					exit = true;
				}
				break;
			}
			
			menuSelection = input;
		}
	}
	
	protected void editNachname(Benutzer b) {
		String value = b.getNachname();
		b.setNachname(ask("Nachname ("+value+"):"));
		this.setChanged();
	}
	
	protected void editVorname(Benutzer b) {
		String value = b.getVorname();
		b.setVorname(ask("Vorname ("+value+"):"));
		this.setChanged();
	}
	
	protected void editEmail(Benutzer b) {
		String value = b.getEmail();
		b.setEmail(ask("Email ("+value+"):"));
		this.setChanged();
	}
}
