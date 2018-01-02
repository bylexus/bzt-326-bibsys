package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n");
		}
	}
	
	public void out(String s) {
		System.out.println(s);
	}
	
	public String ask(String text) {
		String input = "";
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print(text + " ");
	        try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return input;
	}
}
