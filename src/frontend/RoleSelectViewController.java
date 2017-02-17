package frontend;

import business.entity.Benutzer;

public class RoleSelectViewController extends ViewController {
	
	public RoleSelectViewController(RoleSelectView view) {
		super(view);
	}
	
	@Override
	public void afterViewShow() {
		RoleSelectView view = (RoleSelectView)this.getView();
		switch (view.getChoose()) {
		case "1": startAsUser(); break;
		case "2": System.out.println("Menu-Wahl: Bibliotheksangestellter"); break;
		case "3": startAsAdmin(); break;
		case "0": ProgramManager.getInstance().shutdown();break;
		}
	}
	
	protected void startAsUser() {
		ProgramManager.getInstance().addNext(new AusleiheListView());
	}
	
	protected void startAsAdmin() {
		RoleSelectView view = (RoleSelectView)this.getView();
		Benutzer b = view.loggedInUser;
		if (b.isAdmin()) {
			ProgramManager.getInstance().addNext(new AdminMenuView(b));	
		}
	}
}
