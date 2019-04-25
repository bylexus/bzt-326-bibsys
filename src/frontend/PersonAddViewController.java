package frontend;

import java.util.List;

import business.entity.Person;
import persistence.DataContainer;
import persistence.PersonModelManager;

public class PersonAddViewController extends ViewController {
	public PersonAddViewController(PersonAddView view) {
		super(view);
	}
	
	public List<Person> getPersonen() {
		return DataContainer.getInst().personList;
	}
	
	public Person createPerson(String name, String vorname, String email) {
		PersonModelManager pm = new PersonModelManager();
		return pm.createPerson(name, vorname, email);
	}
	
	@Override
	public View getNextView() {
		return new PersonManagerView();
	}
}
