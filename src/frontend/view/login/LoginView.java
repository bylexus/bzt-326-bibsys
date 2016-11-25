package frontend.view.login;

import java.util.Arrays;

import frontend.view.ConsoleView;;

public class LoginView extends ConsoleView {
	String choose = "";
	
	public String getChoose() {
		return choose;
	}
	

	@Override
	public void printView() {
		String[] allowed = {"1","2","3","4"};
		choose = "";
		
		out("W E L C O M E   to   B-I-B-S-Y-S");
		out("================================\n");
		out("1: Als Benutzer verbinden");
		out("2: Als Bibliotheksangestellter verbinden");
		out("3: Als Admin verbinden\n");
		out("4: Beenden\n");
		
		while (!Arrays.asList(allowed).contains(choose)) {
			choose = ask("Ihre Wahl:");
		}
	}
}
