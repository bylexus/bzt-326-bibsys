package frontend;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import business.ProgramManager;

public class MainWindowController extends ViewController<MainWindow> {
	
	public MainWindowController(MainWindow view) {
		super(view);
		// View-Events anhängen:
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ProgramManager.getInstance().shutdown();
			}
		});
	}
}
