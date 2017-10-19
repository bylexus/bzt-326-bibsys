package business;

import frontend.AppLoginView;
import frontend.ProgramManager;
import frontend.View;

public class Main {
	static enum Mode {
		APP, TERMINAL
	};

	public static void main(String[] args) {
		Mode m = Mode.APP;
		View view = null;
		
		for (String p : args) {
			if (p.equals("-terminal")) {
				m = Mode.TERMINAL;
			}
		}
		
		switch (m) {
		case APP:
			view = new AppLoginView();
			break;
		case TERMINAL:
			// TODO
		}
		if (view != null) {
			// Start der ersten View:
			ProgramManager pm = ProgramManager.getInstance();
			pm.addNext(view);
			pm.startCurrentView();
		}
	}
}
