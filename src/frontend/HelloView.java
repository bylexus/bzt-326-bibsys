package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class HelloView extends JPanel {
	HelloViewController ctrl;
	private JButton btnZurueck;

	private JTextField nameField;
	private JButton btnAnzeige;

	public HelloView() {
		initUI();
		ctrl = new HelloViewController(this);
	}

	protected void initUI() {
		this.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 500, 40);
		add(toolBar);

		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);

		JLabel lblNewLabel = new JLabel("Hello!");
		toolBar.add(lblNewLabel);

		JPanel innerPanel = new JPanel();
		innerPanel.setBounds(0, 40, 500, 500);
		innerPanel.setLayout(null);

		nameField = new JTextField();
		nameField.setBounds(0, 0, 300, 40);
		btnAnzeige = new JButton("click mich!");
		btnAnzeige.setBounds(305, 0, 100, 40);

		innerPanel.add(nameField);
		innerPanel.add(btnAnzeige);

		this.add(innerPanel);

	}

	public JTextField getNameField() {
		return nameField;
	}

	public JButton getBtnAnzeige() {
		return btnAnzeige;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}
}
