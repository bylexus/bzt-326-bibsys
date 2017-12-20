package frontend;

public class AusleiheListViewController extends ViewController {
	public AusleiheListViewController(AusleiheListView view) {
		super(view);
	}
	
	@Override
	public View getNextView() {
		return new MainMenuView(ProgramManager.getInstance().getBenutzer());
	}
}
