package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import business.ProgramManager;

public class WelcomeScreenViewController extends ViewController<WelcomeScreenView> {
	
	public WelcomeScreenViewController(WelcomeScreenView view) {
		super(view);
		view.getWelcomeLabel().setText(
				String.format("Willkommen, %s!",
				ProgramManager.getInstance().getBenutzer().getLogin())
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
		view.getBtnBeenden().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().shutdown();
			}
		});
	}
}
