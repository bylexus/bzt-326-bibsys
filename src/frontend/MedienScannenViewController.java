package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import business.ProgramManager;
import business.entity.Ausleihe;
import business.entity.Medium;
import business.entity.MediumExemplar;
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
			SwingWorker<String, String> worker = new SwingWorker<String, String>() {
				@Override
				protected String doInBackground() throws Exception {
					String barcode = view.barcodeField.getText();
					publish("Starte scan für Barcode: " + barcode + "\n");

					MediumExemplar ex = mediumManager.findFreeMediumExemplarByBarcode(barcode);




					Medium m;
					Thread.sleep(500);
					if (ex == null) {
						publish("Kein Medium für diesen Barcode gefunden!\n");
					} else if (ex.getAusleihe() != null) {
						publish("Medium bereits ausgeliehen von: " + ex.getAusleihe().getBenutzer().getLogin() + "\n");
					} else {
						publish("Medium ausleihen .... ");
						m = ex.getMedium();
						Ausleihe a = mediumManager.createAusleihe(ex, ProgramManager.getInstance().getBenutzer());
						Thread.sleep(200);
						publish("Medium gefunden: " + m.getTitel() + "(Nr: " + m.getMediennummer() + "-"+ex.getExemplarNr() + ")" + "\n");
						publish("Ausleihe bis " + a.getZurueckAm() + "\n");
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
