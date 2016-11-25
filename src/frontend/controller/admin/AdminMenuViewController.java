package frontend.controller.admin;

import frontend.ProgramManager;
import frontend.controller.ConsoleViewController;
import frontend.view.admin.AdminMenuView;

public class AdminMenuViewController extends ConsoleViewController<AdminMenuView> {
	
	public AdminMenuViewController() {
		this.setView(new AdminMenuView(ProgramManager.getInstance().getBenutzer()));
	}
	
	@Override
	protected void afterViewShow() {
		AdminMenuView view = this.getView();
		switch (view.getMenuSelection()) {
		case "1": startUserList(); break;
		case "0": ProgramManager.getInstance().shutdown(); break;
		}
	}
	
	protected void startUserList() {
		ProgramManager.getInstance().addNext(new BenutzerListeViewController());
	}
}
