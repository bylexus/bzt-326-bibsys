package frontend;

import javax.swing.JOptionPane;

import business.ProgramManager;

public class MeinPanelController extends ViewController<MeinPanel> {
	
	public MeinPanelController(MeinPanel view) {
		super(view);
		
		view.getBtnZurueck().addActionListener(e -> {
				ProgramManager.getInstance().requestRemoveLastPanel();
		});
		
		view.getBtnClickMe().addActionListener(e -> {
			JOptionPane.showMessageDialog(view, "Hello, World!");
		});
	}
}
