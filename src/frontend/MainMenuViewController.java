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
		case "2":
			return new PersonManagerView();
		case "3":
			return new BarcodeAusleiheView();
		case "4":
			return new AusleihePrintListView();
		default: return null;
		}
	}
}
