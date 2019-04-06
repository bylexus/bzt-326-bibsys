package playground;

import business.MediumManager;
import business.entity.CD;
import business.entity.Interpret;
import business.entity.Medium;

public class MediumInterpretTest {

	public static void main(String[] args) {
		MediumManager mm = new MediumManager();
		
		Interpret i = new Interpret("Marley", "Bob");
		CD cd1 = mm.createCdWithInterpret("Legends", i);
		CD cd2 = mm.createCdWithInterpret("Exodus", i);
		CD cd3 = mm.createCdWithInterpret("Rastaman Vibration", i);
		
		System.out.println("Liste der Alben von " + i.getVorname() + " " + i.getName() + ":");
		for (Medium m : i.getWerke()) {
			System.out.println(m.getClass().getName() + ": "+m.getTitel());
		}
		
		System.out.println("Interpret der CD " + cd1 + ": " + cd1.getInterpret().getVorname() + " " + cd1.getInterpret().getName());
		
	}
}
