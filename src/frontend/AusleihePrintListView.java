package frontend;

import business.entity.Benutzer;
import business.entity.MediumExemplar;
import business.entity.Person;

public class AusleihePrintListView extends View {
	public AusleihePrintListView() {
		this.setController(new AusleiheListViewController(this));
	}

	@Override
	public void displayView() {
		AusleiheListViewController ctrl = (AusleiheListViewController)this.getController();
		
		clearScreen();
		Benutzer b = this.controller.getLoggedInBenutzer();
		Person p = b.getPerson();

		String output = "<h1>Ausgeliehene Medien</h1>";
		output += String.format("<p>%s %s (%s)</p>\n\n", p.getVorname(), p.getNachname(), b.getLogin());
		for (MediumExemplar m : ctrl.getAusgelieheneMedien()) {
			// Je nach Medium-Typ generieren wir eine andere Ausgabe - hier mit Composite-Pattern:
			output += m.createHtml(0);
		}
		out(output);
		ask("?");
	}
}
