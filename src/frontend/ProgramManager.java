package frontend;

import java.util.Stack;
import business.entity.Benutzer;
import persistence.DataContainer;

public class ProgramManager {
	private static ProgramManager _inst;
	
	View currentView = null;
	
	Benutzer benutzer = null;
	
	private ProgramManager() {
	}
	
	public static ProgramManager getInstance() {
			if (ProgramManager._inst == null) {
				ProgramManager._inst = new ProgramManager();
			}
			return ProgramManager._inst;
	}
	
	public View getCurrentView() {
		return this.currentView;
	}
	
	public void startView(View view) {
		this.currentView = view;
		View nextView = currentView.show();
		if (nextView == null) {
			shutdown();
		} else {
			startView(nextView);
		}
		
	}
	
	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	public void shutdown() {
		DataContainer.getInst().shutdown();
		System.exit(0);
	}
}
