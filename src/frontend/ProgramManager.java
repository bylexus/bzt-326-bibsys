package frontend;

import java.util.Stack;

import business.entity.Benutzer;
import frontend.controller.IViewController;
import persistence.DBH;

public class ProgramManager {
	private static ProgramManager _inst;
	
	
	Stack<IViewController<?>> controlStack;
	IViewController<?> currentController = null;
	
	Benutzer benutzer = null;
	
	private ProgramManager() {
		controlStack = new Stack<>();
	}
	
	public static ProgramManager getInstance() {
			if (ProgramManager._inst == null) {
				ProgramManager._inst = new ProgramManager();
			}
			return ProgramManager._inst;
	}
	
	public void addNext(IViewController<?> ctrl) {
		controlStack.push(ctrl);
	}
	
	public IViewController<?> getCurrent() {
		return this.currentController;
	}
	
	public void startCurrent() {
		while (!controlStack.isEmpty()) {
			currentController = controlStack.peek();
			currentController.showView();
			if (currentController != controlStack.peek()) {
				startCurrent();
			} else {
				controlStack.pop();
			}
		}
		shutdown();
	}
	
	public IViewController<?> popCurrent() {
		return controlStack.pop();
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	
	public void shutdown() {
		DBH.getInst().shutdown();
		System.exit(0);
	}
}
