package frontend;

public class AdminMenuViewController extends ViewController {
	
	public AdminMenuViewController(AdminMenuView view) {
		super(view);
	}
	
	@Override
	public void afterViewShow() {
		AdminMenuView view = (AdminMenuView)this.getView();
		switch (view.getMenuSelection()) {
		case "1": startUserList(); break;
		case "0": ProgramManager.getInstance().shutdown(); break;
		}
	}
	
	protected void startUserList() {
		ProgramManager.getInstance().addNext(new BenutzerListeView(ProgramManager.getInstance().getBenutzer()));
	}
}
