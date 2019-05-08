package frontend;

import business.entity.MediumExemplar;
import persistence.MediumManager;

public class BarcodeAusleiheViewController extends ViewController {
	public BarcodeAusleiheViewController(BarcodeAusleiheView view) {
		super(view);
	}
	
	public MediumExemplar processBarcodeAusleihe(String code) {
		if (code != null) {
			MediumManager mm = new MediumManager();
			return mm.ausleiheByBarcode(this.getLoggedInBenutzer(), code);
		}
		return null;
	}
	
	@Override
	public View getNextView() {
		return new MainMenuView(ProgramManager.getInstance().getBenutzer());
	}
}
