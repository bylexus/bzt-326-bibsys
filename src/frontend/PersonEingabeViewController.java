package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.ProgramManager;
import business.entity.Person;
import persistence.PersonManager;

public class PersonEingabeViewController extends ViewController<PersonEingabeView> {
	
	public PersonEingabeViewController(PersonEingabeView view) {
		super(view);
		view.btnZurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
		
		view.btnSpeichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Daten auf Model abfüllen:
				Person model = view.model;
				model.setName(view.nameField.getText());
				model.setVorname(view.vornameField.getText());
				model.setEmail(view.emailField.getText());
				
				// Model persistieren:
				PersonManager pm = new PersonManager();
				pm.store(model);
				
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
	}
}
