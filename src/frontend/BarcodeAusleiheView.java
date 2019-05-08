package frontend;

import business.entity.MediumExemplar;

public class BarcodeAusleiheView extends View {
	public BarcodeAusleiheView() {
		this.setController(new BarcodeAusleiheViewController(this));
	}

	@Override
	public void displayView() {
		BarcodeAusleiheViewController ctrl = (BarcodeAusleiheViewController)this.getController();
		
		clearScreen();
		out("BIBSYS - "+this.controller.getLoggedInBenutzer().getLogin() + " - Barcode-Scan");
		out("==============================================================================\n");
		
		String barcode = "-";
		MediumExemplar ausgeliehenesExemplar = null;
		
		while (barcode.equals("") != true && ausgeliehenesExemplar == null) {
			barcode = ask("Medium-Barcode (MediumNr-ExemplarNr):");
			ausgeliehenesExemplar = ctrl.processBarcodeAusleihe(barcode);
		}
		out(String.format("Medium ausgeliehen: %s, bis %s", ausgeliehenesExemplar.getMedium().getTitel(), ausgeliehenesExemplar.getAusgeliehenBis().toString()));
		ask("");
	}
}
