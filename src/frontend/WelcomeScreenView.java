package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomeScreenView extends JPanel {
	WelcomeScreenViewController ctrl;
	private JLabel welcomeLabel;
	private JLabel timeLabel;
	private JButton btnAusgelieheneMedien;
	private JButton btnBeenden;

	private JButton btnHello;
	
	private Component verticalGlue;
	private JButton btnMedienAmTerminal;
	private JButton btnPersonmanager;
	public WelcomeScreenView() {
		initUI();
		ctrl = new WelcomeScreenViewController(this);
	}
	
	protected void initUI() {
		setLayout(new BorderLayout(0, 0));
		
		welcomeLabel = new JLabel("welcomeLabel");
		add(welcomeLabel, BorderLayout.NORTH);
		
		timeLabel = new JLabel("timeLabel");
		timeLabel.setBorder(null);
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timeLabel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		
		btnAusgelieheneMedien = new JButton("Ausgeliehene Medien");
		centerPanel.add(btnAusgelieheneMedien);

		btnHello = new JButton("Hello World");
		centerPanel.add(btnHello);
		
		btnMedienAmTerminal = new JButton("Medien am Terminal scannen");
		centerPanel.add(btnMedienAmTerminal);
		
		btnPersonmanager = new JButton("Person-Manager");
		centerPanel.add(btnPersonmanager);
		
		verticalGlue = Box.createVerticalGlue();
		centerPanel.add(verticalGlue);
		
		btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		centerPanel.add(btnBeenden);
	}
	
	public JButton getBtnPersonmanager() {
		return btnPersonmanager;
	}

	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}
	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JButton getBtnAusgelieheneMedien() {
		return btnAusgelieheneMedien;
	}

	public JButton getBtnHello() {
		return btnHello;
	}
	
	public JButton getBtnMedienAmTerminal() {
		return btnMedienAmTerminal;
	}

	public JButton getBtnBeenden() {
		return btnBeenden;
	}
}
