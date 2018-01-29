package exp.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test002 {

	public static String[] buh;

	public static boolean findDataFile(String name) throws IOException {

		Path path = Paths.get("C:/MARS");

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, name);) {

			Iterator<Path> iterator = directoryStream.iterator();
			if (iterator.hasNext()) {
				Path file = iterator.next();

				System.out.println(file);
				System.out.println(file.getFileName().toString().split("_")[1].split("\\.")[0]);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		String[] duf = new String[] { "A", "B", "C", "x" };
		System.out.println(String.join("<->", duf));

		Integer kl = null;
		System.out.println(String.valueOf(kl));

		System.out.println(String.join("", "AAA", "YYY"));

		if (buh == null) {
			System.out.println("buh ist null");
		}

		String fg = "";
		String[] bn = fg.split(",");
		for (String string : bn) {
			System.out.println("->" + string);
		}

		Integer jk = null;

		System.out.println(jk.toString());

		String zl = "&test.pdf";
		for (String pl : zl.split("&")) {
			System.out.println(pl + "_pl");
		}

		String a = "20170319";
		String b = "20170529";

		int comp = a.compareToIgnoreCase(b);
		System.out.println(comp);

		if (comp < 0) {
			System.out.println("a < b");
		}

		if (comp == 0) {
			System.out.println("a == b");
		}

		if (comp > 0) {
			System.out.println("a > b");
		}

	}

}
