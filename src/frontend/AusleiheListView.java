package frontend;

import business.entity.Medium;

public class AusleiheListView extends View {
	public AusleiheListView() {
		this.setController(new AusleiheListViewController(this));
	}

	@Override
	public void displayView() {
		clearScreen();
		out("BIBSYS - "+this.controller.getLoggedInBenutzer().getLogin() + " - Ausgeliehene Medien");
		out("==============================================================================\n");
		for (Medium m : this.controller.getLoggedInBenutzer().getAusgelieheneMedien()) {
			out(m.getId() + ": "+m.getTitel());
		}
		ask("?");
	}
}
