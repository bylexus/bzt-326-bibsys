package frontend;

import java.awt.Component;

import business.ProgramManager;
import business.entity.Benutzer;

abstract public class ViewController<T extends Component> {
	protected T view;
	
	public ViewController(T view) {
		this.setView(view);
	}
	
	public T getView() {
		return view;
	}
	
	public void setView(T view) {
		this.view = view;
	}
	
	public Benutzer getLoggedInBenutzer() {
		return ProgramManager.getInstance().getBenutzer();
	}
}
