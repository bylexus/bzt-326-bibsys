package playground;

import business.entity.Autor;
import business.entity.Buch;
import business.entity.CD;
import business.entity.Interpret;
import business.entity.MediumExemplar;
import persistence.DataContainer;

/**
 * Hilfsprogramm, um ein paar Medien zu erstellen
 */
public class GenerateMedien {
	public static void main(String[] args) {
		Buch b;
		Autor a;
		Interpret i;
		CD c;
		MediumExemplar e;
		DataContainer dc = DataContainer.getInst();
		
		a = new Autor();
		a.setNachname("King");
		a.setVorname("Stephen");
		
		// Buch 1
		b = new Buch();
		b.setAutor(a);
		b.setTitel("In einer kleinen Stadt");
		b.setIsbn("9-1234-567-891");
		b.setMediennummer("111");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		b.getExemplare().add(e); e.setMedium(b);
		dc.medienList.add(b);
		
		// Buch 2
		b = new Buch();
		b.setAutor(a);
		b.setTitel("Tommyknockers");
		b.setIsbn("9-1234-567-321");
		b.setMediennummer("222");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		b.getExemplare().add(e); e.setMedium(b);
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("2");
		b.getExemplare().add(e); e.setMedium(b);
		dc.medienList.add(b);
		
		// Buch 3
		b = new Buch();
		b.setAutor(a);
		b.setTitel("The Stand");
		b.setIsbn("9-1234-543-211");
		b.setMediennummer("333");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		b.getExemplare().add(e); e.setMedium(b);
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("2");
		b.getExemplare().add(e); e.setMedium(b);
		dc.medienList.add(b);
		
		i = new Interpret();
		i.setName("Muse");
		i.setVorname("");
		
		// CD 1
		c = new CD();
		c.setMediennummer("444");
		c.setTitel("Black holes and revelations");
		c.setInterpret(i);
		c.setEan("987654321");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		c.getExemplare().add(e); e.setMedium(c);
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("2");
		c.getExemplare().add(e); e.setMedium(c);
		dc.medienList.add(c);
		
		// CD 2
		c = new CD();
		c.setMediennummer("555");
		c.setTitel("Drones");
		c.setInterpret(i);
		c.setEan("37285763");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		c.getExemplare().add(e); e.setMedium(c);
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("2");
		c.getExemplare().add(e); e.setMedium(c);
		dc.medienList.add(c);
		
		// CD 2
		c = new CD();
		c.setMediennummer("666");
		c.setTitel("The Resistance");
		c.setInterpret(i);
		c.setEan("15648569873");
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("1");
		c.getExemplare().add(e); e.setMedium(c);
		e = new MediumExemplar();
		e.setAusleihbar(true);
		e.setExemplarNr("2");
		c.getExemplare().add(e); e.setMedium(c);
		dc.medienList.add(c);
		
		dc.shutdown();
	}
}
