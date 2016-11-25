package frontend.view.admin;

import java.util.List;

import business.entity.Benutzer;
import frontend.view.ConsoleView;

public class BenutzerListeView extends ConsoleView {
	private String menuSelection = "";
	private Benutzer benutzer;
	private List<Benutzer> benutzerListe;
	private Benutzer selectedBenutzer;
	
	public BenutzerListeView(Benutzer b) {
		this.benutzer = b;
	}
	
	public String getMenuSelection() {
		return menuSelection;
	}
	
	public void setBenutzerListe(List<Benutzer>liste) {
		this.benutzerListe = liste;
	}
	
	public List<Benutzer> getBenutzerListe() {
		return this.benutzerListe;
	}
	
	public Benutzer getSelectedBenutzer() {
		return this.selectedBenutzer;
	}
	
	@Override
	public void printView() {
		selectedBenutzer = null;
		if (benutzer.isAdmin() != true) return;
		if (getBenutzerListe() == null) return;
		
		String input = "";
		out("Benutzer-Administration");
		out("========================\n");
		
		for (Benutzer entry : getBenutzerListe()) {
			out(String.format("%1$d: %2$s %3$s (%4$s)", entry.getId(),entry.getNachname(), entry.getVorname(),entry.getLogin()));
		}
		
		out("\n\nn: Neuen Benutzer anlegen\n");
		out("0: Zurück");
		
		while (selectedBenutzer == null && !input.equals("n") && !input.equals("0")) {
			input = ask("Ihre Wahl:");
			try {
				selectedBenutzer = getUserWithId(Long.parseLong(input));
			} catch(Exception e) {
				selectedBenutzer = null;
			}
		}
		menuSelection = input;
	}
	
	protected Benutzer getUserWithId(Long id) {
		for (Benutzer b : getBenutzerListe()) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}
}
