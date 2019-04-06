package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.ProgramManager;
import business.entity.Benutzer;
import persistence.BenutzerMM;

public class AppLoginViewController 
	extends ViewController<AppLoginView> 
    implements ActionListener {
	
	public AppLoginViewController(AppLoginView view) {
		super(view);
		// View-Events anhängen:
		view.getBeendenBtn().addActionListener(this);
		view.getLoginBtn().addActionListener(this);
	}
	
	public Benutzer checkLogin(String login, String password) {
		BenutzerMM benutzerManager = new BenutzerMM();
		return benutzerManager.findUserByLogin(login, password);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "login":
			Benutzer b = this.checkLogin(view.getLoginField().getText(), String.copyValueOf(view.getPasswordField().getPassword())); 
			if (b != null) {
				view.setBenutzer(b);
				for (ActionListener a : this.view.getLoginListeners()) {
					a.actionPerformed(new ActionEvent(view, ActionEvent.ACTION_PERFORMED, "login"));
				}
			} else {
				view.setBenutzer(null);
				view.getErrorLabel().setText("Falscher Username oder Passwort!");
				view.getErrorLabel().setVisible(true);
			}
			break;
		case "beenden":
			ProgramManager.getInstance().shutdown();
		}
	}
}
