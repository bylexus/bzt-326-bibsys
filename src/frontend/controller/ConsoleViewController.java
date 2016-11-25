package frontend.controller;

import frontend.view.IView;

public class ConsoleViewController<T extends IView> implements IViewController<T> {
	protected T view;
	
	public T getView() {
		return view;
	}
	
	public void setView(T view) {
		this.view = view;
	}
	
	@Override
	public void showView() {
		if (view != null) {
			beforeViewShow();
			view.show();
			afterViewShow();
		}
	}
	
	protected void beforeViewShow() {}
	protected void afterViewShow() {}

}
