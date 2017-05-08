package frontend;

import business.entity.Benutzer;
import business.entity.MediumExemplar;

/**
 * Die Ausleihe-View scannt einzelne Medien, und bucht diese dem eingeloggten User zu (Ausleihvorgang).
 * 
 *  Wir verwenden hier beispielhaft die MedienExemplar-Nummer als Barcode (welchen wir manuell eingeben müssen).
 */
public class TerminalAusleiheView extends ConsoleView {
	public TerminalAusleiheView(Benutzer loggedInUser) {
		this.setController(new TerminalAusleiheViewController(this, loggedInUser));
	}
	
	@Override
	public void displayView() {
		TerminalAusleiheViewController controller = (TerminalAusleiheViewController)this.controller;
		String exemplarNr = "";
		Boolean weiteresMedium = true;
		clearScreen();
		
		out("M E D I E N   A U S L E I H E N");
		out("================================\n");
		
		while (weiteresMedium) {
			exemplarNr = ask("Exemplar-Nummer:");
			if (exemplarNr.equals("")) {
				weiteresMedium = false;
				break;
			}
			// MVC: Wir informieren den Controller über die Eingabe:
			try {
				MediumExemplar m = controller.leiheAusMitNummer(exemplarNr);
				out("--> Medium ausgeliehen: "+m.getExemplarNr()+": "+m.getMedium().getTitel()+", Ausleihdatum: "+m.getAusgeliehenAm().toString());
				out("");
				weiteresMedium = true;
			} catch (Exception e) {
				out("*** FEHLER! ***");
				out(e.getMessage());
				out("");
			}
		}
	}
}
