package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import business.ProgramManager;
import business.entity.Medium;

public class HelloViewController extends ViewController<HelloView> {
	
	public HelloViewController(HelloView view) {
		super(view);
		view.getBtnZurueck().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
		
		
		view.getBtnAnzeige().addActionListener(e -> {
			String text = view.getNameField().getText();
			JOptionPane.showMessageDialog(view, "Hello, " + text);
		});
	}
}
