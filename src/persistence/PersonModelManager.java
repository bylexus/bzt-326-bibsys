package persistence;

import business.entity.Benutzer;
import business.entity.Person;

public class PersonModelManager extends ModelManager<Person> {
	
	public Person createPerson(String nachname, String vorname, String email) {
		Person p = new Person();
		p.setNachname(nachname);
		p.setVorname(vorname);
		p.setEmail(email);
		
		this.createBenutzerForPerson(p);
		this.store(p);
		return p;
	}
	
	public Benutzer createBenutzerForPerson(Person p) {
		Benutzer b = new Benutzer();
		b.setLogin(
			p.getVorname().substring(0, 1) + 
			p.getNachname().substring(0, 1) + 
			Integer.toString((int)(Math.round(Math.random() * 1000000)))
		);
		b.setPasswort(Integer.toString((int)Math.round(Math.random() * 100000000)));
		p.setBenutzer(b);
		b.setPerson(p);
		return b;
	}
	
	public void deletePerson(Person p) {
		Benutzer b = p.getBenutzer();
		b.setPerson(null);
		p.setBenutzer(null);
		this.getDataContainer().benutzerList.remove(b);
		this.getDataContainer().personList.remove(p);
	}
	
	@Override
	public void store(Person entity) {
		if (!this.getDataContainer().personList.contains(entity)) {
			this.getDataContainer().personList.add(entity);
		}
		if (!this.getDataContainer().benutzerList.contains(entity.getBenutzer())) {
			this.getDataContainer().benutzerList.add(entity.getBenutzer());
		}
	}
	
	public Person findPersonByNameVorname(String nachname, String vorname) {
		for (Person b : this.getDataContainer().personList) {
			if (b.getNachname().equals(nachname) && b.getVorname().equals(vorname)) {
				return b;
			}
		}
		return null;
	}
	
	public Person findPersonByLogin(String login) {
		for (Person p : this.getDataContainer().personList) {
			Benutzer b = p.getBenutzer();
			if (b != null && b.getLogin().equals(login)) {
				return p;
			}
		}
		return null;
	}
}
