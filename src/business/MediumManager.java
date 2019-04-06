package business;

import business.entity.CD;
import business.entity.Interpret;

public class MediumManager {
	private static long nextMediumNummer = 1;
	
	public CD createCdWithInterpret(String titel, Interpret i) {
		CD cd = new CD(titel);
		cd.setMediennummer(Long.toString(nextMediumNummer++));
		cd.setInterpret(i);
		i.addWerk(cd);
		return cd;
	}
}
