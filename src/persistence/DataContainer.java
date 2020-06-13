package persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import business.entity.Autor;
import business.entity.Benutzer;
import business.entity.Buch;
import business.entity.Medium;

public class DataContainer implements Serializable{
	private static final long serialVersionUID = 962047350284408762L;
	
	private long lastGlobalId = 0;
	
	public List<Benutzer> benutzerList = new ArrayList<>();
	public List<Medium> medienList = new ArrayList<>();
	
	private static DataContainer _inst;
	
	private DataContainer() {
	}
	
	public static DataContainer getInst() {
		if (DataContainer._inst == null) {
			try {
				System.out.print("Reading serialized data ... ");
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("serialized.data")));
				DataContainer._inst = (DataContainer)ois.readObject();
				ois.close();
				System.out.println("done.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}	
		}
		
		// Still null (not deserialized), so generate instance and create sample data:
		if (DataContainer._inst == null) {
			DataContainer._inst = new DataContainer();
			DataContainer._inst.generateExampleData();
		}
		return DataContainer._inst;
	}
	
	private void generateExampleData() {
		if (benutzerList.isEmpty()) {
			generateSampleBenutzer(benutzerList);
		}
		if (medienList.isEmpty()) {
			generateSampleBuecher(medienList);
		}
		generateSampleAusleihen(benutzerList.get(0),medienList);
		
	}
	
	private void generateSampleBenutzer(List<Benutzer> list) {
		for (int i = 1; i < 5; i++) {
			Benutzer b = new Benutzer();
			b.setId(this.getNextId());
			b.setLogin("benutzer"+i);
			b.setVorname("Vorname "+i);
			b.setNachname("Nachname "+i);
			b.setPasswort(""+i);
			list.add(b);
			System.out.println(String.format("Sample user added: %s %s (Login: %s, PW: %s", b.getVorname(), b.getNachname(), b.getLogin(), b.getPasswort()));
		}
	}
	
	private void generateSampleBuecher(List<Medium> list) {
		for (int i = 1; i < 5; i++) {
			Buch b = new Buch();
			b.setId(this.getNextId());
			Autor a = new Autor();
			a.setNachname("Autor "+i);
			b.setTitel("Buch "+i);
			b.setIsbn("345-123-"+i+i+i);
			b.setAutor(a);
			list.add(b);
		}
	}
	
	
	private void generateSampleAusleihen(Benutzer b, List<Medium> medien) {
		Medium m;
		if (b.getAusgelieheneMedien().isEmpty()) {
			m = medien.get(0);
			m.setAusgeliehenVon(b);
			b.getAusgelieheneMedien().add(m);
			
			m = medien.get(1);
			m.setAusgeliehenVon(b);
			b.getAusgelieheneMedien().add(m);
		}
	}
	
	private long getNextId() {
		this.lastGlobalId++;
		return this.lastGlobalId;
	}
	
	public void shutdown() {
		try {
			System.out.print("Serializing data ... ");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("serialized.data")));
			oos.writeObject(this);
			oos.close();
			System.out.println("done.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
