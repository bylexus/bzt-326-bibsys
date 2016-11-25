package frontend.controller;

import frontend.view.IView;

public interface IViewController<T extends IView> {
	public void showView();
}
