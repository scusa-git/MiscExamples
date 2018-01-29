package exp.test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_004 {

	public static void deleteDirectoryRecursively(Path directoryPath) {

		try {
			Files.walkFileTree(directoryPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println("delete file: " + file.toString());
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					System.out.println("delete dir: " + dir.toString());
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void V2(Path directoryPath) throws IOException {

		// Files.walk(directoryPath, FileVisitOption.FOLLOW_LINKS)
		Files.walk(directoryPath).sorted(Comparator.reverseOrder()).map(Path::toFile).peek(System.out::println).forEach(File::delete);

	}

	public void xyz() {
		String test = "AAA_BBB_20170406_201704";

		Pattern pattern = Pattern.compile("20[0-9]{6}");

		Matcher matcher = pattern.matcher(test);

		// System.out.println(matcher.group());

		String val = "T_SDMMYA_VAL"; // T_SDMMYA_COLL

		System.out.println(val.substring(2));

		// if (matcher.find()) {
		// System.out.println(matcher.group());
		// }

	}

	public static void main(String[] args) {

		// System.out.println(new DecimalFormat("#,##0.##",
		// DecimalFormatSymbols.getInstance(Locale.US).setDecimalSeparator('.')).format(new
		// BigDecimal("1567.99")));

		System.out.println(new DecimalFormat().format(new BigDecimal("1567.99")));

		System.out.println(NumberFormat.getNumberInstance(Locale.GERMAN).format(new BigDecimal("35567.99")));

		Path testPath = Paths.get("C:/MARS/mars_reports/reports/2017/05/29");

		long start = System.currentTimeMillis();
		// deleteDirectoryRecursively(testPath);

		// try {
		// V2(testPath);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		System.out.println(System.currentTimeMillis() - start);

	}
}
