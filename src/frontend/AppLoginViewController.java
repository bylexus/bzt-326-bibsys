package frontend;

public class AppLoginViewController extends ViewController {
	
	public AppLoginViewController(AppLoginView view) {
		super(view);
	}
	
	@Override
	public void beforeViewShow() {
		ProgramManager.getInstance().setBenutzer(null);
	};
	
	@Override
	public void afterViewShow() {
		AppLoginView view = (AppLoginView)this.getView();
		ProgramManager.getInstance().setBenutzer(view.loggedInUser);
		ProgramManager.getInstance().addNext(new RoleSelectView(view.loggedInUser));
	}
}
