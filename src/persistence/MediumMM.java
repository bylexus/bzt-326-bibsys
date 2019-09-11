package persistence;

import business.entity.Medium;

public class MediumMM extends ModelManager<Medium> {

	@Override
	public void store(Medium entity) {
		if (!this.getDataContainer().medienList.contains(entity)) {
			this.getDataContainer().medienList.add(entity);
		}
	}
	
	public Medium findMediumByBarcode(String barcode) {
		for (Medium m : this.getDataContainer().medienList) {
			if (m.getBarcode().equals(barcode)) {
				return m;
			}
		}
		return null;
	}
}
