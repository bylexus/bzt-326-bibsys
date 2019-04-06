package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import business.ProgramManager;
import business.entity.Medium;

public class AusleiheListViewController extends ViewController<AusleiheListView> {
	
	public AusleiheListViewController(AusleiheListView view) {
		super(view);
		view.getBtnZurueck().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
		
		Vector<Medium> data = new Vector<>(ProgramManager.getInstance().getBenutzer().getAusgelieheneMedien());
		String[] columns = view.columnNames();
		TableModel model = new AbstractTableModel() {
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex) {
				case 0: return data.elementAt(rowIndex).getId();
				case 1: return data.elementAt(rowIndex).getTitel(); 
				}
				return null;
			}
			
			@Override
			public int getRowCount() {
				return data.size();
			}
			
			@Override
			public int getColumnCount() {
				return columns.length;
			}
			
			@Override
			public String getColumnName(int col) {
		        return columns[col];
		    }
		};
		view.getMedienList().setModel(model);
	}
}
