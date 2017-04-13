package frontend;

import java.security.MessageDigest;

import javax.persistence.EntityManager;

import business.entity.Benutzer;
import persistence.DBH;

public class AppLoginViewController extends ViewController {
	
	public AppLoginViewController(AppLoginView view) {
		super(view);
	}
	
	public void credentialsEntered(String username, String pw) {
		if (pw.equals("")) {
			ProgramManager.getInstance().shutdown();
		}
		((AppLoginView)view).loggedInUser = this.loadBenutzer(username, pw);
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
	
	@Override
	public void beforeViewShow() {
		ProgramManager.getInstance().setBenutzer(null);
	};
	
	@Override
	public void afterViewShow() {
		AppLoginView view = (AppLoginView)this.getView();
		ProgramManager.getInstance().setBenutzer(view.loggedInUser);
		ProgramManager.getInstance().addNext(new RoleSelectView(view.loggedInUser));
	}
}
