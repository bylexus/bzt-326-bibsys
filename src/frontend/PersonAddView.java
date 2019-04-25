package frontend;

import java.util.List;

import business.entity.Person;

public class PersonAddView extends View {
	public PersonAddView() {
		this.setController(new PersonAddViewController(this));
	}
	
	@Override
	public void displayView() {
		PersonAddViewController ctrl = (PersonAddViewController)this.getController();
		List<Person> personen = ctrl.getPersonen();
				
		clearScreen();
		out("BIBSYS - Person-Manager");
		out("==============================================================================\n");
		
		String name = ask("Nachname:");
		String vorname = ask("Vorname:");
		String email = ask("Email:");
		
		ctrl.createPerson(name, vorname, email);
	}
}
