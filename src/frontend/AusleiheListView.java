package frontend;

import business.entity.Buch;
import business.entity.CD;
import business.entity.MediumExemplar;

public class AusleiheListView extends View {
	public AusleiheListView() {
		this.setController(new AusleiheListViewController(this));
	}

	@Override
	public void displayView() {
		AusleiheListViewController ctrl = (AusleiheListViewController)this.getController();
		
		clearScreen();
		out("BIBSYS - "+this.controller.getLoggedInBenutzer().getLogin() + " - Ihre Ausgeliehene Medien");
		out("==============================================================================\n");
		for (MediumExemplar m : ctrl.getAusgelieheneMedien()) {
			String output = m.getBarcode() + ": ";
			
			// Je nach Medium-Typ generieren wir eine andere Ausgabe - hier ohne Composite-Pattern:
			if (m.getMedium() instanceof Buch) {
				Buch b = (Buch)m.getMedium();
				output += "Buch: " + b.getIsbn() + ": " + b.getTitel();
				if (b.getAutor() != null) {
					output += ", Autor: " + b.getAutor().getNachname() + b.getAutor().getVorname();
				}
			} else if (m.getMedium() instanceof CD) {
				CD c = (CD)m.getMedium();
				output += "CD  : " + c.getEan() + ": " + c.getTitel();
				if (c.getInterpret() != null) {
					output += ", Interpret: " + c.getInterpret().getName() + " " + c.getInterpret().getVorname();
				}
			} else {
				output += "Medium: " + m.getMedium().getTitel();
			}
			out(output);
		}
		ask("?");
	}
}
