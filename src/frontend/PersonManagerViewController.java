package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import business.ProgramManager;
import business.entity.Person;
import persistence.DataContainer;

public class PersonManagerViewController extends ViewController<PersonManagerView> {
	
	public PersonManagerViewController(PersonManagerView view) {
		super(view);
		view.getBtnZurueck().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProgramManager.getInstance().requestRemoveLastPanel();
			}
		});
		
		view.btnNewPerson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonManagerViewController.this.startCreatePerson();
				
			}
		});
		
		List<Person> data = DataContainer.getInst().personList;
		
		String[] columns = view.columnNames();
		TableModel model = new AbstractTableModel() {
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex) {
				case 0: return data.get(rowIndex).getName();
				case 1: return data.get(rowIndex).getVorname();
				case 2: return data.get(rowIndex).getEmail();
				case 3:
					if (data.get(rowIndex).getBenutzer() != null) {
						return data.get(rowIndex).getBenutzer().getLogin();
					} else {
						return "-";
					}
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
	
	public void startCreatePerson() {
		// 1. neue Person instanzieren: Dies ist das Model, welches wir für unsere Formular-View benötigen:
		Person p = new Person();
		
		// 2. View instanzieren, Model übergeben:
		PersonEingabeView v = new PersonEingabeView(p);
		
		// 3. Listener auf View: Wenn View beendet wird, möchten wir die Person-Liste aktualisieren:
		
		// 4. View aufrufen:
		ProgramManager.getInstance().requestMainPanelAdd(v);
	}
}
