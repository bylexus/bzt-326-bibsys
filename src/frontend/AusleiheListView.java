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

public class AusleiheListView extends JPanel {
	AusleiheListViewController ctrl;
	private JButton btnZurueck;
	private JTable medienList;
	private String[] columns = {"ID", "Name"};
	
	public AusleiheListView() {
		initUI();
		ctrl = new AusleiheListViewController(this);
	}
	
	protected void initUI() {
		setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Ausgeliehene Medien");
		toolBar.add(lblNewLabel);
		
		medienList = new JTable();
		JScrollPane scrollPane = new JScrollPane(medienList);
		medienList.setFillsViewportHeight(true);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public JTable getMedienList() {
		return medienList;
	}
	
	public String[] columnNames() {
		return columns;
	}
}
