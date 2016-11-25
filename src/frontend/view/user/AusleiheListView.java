package frontend.view.user;

import frontend.view.ConsoleView;

public class AusleiheListView extends ConsoleView {

	@Override
	public void printView() {
		out("Ausleihen");
		out("==========");
		ask("?");
	}
}
