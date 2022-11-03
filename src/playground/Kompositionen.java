package playground;

import business.entity.Buch;
import business.entity.Medium;
import business.entity.MediumExemplar;

/**
 * Übung von Moodle, Lektion 010:
 * 
 * Erstellen Sie ein Demo-Java-Programm, welches diese Anforderungen demonstriert:

    Unser Bibliothekssystem kennt Medien (Ganzes), welche mehrere Exemplare (Teile) haben können. Erstellen Sie diese beiden Klassen und setzen Sie dies als Komposition in Java um:
    Sorgen Sie dafür, dass beim Erstellen eines Mediums (z.B. Buch) auch gleich ein erstes Exemplar erzeugt wird.
    Erstellen Sie eine Methode auf Medium, welche neue Exemplare erzeugen kann.
    Erstellen Sie eine Methode auf Medium, welche alle Exemplare ausgibt
    Sorgen Sie dafür, dass beim Löschen des Mediums (z.B. aus Datenbank entfernt) auch gleich die zugewiesenen Exemplare gelöscht werden.
    Erstellen Sie eine “Exemplar löschen”-Methode auf dem Medium: Wie stellen Sie sicher, dass niemand das letzte Exemplar löschen kann? Zeigen Sie dies in Ihrer Methode auf!

 * @author alex
 *
 */
public class Kompositionen {
	public static void main(String[] args) {
		// Neues Medium erstellen:
		Medium m = new Buch(1234567);
		
		// Wurde auch ein Exemplar erstellt?
		System.out.println("Medium " + m.getMediennummer() + " hat folgende Exemplare:");
		m.getExemplare().forEach(ex -> System.out.println("Ex: "+ex.getExemplarNr()+", Barcode: " + ex.getBarcode()));
		
		// noch ein paar Exemplare mehr, bitte:
		MediumExemplar me1 = m.getExemplare().get(0); // das erste
		MediumExemplar me2 = m.createNewExemplar();
		MediumExemplar me3 = m.createNewExemplar();
		
		// kann ich alle löschen?
		m.removeExemplar(me1);
		m.removeExemplar(me2);
		m.removeExemplar(me3);
		
		// Ist noch 1 Exemplar vorhanden?
		System.out.println("Medium " + m.getMediennummer() + " hat folgende Exemplare:");
		m.getExemplare().forEach(ex -> System.out.println("Ex: "+ex.getExemplarNr()+", Barcode: " + ex.getBarcode()));
		
		
		// Medium löschen:
		m.delete();
	}
	
}
