package frontend;

import javax.persistence.NoResultException;

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
		Boolean weiteresBuch = true;
		clearScreen();
		
		out("M E D I E N   A U S L E I H E N");
		out("================================\n");
		
		while (weiteresBuch) {
			exemplarNr = ask("Exemplar-Nummer:");
			if (exemplarNr.equals("")) {
				weiteresBuch = false;
				break;
			}
			// MVC: Wir informieren den Controller über die Eingabe:
			try {
				MediumExemplar m = controller.leiheAusMitNummer(exemplarNr);
				out("--> Medium ausgeliehen: "+m.getExemplarNr()+": "+m.getMedium().getTitel()+", Ausleihdatum: "+m.getAusgeliehenAm().toString());
				out("");
				weiteresBuch = true;
			} catch (Exception e) {
				out("*** FEHLER! ***");
				out(e.getMessage());
				out("");
			}
		}
	}
}
