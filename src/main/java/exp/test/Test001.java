package exp.test;

import java.util.Arrays;

public class Test001 {

	public static void main(String[] args) {

		// boolean t = true;
		// boolean f = false;
		//
		// System.out.println("FALSE:" + String.valueOf((f ? 1:0)));
		// System.out.println("TRUE:" + String.valueOf((t ? 1:0)));

		String df = "000442073341070:BKarl.external@Unicredit.de##";

		String[] gh = df.split("#");
		System.out.println("Länge: " + gh.length);

		System.out.println("FAX: " + gh[0]);
		System.out.println("SMAIL: " + gh[1]);
		System.out.println("ZMAIL: " + gh[2]);

		// Arrays.asList(a)
	}

}
