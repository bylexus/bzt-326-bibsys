package persistence;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import business.entity.Ausleihe;
import business.entity.Autor;
import business.entity.Benutzer;
import business.entity.Buch;
import business.entity.Medium;
import business.entity.MediumExemplar;
import business.entity.Reservation;

public class MediumMM extends ModelManager<Medium> {

	@Override
	public void store(Medium entity) {
		if (!this.getDataContainer().medienList.contains(entity)) {
			this.getDataContainer().medienList.add(entity);
		}
	}






	public MediumExemplar findFreeMediumExemplarByBarcode(String barcode) {
		for (Medium m : this.getDataContainer().medienList) {

			MediumExemplar ex = m.findAusleibaresExemplar(barcode);
			if (ex != null) {
				return ex;
			}
		}
		return null;
	}







	public Ausleihe createAusleihe(MediumExemplar ex, Benutzer b) {
		if (ex.istAusleihbar() != true) {
			return null;
		}
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		Ausleihe a = new Ausleihe();
		a.setAusgeliehenAm(now);

		c.add(Calendar.DAY_OF_MONTH, 30);
		a.setZurueckAm(c.getTime());
		a.setExemplar(ex);
		a.setBenutzer(b);
		b.getAusgelieheneMedien().add(a);
		ex.setAusleihe(a);
		return a;
	}

	/**
	 * Facade-Klasse, erstellt eine Reservation eines Mediums zu einem Benutzer,
	 * stellt sicher, dass die Objektmodelle stimmen
	 * 
	 * @param m
	 * @param b
	 * @return
	 */
	public Reservation createReservation(Medium m, Benutzer b) {
		Reservation r = new Reservation();
		r.reserviertAm = LocalDate.now();
		r.medium = m;
		r.benutzer = b;

		// Objektmodell auf Medium und Benutzer richtig stellen: Reservation wird nur
		// aufgenommen,
		// wenn dieses Medium vom selben Benutzer nicht schon reserviert wurde:
		// Prüfen, ob Medium schon von Benutzer reserviert ist:
		if (m.getReservationen().stream().filter(res -> res.benutzer == b).toArray().length == 0) {
			m.getReservationen().add(r);
		}

		// Objektmodell auf Medium und Benutzer richtig stellen: Reservation wird nur
		// aufgenommen,
		// wenn dieses Medium vom selben Benutzer nicht schon reserviert wurde:
		// Prüfen, ob Benutzer Medium schon ausgeliehen hat:
		if (b.getReservationen().stream().filter(res -> res.medium == m).toArray().length == 0) {
			b.getReservationen().add(r);
		}

		return r;
	}

	/**
	 * Facade-Methode, um ein Buch zu erstellen. Verknüpft einen Autoren-Datensatz,
	 * und erstellt gleich ein Exemplar.
	 */
	public Buch createBuch(int nr, String titel, String isbn, Autor autor) {
		Buch b = new Buch(nr);
		b.setTitel(titel);
		b.setIsbn(isbn);

		b.createNewExemplar();

		// Objektmodell-Beziehung Medium (n) - Autor (1) auf beiden Seiten korrekt
		// herstellen
		b.setAutor(autor);
		autor.getMedien().add(b);

		// in DataContainer persistieren:
		this.store(b);
		return b;
	}
}
