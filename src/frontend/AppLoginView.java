package frontend;

import java.security.MessageDigest;
import javax.persistence.EntityManager;
import business.entity.Benutzer;
import persistence.DBH;

public class AppLoginView extends ConsoleView {
	String choose = "";
	Benutzer loggedInUser = null;
	
	public AppLoginView() {
		this.setController(new AppLoginViewController(this));
	}
	
	public String getChoose() {
		return choose;
	}
	

	@Override
	public void displayView() {
		String login,pass;
		clearScreen();
		this.loggedInUser = null;
		
		out("W E L C O M E   to   B-I-B-S-Y-S");
		out("================================\n");
		
		while (this.loggedInUser == null) {
			login = ask("Login:");
			pass = ask("Passwort:");
			if (pass.equals("")) {
				ProgramManager.getInstance().shutdown();
			}
			this.loggedInUser = this.loadBenutzer(login, pass);
			if (this.loggedInUser == null) {
				out("*** Falsches Passwort. Nochmals. ***");
			}
		}
	}
	
	protected Benutzer loadBenutzer(String login, String pw) {
		Benutzer b = null;
		EntityManager em = DBH.getInst().getEntityManager();
		
		try {
			b = em
					.createQuery("from Benutzer where login = :login and passwort = :pw", Benutzer.class)
					.setParameter("login", login)
					.setParameter("pw", sha256(pw))
					.getSingleResult();
		} catch(Exception e) {
		}
		return b;
		
	}
	
	public String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
}
