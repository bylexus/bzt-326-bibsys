package frontend;

import java.util.List;

import business.entity.Person;

public class PersonManagerView extends View {
	String choose = "";
	
	public PersonManagerView() {
		this.setController(new PersonManagerViewController(this));
	}
	
	public String getChoose() {
		return choose;
	}

	@Override
	public void displayView() {
		PersonManagerViewController ctrl = (PersonManagerViewController)this.getController();
		List<Person> personen = ctrl.getPersonen();
		choose = "";
				
		clearScreen();
		out("BIBSYS - Person-Manager");
		out("==============================================================================\n");
		
		for (int i = 0; i < personen.size(); i++) {
			Person p = personen.get(i);
			out(String.format("%d: %s %s (Mail: %s, Login: %s)", i+1, p.getVorname(), p.getNachname(), p.getEmail(), p.getBenutzer() != null ? p.getBenutzer().getLogin() : "(kein benutzer)"));
		}
		out("\nn: Neue Person erstellen");
		out("0: Zurück");
		choose = ask("Ihre Wahl:");
	}
}
