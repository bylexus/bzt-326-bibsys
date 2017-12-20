package frontend;

import java.util.Observable;

abstract public class View extends Observable{
	protected ViewController controller;
	
	public static enum ACTION  {
		BEFORE_SHOW,
		AFTER_SHOW
	};
	
	public final View show() {
		setChanged();
		notifyObservers(ACTION.BEFORE_SHOW);
		displayView();
		setChanged();
		notifyObservers(ACTION.AFTER_SHOW);
		
		return this.getController().getNextView();
	}
	
	abstract public void displayView();
	
	public void setController(ViewController ctrl) {
		this.controller = ctrl;
	}
	
	public ViewController getController() {
		return this.controller;
	}
	
	public void dispose() {
		this.deleteObservers();
	}
}
