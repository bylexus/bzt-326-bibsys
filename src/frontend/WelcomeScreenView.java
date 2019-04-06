package frontend;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreenView extends JPanel {
	WelcomeScreenViewController ctrl;
	private JLabel welcomeLabel;
	private JLabel timeLabel;
	private JButton btnAusgelieheneMedien;
	private JButton btnBeenden;
	private Component verticalGlue;
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
		
		verticalGlue = Box.createVerticalGlue();
		centerPanel.add(verticalGlue);
		
		btnBeenden = new JButton("Beenden");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		centerPanel.add(btnBeenden);
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

	public JButton getBtnBeenden() {
		return btnBeenden;
	}
}
