package persistence;

import java.util.Calendar;
import java.util.Date;

import business.entity.Ausleihe;
import business.entity.Benutzer;
import business.entity.Medium;
import business.entity.MediumExemplar;

public class MediumMM extends ModelManager<Medium> {

	@Override
	public void store(Medium entity) {
		if (!this.getDataContainer().medienList.contains(entity)) {
			this.getDataContainer().medienList.add(entity);
		}
	}
	
	public MediumExemplar findFreeMediumExemplarByBarcode(String barcode) {
		for (Medium m : this.getDataContainer().medienList) {
			for (MediumExemplar ex : m.getExemplare()) {
				if (ex.getBarcode().equals(barcode) && ex.istAusleihbar()) {
					return ex;
				}
			}
		}
		return null;
	}
	public MediumExemplar createNewExemplar(Medium m) {
		int nr = m.getExemplare().size() + 1;
		MediumExemplar ex = new MediumExemplar();
		ex.setExemplarNr(nr);
		ex.setBarcode("code-" + m.getMediennummer() + "-" + nr);
		this.linkMediumExemplar(m, ex);
		return ex;
	}
	
	

	/**
	 * Facade-Methode, welche das Verbinden eines Mediums mit einem Medien-Exemplar
	 * vollzieht: Die Methode "versteckt" die Komplexität beim Zuweisen
	 * der 1:n-Beziehung und sorgt für ein konsistentes Objektmodell: 
	 */
	public void linkMediumExemplar(Medium m, MediumExemplar me) {
		// Aufräumen der alten Beziehung:
		if (me.getMedium() != null) {
			me.getMedium().getExemplare().remove(me);
		}
		
		// Neu zuweisen:
		if (m.getExemplare().contains(me) != true) {
			m.getExemplare().add(me);
			me.setMedium(m);
		}
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
}
