package business;

public class Toolbox {
	public static String repeatStr(String str, int count) {
		String ret = "";
		for (int i = 0; i < count; i++) {
			ret += str;
		}
		return ret;
	}
}
