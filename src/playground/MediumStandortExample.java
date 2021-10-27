package playground;

import business.entity.Buch;
import business.entity.Medium;
import business.entity.Standort;

public class MediumStandortExample {
	public static void main(String[] args) {
		Medium m1 = new Buch();
		m1.setTitel("Mein Buch");

		Standort s1 = new Standort();
		s1.setName("Standort 1");


		s1.addMedium(m1);

		System.out.println("Standort Medium 1: " + m1.getStandort().getName());
	}
}
