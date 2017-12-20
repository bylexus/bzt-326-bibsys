package frontend;

public class MainMenuViewController extends ViewController {
	
	public MainMenuViewController(MainMenuView view) {
		super(view);
	}
	
	@Override
	public View getNextView() {
		MainMenuView view = (MainMenuView)this.getView();
		switch (view.getChoose()) {
		case "1":
			return new AusleiheListView(); 
		default: return null;
		}
	}
}
