package frontend;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;

public class MedienScannenView extends JPanel {
	MedienScannenViewController ctrl;
	JButton btnZurueck;
	private SpringLayout springLayout;
	private JToolBar toolBar;
	JTextField barcodeField;
	JButton btnScannen;
	JButton btnDruckenfertig;
	JLabel lblBarcode;
	JTextArea textArea;
	
	public MedienScannenView() {
		initUI();
		ctrl = new MedienScannenViewController(this);
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 18, SpringLayout.SOUTH, lblBarcode);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -5, SpringLayout.NORTH, btnDruckenfertig);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, this);
		textArea.setRows(10);
		JScrollPane scrollPane = new JScrollPane(textArea);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, barcodeField);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.NORTH, btnDruckenfertig);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		add(scrollPane);
		
		
	}
	
	protected void initUI() {
		springLayout = new SpringLayout();
		setLayout(springLayout);
		toolBar = new JToolBar();
		springLayout.putConstraint(SpringLayout.NORTH, toolBar, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, toolBar, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, toolBar, 450, SpringLayout.WEST, this);
		add(toolBar);
		btnZurueck = new JButton("zurück");
		btnZurueck.setActionCommand("back");
		toolBar.add(btnZurueck);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Medien scannen");
		toolBar.add(lblNewLabel);
		
		lblBarcode = new JLabel("Barcode:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBarcode, 6, SpringLayout.SOUTH, toolBar);
		springLayout.putConstraint(SpringLayout.WEST, lblBarcode, 10, SpringLayout.WEST, toolBar);
		springLayout.putConstraint(SpringLayout.EAST, lblBarcode, 63, SpringLayout.WEST, this);
		add(lblBarcode);
		
		barcodeField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, barcodeField, 1, SpringLayout.SOUTH, toolBar);
		springLayout.putConstraint(SpringLayout.WEST, barcodeField, 5, SpringLayout.EAST, lblBarcode);
		add(barcodeField);
		barcodeField.setColumns(10);
		
		btnScannen = new JButton("scannen");
		springLayout.putConstraint(SpringLayout.EAST, barcodeField, -5, SpringLayout.WEST, btnScannen);
		springLayout.putConstraint(SpringLayout.EAST, btnScannen, -10, SpringLayout.EAST, this);
		btnScannen.setActionCommand("scannen");
		springLayout.putConstraint(SpringLayout.NORTH, btnScannen, -5, SpringLayout.NORTH, lblBarcode);
		add(btnScannen);
		
		btnDruckenfertig = new JButton("Drucken/fertig");
		btnDruckenfertig.setActionCommand("print");
		springLayout.putConstraint(SpringLayout.SOUTH, btnDruckenfertig, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDruckenfertig, -10, SpringLayout.EAST, this);
		add(btnDruckenfertig);
	}
}
