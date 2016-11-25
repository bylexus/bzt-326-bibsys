package frontend.controller.user;

import frontend.controller.ConsoleViewController;
import frontend.view.user.AusleiheListView;

public class AusleiheListViewController extends ConsoleViewController<AusleiheListView> {
	public AusleiheListViewController() {
		this.setView(new AusleiheListView());
	}
}
