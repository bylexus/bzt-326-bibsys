package frontend;

import java.util.Stack;
import business.entity.Benutzer;
import persistence.DataContainer;

public class ProgramManager {
	private static ProgramManager _inst;
	
	Stack<View> viewStack;
	View currentView = null;
	
	Benutzer benutzer = null;
	
	private ProgramManager() {
		viewStack = new Stack<>();
	}
	
	public static ProgramManager getInstance() {
			if (ProgramManager._inst == null) {
				ProgramManager._inst = new ProgramManager();
			}
			return ProgramManager._inst;
	}
	
	public void addNext(View view) {
		viewStack.push(view);
	}
	
	public View getCurrentView() {
		return this.currentView;
	}
	
	public void startCurrentView() {
		while (!viewStack.isEmpty()) {
			currentView = viewStack.peek();
			currentView.show();
			if (currentView != viewStack.peek()) {
				startCurrentView();
			} else {
				popCurrentView();
			}
		}
		shutdown();
	}
	
	public View popCurrentView() {
		View v = viewStack.pop(); 
		v.dispose();
		return v;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	public void shutdown() {
		DataContainer.getInst().shutdown();
		System.exit(0);
	}
}
