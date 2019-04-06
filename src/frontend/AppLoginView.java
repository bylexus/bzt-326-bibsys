package frontend;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import business.entity.Benutzer;

public class AppLoginView extends JFrame {
	private Benutzer benutzer;
	
	private AppLoginViewController ctrl;
	private List<ActionListener> loginListeners = new LinkedList<>();
	
	private JTextField loginField;
	private JPasswordField passwordField;
	private JButton btnBeenden;
	private JButton btnLogin;
	private JLabel errorLabel;
	
	public AppLoginView() {
		initUI();
		this.ctrl = new AppLoginViewController(this);
	}
	
	protected void initUI() {
		// UI setup:
		setTitle("Welcome to B-I-B-S-Y-S  - Login");
		setBounds(100, 100, 450, 138);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblLogin = new JLabel("Login:");
		getContentPane().add(lblLogin, "1, 2, right, default");
		
		loginField = new JTextField();
		getContentPane().add(loginField, "2, 2, fill, default");
		loginField.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		getContentPane().add(lblPasswort, "1, 4, right, default");
		
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "2, 4, fill, default");
		
		btnBeenden = new JButton("Beenden");
		
		btnBeenden.setActionCommand("beenden");
		getContentPane().add(btnBeenden, "1, 6");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "2, 6, right, top");
		
		errorLabel = new JLabel("error");
		errorLabel.setVisible(false);
		errorLabel.setForeground(Color.RED);
		panel.add(errorLabel);
		
		btnLogin = new JButton("Login");
		panel.add(btnLogin);
		btnLogin.setActionCommand("login");
	}
	
	public void addLoginListener(ActionListener a) {
		this.loginListeners.add(a);
	}
	
	public List<ActionListener> getLoginListeners() {
		return this.loginListeners;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	
	public JButton getBeendenBtn() {
		return btnBeenden;
	}
	public JButton getLoginBtn() {
		return btnLogin;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
}
