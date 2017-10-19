package frontend;

public class MainMenuViewController extends ViewController {
	
	public MainMenuViewController(MainMenuView view) {
		super(view);
	}
	
	@Override
	public void afterViewShow() {
		MainMenuView view = (MainMenuView)this.getView();
		switch (view.getChoose()) {
		case "1": startAusleiheListView(); break;
		case "0": ProgramManager.getInstance().shutdown();break;
		}
	}
	
	protected void startAusleiheListView() {
		ProgramManager.getInstance().addNext(new AusleiheListView());
	}
}
