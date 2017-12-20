package business;

import frontend.AppLoginView;
import frontend.ProgramManager;
import frontend.View;

public class Main {
	public static void main(String[] args) {
		View view = null;
		view = new AppLoginView();

		// Start der ersten View:
		ProgramManager pm = ProgramManager.getInstance();
		pm.startView(view);
	}
}
