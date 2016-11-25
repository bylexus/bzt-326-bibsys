package business;

import frontend.ProgramManager;
import frontend.controller.login.LoginViewController;

public class Main {

	public static void main(String[] args) {
		// Start des ersten Controllers (Login):
		LoginViewController ctrl = new LoginViewController();
		ProgramManager pm = ProgramManager.getInstance();
		
		pm.addNext(ctrl);
		pm.startCurrent();
	}
}
