package frontend;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import business.entity.Person;

public class PersonEingabeView extends JPanel {
	PersonEingabeViewController ctrl;
	JButton btnZurueck;
	JTextField nameField;
	JTextField vornameField;
	JTextField emailField;
	JButton btnSpeichern;
	
	Person model;
	
	public PersonEingabeView(Person model) {
		this.model = model;
		
		initUI();
		initData();
		ctrl = new PersonEingabeViewController(this);
		
		
	}
	
	protected void initUI() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:min"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("22px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		JToolBar toolBar = new JToolBar();
		add(toolBar, "1, 1, fill, top");
		btnZurueck = new JButton("zurück");
		toolBar.add(btnZurueck);
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "1, 3, left, default");
		
		nameField = new JTextField();
		add(nameField, "2, 3, fill, default");
		nameField.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		add(lblVorname, "1, 5, left, default");
		
		vornameField = new JTextField();
		add(vornameField, "2, 5, fill, default");
		vornameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "1, 7, left, default");
		
		emailField = new JTextField();
		add(emailField, "2, 7, fill, default");
		emailField.setColumns(10);
		
		btnSpeichern = new JButton("Speichern");
		add(btnSpeichern, "2, 9, right, default");
	}
	
	protected void initData() {
		this.nameField.setText(model.getName());
		this.vornameField.setText(model.getVorname());
		this.emailField.setText(model.getEmail());
	}
}
