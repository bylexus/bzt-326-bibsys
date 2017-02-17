package frontend;

public class AusleiheListView extends ConsoleView {
	public AusleiheListView() {
		this.setController(new AusleiheListViewController(this));
	}

	@Override
	public void displayView() {
		clearScreen();
		out("Ausleihen");
		out("==========");
		ask("?");
	}
}
