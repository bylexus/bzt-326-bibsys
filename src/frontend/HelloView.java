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
		setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Hello!");
		toolBar.add(lblNewLabel);
		
		
		JPanel innerPanel = new JPanel();
		
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(100, 30));
		btnAnzeige = new JButton("click mich!");
		
		innerPanel.add(nameField);
		innerPanel.add(btnAnzeige);
		
		this.add(innerPanel, BorderLayout.CENTER);
		
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
