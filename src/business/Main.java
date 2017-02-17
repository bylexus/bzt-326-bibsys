package business;

import frontend.AppLoginView;
import frontend.ProgramManager;

public class Main {

	public static void main(String[] args) {
		// Start der ersten View (Login):
		AppLoginView view = new AppLoginView();
		ProgramManager pm = ProgramManager.getInstance();
		
		pm.addNext(view);
		pm.startCurrentView();
	}
}
