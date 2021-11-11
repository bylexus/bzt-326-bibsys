package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class PersonManagerView extends JPanel {
	PersonManagerViewController ctrl;
	private JButton btnZurueck;
	private JTable personList;
	private String[] columns = {"Name", "Vorname", "Email", "Login"};
	JButton btnNewPerson;
	
	public PersonManagerView() {
		initUI();
		ctrl = new PersonManagerViewController(this);
		
	}
	
	protected void initUI() {
		setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Personen-Manager");
		toolBar.add(lblNewLabel);
		
		personList = new JTable();
		JScrollPane scrollPane = new JScrollPane(personList);
		personList.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.CENTER);

		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.SOUTH);
		
		btnNewPerson = new JButton("Person erstellen");
		panel.add(btnNewPerson);
	}
	
	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public JTable getMedienList() {
		return personList;
	}
	
	public String[] columnNames() {
		return columns;
	}
}
