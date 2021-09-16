package playground;

import java.time.LocalDate;

import business.entity.Autor;
import business.entity.Benutzer;
import business.entity.Buch;
import business.entity.Person;
import persistence.MediumMM;
import persistence.PersonManager;

public class Assoziationen {
	public static void main(String[] args) {
		
		// 1:1-Assoziationen realisieren:
		// Person - Benutzer: 1:1-Beziehung: Diese beiden Objekte existieren nur "als Paar":
		// wir verwenden also eine Facade-Methode, welche das Erstellen und Zusammenhängen von
		// Person <-> Benutzer übernimmt:
		PersonManager pm = new PersonManager();
		Person p = pm.createPerson("Skywalker", "Luke", LocalDate.of(1979, 4, 3));
		Benutzer b = p.getBenutzer();
		
		// Navigation Person -> Benutzer:
		System.out.println("Person " + p.getName() + " hat Benutzer: " + p.getBenutzer().getLogin());
		
		// Navigation Benutzer -> Person:
		System.out.println("Benutzer " + b.getLogin() + " hat Person: " + b.getPerson().getName());
		
		// -------------------------------------------------------
		
		
		// 1:n-Assoziation realisieren: Bücher haben Autoren
		// Dazu verwenden wir die Facade-Methode MediumMM.createBuch, welche die notwendigen Assoziationen vornimmt.
		// Die Facade-Methode übernimmt auch die Persistierung in den DataContainer.
		MediumMM mm = new MediumMM();
		Autor a = new Autor();
		a.setNachname("King"); a.setVorname("Stephen");
		Buch buch = mm.createBuch("Mein Buch", "123-456-789", a);
		
		// Navigation demonstrieren:
		System.out.println("Buch " + buch.getTitel() + " hat Autor " + buch.getAutor().getNachname());
		buch.getAutor().getMedien().forEach(medium -> System.out.println("Autor hat medium: " + medium.getTitel()));
		
		// ----------------------------------------------------------
		
		// n:m-Assoziation realisieren Medien und Benutzer können reservieren (via Assoziationsklasse Reservation)
		// Dazu verwenden wir wiederum die Facade-Klasse MediumMM, welche die n:m-Verbindung korrekt herstellt:
		mm.createReservation(buch, b);
		// wir versuchen noch eine 2. Reservation:
		mm.createReservation(buch, b);
		
		// Kontrolle Navigation aus Sicht Medium:
		buch.getReservationen().forEach(res -> {
			System.out.println("Medium " + res.medium.getTitel() + " ist reserviert von " + res.benutzer.getLogin());
		});
		// Kontrolle Navigation aus Sicht Benutzer:
		b.getReservationen().forEach(res -> {
			System.out.println("Benutzer " +res.benutzer.getLogin() + " hat Medium reserviert: " + res.medium.getTitel());
		});
	}
}
