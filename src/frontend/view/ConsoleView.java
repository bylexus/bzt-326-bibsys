package frontend.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public abstract class ConsoleView extends Observable implements IView {

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
	
	@Override
	public void show() {
		clearScreen();
		printView();
	}
	
	abstract public void printView();
}
