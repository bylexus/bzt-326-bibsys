package business.entity;

import java.io.Serializable;

import business.Toolbox;

public class CD extends Medium implements Serializable {
	private static final long serialVersionUID = 2241614661073434215L;
	private String ean;
	private Interpret interpret;
	
	public CD() {
		super();
	}
	
	public CD(String titel) {
		super();
		this.setTitel(titel);
	}

	
	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public Interpret getInterpret() {
		return interpret;
	}

	public void setInterpret(Interpret interpret) {
		this.interpret = interpret;
	}
	
	@Override
	public String createHtml(int indent) {
		String indentStr = Toolbox.repeatStr(" ", indent);
		String indentStr2 = Toolbox.repeatStr(" ", indent + 4);
		String ret = indentStr + "<div class='buch'>\n";
		ret += indentStr2 + String.format("'%s', von %s %s (EAN: %s)\n", this.getTitel(), this.getInterpret().getVorname(), this.getInterpret().getName(), this.getEan());
		return ret + indentStr + "</div>\n";
	}

}
