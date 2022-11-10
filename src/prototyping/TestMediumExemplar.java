package prototyping;

import business.entity.Buch;
import business.entity.Medium;
import business.entity.MediumExemplar;
import persistence.MediumMM;

/**
 * Demo: 1:n-Assoziation Medium -> MediumExemplar
 * 
 * Das Demo zeigt das Erstellen von Medien und zugehörigen Exemplaren und deren Zuweisung.
 * Das Demo stellt sicher, dass das Objektmodell konsistent bleibt:
 * 
 * die eigentliche Zuweisungslogik findet in einer Facade-Methode (MediumMM.linkMediumEdemplar) statt:
 * diese sorgt dafür, dass das Objektmodell konsistent bleibt.
 * 
 * Dies ist auch so, wenn ein Exemplar zu einem anderen Medium verschoben wird.
 * 
 */
public class TestMediumExemplar {
	
	public static void main(String[] args) {
		// Erstellen von Medien:
		Medium m1 = new Buch(); m1.setTitel("Buch 1");
		Medium m2 = new Buch(); m2.setTitel("Buch 2");
		
		// Erstellen von Exemplaren:
		MediumExemplar me1 = new MediumExemplar(); me1.setExemplarNr(1);
		MediumExemplar me2 = new MediumExemplar(); me2.setExemplarNr(2);
		MediumExemplar me3 = new MediumExemplar(); me3.setExemplarNr(3);
		MediumExemplar me4 = new MediumExemplar(); me4.setExemplarNr(4);
		
		
		// Zuweisung Medium -> MediumExemplar:
		MediumMM mm = new MediumMM();
		mm.linkMediumExemplar(m1, me1);
		mm.linkMediumExemplar(m1, me2);
		mm.linkMediumExemplar(m2, me3);
		mm.linkMediumExemplar(m2, me4);
		
		
		// Kontrolle:
		System.out.println("Medium 1:" + m1.getTitel());
		for (MediumExemplar me : m1.getExemplare()) {
			System.out.println("    Exemplar: " + me.getExemplarNr() + "(Link zu: "+me.getMedium().getTitel() + ")");
		}
		
		System.out.println("\nMedium 2:" + m2.getTitel());
		for (MediumExemplar me : m2.getExemplare()) {
			System.out.println("    Exemplar: " + me.getExemplarNr() + "(Link zu: "+me.getMedium().getTitel() + ")");
		}
		
		
		
		// Umhängen eines Exemplars zu einenm anderen Medium:
		System.out.println("\nUmhängen: Exemplar2 kommt neu zu Buch 2:");
		mm.linkMediumExemplar(m2, me2);
		
		// Kontrolle:
		System.out.println("Medium 1:" + m1.getTitel());
		for (MediumExemplar me : m1.getExemplare()) {
			System.out.println("    Exemplar: " + me.getExemplarNr() + "(Link zu: "+me.getMedium().getTitel() + ")");
		}
		
		System.out.println("\nMedium 2:" + m2.getTitel());
		for (MediumExemplar me : m2.getExemplare()) {
			System.out.println("    Exemplar: " + me.getExemplarNr() + "(Link zu: "+me.getMedium().getTitel() + ")");
		}
				
	}
}
