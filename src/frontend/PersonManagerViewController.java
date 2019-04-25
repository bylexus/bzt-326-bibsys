package frontend;

import java.util.List;

import business.entity.Person;
import persistence.DataContainer;

public class PersonManagerViewController extends ViewController {
	public PersonManagerViewController(PersonManagerView view) {
		super(view);
	}
	
	public List<Person> getPersonen() {
		return DataContainer.getInst().personList;
	}
	
	@Override
	public View getNextView() {
		PersonManagerView view = (PersonManagerView)this.getView();
		switch (view.choose) {
		case "n":
			return new PersonAddView();
		default: return new MainMenuView(getLoggedInBenutzer());
		}
	}
}
