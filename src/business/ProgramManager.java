package business;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import business.entity.Benutzer;
import frontend.AppLoginView;
import frontend.MainWindow;
import frontend.WelcomeScreenView;
import persistence.DataContainer;

public class ProgramManager implements ActionListener {
	private static ProgramManager _inst;
	private List<Component> cardItems = new ArrayList<Component>();

	private MainWindow mainWindow = null;

	private Benutzer benutzer = null;

	public static ProgramManager getInstance() {
		if (ProgramManager._inst == null) {
			ProgramManager._inst = new ProgramManager();
		}
		return ProgramManager._inst;
	}

	private ProgramManager() {
	}

	/**
	 * Startet das Programm durch Anzeigen des Login-Fensters, und Anhängen der
	 * notwendigen Listener für die Login-Fenster-events
	 */
	public void startProgram() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramManager.getInstance().setBenutzer(null);
					AppLoginView frame = new AppLoginView();
					frame.addLoginListener(ProgramManager.getInstance());
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							ProgramManager.getInstance().shutdown();
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow getMainWindow() {
		if (this.mainWindow == null) {
			this.mainWindow = new MainWindow();
		}
		return this.mainWindow;
	}

	public void requestMainPanelAdd(JPanel panel) {
		panel.setName(panel.toString());
		this.cardItems.add(panel);
		this.getMainWindow().getContentPane().add(panel, panel.getName());
		CardLayout layout = this.getMainWindow().getMainLayout();
		System.out.println(panel.getName());
		layout.show(this.getMainWindow().getContentPane(), panel.getName());
	}

	public void requestRemoveLastPanel() {
		Component lastPanel = this.cardItems.get(this.cardItems.size()-1);
		if (lastPanel != null) {
			this.cardItems.remove(lastPanel);
		}
		Component prevPanel = this.cardItems.get(this.cardItems.size()-1);
		if (lastPanel != null) {
			CardLayout layout = this.getMainWindow().getMainLayout();
			this.getMainWindow().getContentPane().remove(lastPanel);
			if (prevPanel != null) {
				layout.show(this.getMainWindow().getContentPane(), prevPanel.getName());
			}
		}
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public void shutdown() {
		DataContainer.getInst().shutdown();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "login") {
			if (e.getSource() instanceof AppLoginView) {
				AppLoginView v = (AppLoginView) e.getSource();
				System.out.println("Login erfolgreich, starte Hauptfenster");

				ProgramManager.getInstance().setBenutzer(v.getBenutzer());
				v.setVisible(false);
				v.dispose();

				this.requestMainPanelAdd(new WelcomeScreenView());
				this.getMainWindow().setVisible(true);
			}
		}
	}
}
