package persistence;

import java.util.Calendar;
import java.util.Date;

import business.entity.Benutzer;
import business.entity.CD;
import business.entity.Interpret;
import business.entity.Medium;
import business.entity.MediumExemplar;

public class MediumManager {
	private static long nextMediumNummer = 1;
	
	public CD createCdWithInterpret(String titel, Interpret i) {
		CD cd = new CD(titel);
		cd.setMediennummer(Long.toString(nextMediumNummer++));
		cd.setInterpret(i);
		i.addWerk(cd);
		return cd;
	}
	
	public MediumExemplar ausleiheByBarcode(Benutzer b, String code) {
		Calendar cal = Calendar.getInstance();
		for (Medium m : DataContainer.getInst().medienList) {
			// Suche ein freies Mediumexemplar mit diesem Barcode:
			for (MediumExemplar test : m.getExemplare()) {
				
				if (test.isAusleihbar() == true && test.getAusgeliehenBis() == null && test.getBarcode().equals(code)) {
					cal.setTime(new Date());
					test.setAusgeliehenAm(cal.getTime());
					
					// Ausleihdauer: 30 Tage, also ausgeliehenBis berechnen, setzen:
					cal.add(Calendar.DATE, 30);
					test.setAusgeliehenBis(cal.getTime());
					
					if (b.getAusgelieheneMedien().contains(test) == false) {
						b.getAusgelieheneMedien().add(test);
					}
					return test;
				}
			}
		}
		
		return null;
	}
}
