package frontend;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

public class MeinPanel extends JPanel {
	MeinPanelController ctrl;
	
	private JButton btnZurueck;
	private JButton btnNewButton;
	
	
	
	public MeinPanel() {
		initUI();
		ctrl = new MeinPanelController(this);
	}
	
	protected void initUI() {
		setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);
		
		btnNewButton = new JButton("Click me!");
		add(btnNewButton, BorderLayout.CENTER);
	}
	
	public JButton getBtnZurueck() {
		return btnZurueck;
	}
	
	public JButton getBtnClickMe() {
		return btnNewButton;
	}
}
