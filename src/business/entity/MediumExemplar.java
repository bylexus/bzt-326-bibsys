package business.entity;

import java.io.Serializable;
import java.util.Date;

import business.PrintListComposite;
import business.Toolbox;

public class MediumExemplar implements Serializable, PrintListComposite {
	private static final long serialVersionUID = 7004318921774995446L;
	private Long id;
	private boolean ausleihbar;
	private String exemplarNr;
	private Date ausgeliehenAm;
	private Date ausgeliehenBis;
	private Medium medium;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isAusleihbar() {
		return ausleihbar;
	}
	public void setAusleihbar(boolean ausleihbar) {
		this.ausleihbar = ausleihbar;
	}
	public String getExemplarNr() {
		return exemplarNr;
	}
	public void setExemplarNr(String exemplarNr) {
		this.exemplarNr = exemplarNr;
	}
	public Date getAusgeliehenAm() {
		return ausgeliehenAm;
	}
	public void setAusgeliehenAm(Date ausgeliehenAm) {
		this.ausgeliehenAm = ausgeliehenAm;
	}
	public Date getAusgeliehenBis() {
		return ausgeliehenBis;
	}
	public void setAusgeliehenBis(Date ausgeliehenBis) {
		this.ausgeliehenBis = ausgeliehenBis;
	}
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	public String getBarcode() {
		if (this.getMedium() != null) {
			return this.getMedium().getMediennummer() + "-" + this.getExemplarNr();
		} else {
			return "???-" + this.getExemplarNr();
		}
	}
	@Override
	public String createHtml(int indent) {
		String indentStr = Toolbox.repeatStr(" ", indent);
		if (this.getMedium() != null) {
			String out =  indentStr + "<div class='exemplar'>\n";
			if (this.ausgeliehenBis != null) {
				out += indentStr + indentStr + "Ausgeliehen von: " + this.getAusgeliehenAm().toString() + " bis " + this.getAusgeliehenBis().toString() + "\n";
			}
			out += indentStr + indentStr + this.getMedium().createHtml(indent + 4);
			return out + indentStr + "</div>\n";
		} else {
			return indentStr + "<div class='error'>No Medium assigned</div>\n";
		}
	}
}
