package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import business.ProgramManager;
import business.entity.Ausleihe;

public class AusleiheListViewController extends ViewController<AusleiheListView> {
	
	public AusleiheListViewController(AusleiheListView view) {
		super(view);
		view.getBtnZurueck().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
		
		List<Ausleihe> data = ProgramManager.getInstance().getBenutzer().getAusgelieheneMedien();
		String[] columns = view.columnNames();
		TableModel model = new AbstractTableModel() {
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex) {
				case 0: return data.get(rowIndex).getExemplar().getMedium().getId();
				case 1: return data.get(rowIndex).getExemplar().getMedium().getTitel();
				case 2: return data.get(rowIndex).getExemplar().getBarcode();
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
