package persistence;

abstract public class ModelManager<E> {
	public DataContainer getDataContainer() {
		return DataContainer.getInst();
	}
	
	abstract public void store(E entity);
}
