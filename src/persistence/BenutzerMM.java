package persistence;

import business.entity.Benutzer;
import business.entity.Person;

public class BenutzerMM extends ModelManager<Benutzer> {
	
	Benutzer createBenutzer(Person p) {
		DataContainer dc = DataContainer.getInst();
		
		Benutzer b = new Benutzer();
		b.setId(dc.getNextId());
		b.setLogin(p.getName().toLowerCase() + "_" + p.getVorname().toLowerCase()+b.getId());
		b.setPasswort(""+b.getId());
		b.setPerson(p);
		this.store(b);
		return b;
	}

	@Override
	public void store(Benutzer entity) {
		if (!this.getDataContainer().benutzerList.contains(entity)) {
			this.getDataContainer().benutzerList.add(entity);
		}
	}
	
	public Benutzer findUserByLogin(String username, String password) {
		for (Benutzer b : this.getDataContainer().benutzerList) {
			if (b.getLogin().equals(username) && b.getPasswort().equals(password)) {
				return b;
			}
		}
		return null;
	}
}
