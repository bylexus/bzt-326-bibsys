package frontend;

import java.util.List;

import business.entity.MediumExemplar;

/**
 * Dieser Controller wird von 2 Views verwendet - AusleiheListView und AusleihePrintListView - 
 * so kann dieser für die beiden fast gleichen Views wiederverwendet werden.
 */
public class AusleiheListViewController extends ViewController {
	public AusleiheListViewController(View view) {
		super(view);
	}
	
	public List<MediumExemplar> getAusgelieheneMedien() {
		return this.getLoggedInBenutzer().getAusgelieheneMedien();
	}
	
	@Override
	public View getNextView() {
		return new MainMenuView(ProgramManager.getInstance().getBenutzer());
	}
}
