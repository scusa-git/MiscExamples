package exp.test;

public class BuilderString {

	public static StringBuilder yes(StringBuilder sb, String name) {
		return sb.append("\n").append(name).append(" - OK");
	}

	public static StringBuilder no(StringBuilder sb, String name) {
		return sb.append("\n").append(name).append(" - NO DATA");
	}

	public static void main(String[] args) {

		StringBuilder jk = new StringBuilder();

		BuilderString.yes(jk, "aaaa");
		BuilderString.no(jk, "oooo");
		BuilderString.no(jk, "mmmm");
		BuilderString.yes(jk, "zzzz");

		System.out.println(jk.toString());

	}
}
