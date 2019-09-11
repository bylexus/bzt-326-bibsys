package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import business.ProgramManager;
import business.entity.Medium;
import persistence.MediumMM;

public class MedienScannenViewController extends ViewController<MedienScannenView> implements ActionListener {
	MediumMM mediumManager;
	
	public MedienScannenViewController(MedienScannenView view) {
		super(view);
		mediumManager = new MediumMM();
		view.btnZurueck.addActionListener(this);
		view.btnScannen.addActionListener(this);
		view.btnDruckenfertig.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().contentEquals("back")) {
			ProgramManager.getInstance().requestRemoveLastPanel();
		} else if (e.getActionCommand().equals("scannen")) {
			this.scanMedium();
		}
	}
	
	protected void scanMedium() {
		String barcode = this.view.barcodeField.getText();
		if (barcode.length() < 1) {
			this.view.textArea.append("Nichts zum Scannen ....\n");	
		} else {
			SwingWorker worker = new SwingWorker<String, String>() {
				@Override
				protected String doInBackground() throws Exception {
					String barcode = view.barcodeField.getText();
					publish("Starte scan für Barcode: " + barcode + "\n");
					Medium m = mediumManager.findMediumByBarcode(barcode);
					Thread.sleep(500);
					if (m == null) {
						publish("Kein Medium für diesen Barcode gefunden!\n");
					} else if (m.getAusgeliehenVon() != null) {
						publish("Medium bereits ausgeliehen von: " + m.getAusgeliehenVon().getLogin() + "\n");
					} else {
						publish("Medium ausleihen .... ");
						m.setAusgeliehenVon(ProgramManager.getInstance().getBenutzer());
						ProgramManager.getInstance().getBenutzer().getAusgelieheneMedien().add(m);
						Thread.sleep(200);
						publish("Erfolg! \n");
					}
					Thread.sleep(500);
					return "Scan fertig.\n";
				}
				
				@Override
				protected void process(List<String> nachricht) {
					for (String s : nachricht) {
						MedienScannenViewController.this.view.textArea.append(s);
					}
				}
				
				@Override
				public void done() {
					try {
						view.textArea.append(get());
						view.btnScannen.setEnabled(true);
						view.barcodeField.setText("");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			};
			this.view.btnScannen.setEnabled(false);
			this.view.textArea.append("Scanne ...");
			worker.execute();
		}
	}
}
