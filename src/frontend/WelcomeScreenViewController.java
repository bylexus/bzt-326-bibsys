package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import business.ProgramManager;
import business.entity.Person;

public class WelcomeScreenViewController extends ViewController<WelcomeScreenView> {
	
	public WelcomeScreenViewController(WelcomeScreenView view) {
		super(view);
		Person p = ProgramManager.getInstance().getBenutzer().getPerson();
		view.getWelcomeLabel().setText(
				String.format("Willkommen, %s %s!",
				p.getVorname(), p.getName())
		);
		view.getTimeLabel().setText(
				String.format("Programmstart: %s",
				Calendar.getInstance().getTime().toString()
		));
		
		view.getBtnAusgelieheneMedien().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestMainPanelAdd(new AusleiheListView());
			}
		});

		view.getBtnHello().addActionListener(e -> {
				ProgramManager.getInstance().requestMainPanelAdd(new HelloView());
		});

		view.getBtnMedienAmTerminal().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestMainPanelAdd(new MedienScannenView());
			}
		});

		view.getBtnBeenden().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().shutdown();
			}
		});
	}
}
