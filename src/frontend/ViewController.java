package frontend;

import java.util.Observable;
import java.util.Observer;

import business.entity.Benutzer;

abstract public class ViewController implements Observer {
	protected View view;
	
	public ViewController(View view) {
		this.setView(view);
	}
	
	public View getView() {
		return view;
	}
	
	public void setView(View view) {
		this.view = view;
		view.addObserver(this);
	}
	
	public Benutzer getLoggedInBenutzer() {
		return ProgramManager.getInstance().getBenutzer();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg == View.ACTION.BEFORE_SHOW) {
			this.beforeViewShow();
		}
		if (arg == View.ACTION.AFTER_SHOW) {
			this.afterViewShow();
		}
	}
	
	public void beforeViewShow() {}
	public void afterViewShow() {}
	public abstract View getNextView();
}
