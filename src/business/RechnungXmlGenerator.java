package business;

import java.util.List;

import business.entity.Rechnung;

public class RechnungXmlGenerator {
	public String createXml(List<Rechnung> rechnungen) {
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + 
				"<rechnungen>\n";

		for (Rechnung re : rechnungen) {
			result += re.createXml(4);
		}
		
		return result + "</rechnungen>";
	}
}
