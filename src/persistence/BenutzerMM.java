package persistence;

import business.entity.Benutzer;

public class BenutzerMM extends ModelManager<Benutzer> {

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
