package frontend;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private ViewController<MainWindow> ctrl;
	private CardLayout mainLayout;

	public MainWindow() {
		initUI();
		this.ctrl = new MainWindowController(this);
	}
	
	protected void initUI() {
		setTitle("B-I-B-S-Y-S");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		mainLayout = new CardLayout(0, 0);
		getContentPane().setLayout(mainLayout);
	}
	
	public CardLayout getMainLayout() {
		return mainLayout;
	}

}
