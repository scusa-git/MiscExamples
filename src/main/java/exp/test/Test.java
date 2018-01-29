package exp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Test {

	public static void ready() {

		String[] nightlyDataFiles = new String[] { "THDX.txt", "SDDEY.txt", "SDEKT.txt" };

		int countOfTrue = 0;
		for (String nightlyDataFile : nightlyDataFiles) {
			countOfTrue += found() ? 1 : 0;
		}

		System.out.println(countOfTrue == nightlyDataFiles.length);

	}

	public static boolean found() {
		return false;
	}

	public enum DirectoryArt {
		adhoc, intraday, nightly;
	}

	public static String readLine(BufferedReader reader) throws IOException {
		return reader.readLine();
	}

	public static String copyControlFile(final String controlFileName) {
		Path pathSource = Paths.get("C:/MARS/ctl_files/origin", controlFileName);
		Path pathCopy = Paths.get("C:/MARS/ctl_files/copy", controlFileName);

		String copy;
		String decodedDataUsingUTF8;

		try {
			byte[] origin = Files.readAllBytes(pathSource);

			decodedDataUsingUTF8 = new String(origin, "UTF-8");

			System.out.println("################# ORIGIN #################");
			System.out.println(decodedDataUsingUTF8);
			System.out.println("################# ORIGIN #################");

			copy = decodedDataUsingUTF8.replace("$LOAD_ID", "1489761108298");

			System.out.println("################# COPY #################");
			System.out.println(copy);
			System.out.println("################# COPY #################");

			Files.write(pathCopy, copy.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// try (BufferedReader br = new BufferedReader(new
		// FileReader(pathSource.toFile()))) {
		//
		// while ((oneLine = br.readLine()) != null) {
		//
		// if (oneLine.contains("$LOAD_ID")) {
		// oneLine = oneLine.replace("$LOAD_ID", "1489761108221");
		// }
		//
		// Files.write(pathCopy, oneLine.getBytes(), StandardOpenOption.APPEND);
		//
		//
		// ctl.append(oneLine);
		// }
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }

		return pathCopy.toString();

	}

	public static void copyFileTo() {
		Path pathSource = Paths.get("C:/MARS/PIAU01.profitloss.pdf");

		Path fileName = pathSource.getFileName();
		System.out.println("fileName :" + fileName);

		Path parent = pathSource.getParent();

		System.out.println("parent :" + parent);

		String string = fileName.toString();

		int lastIndexOfPoint = fileName.toString().lastIndexOf('.');

		String extension = fileName.toString().substring(lastIndexOfPoint);
		System.out.println("extension :" + extension);

		String target = "_13.04.2017" + extension;

		String tzu = string.replace(extension, target);
		System.out.println("tzu :" + tzu);

		Path resolve = parent.resolve(tzu);
		System.out.println("resolve :" + resolve);

		// String decodedDataUsingUTF8;

		try {
			Files.copy(pathSource, resolve, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void hasFileFound(String fileName) {

		Path path = Paths.get("C:/MARS/utl_files", fileName);

		if (path.toFile().exists()) {
			System.out.println("File: " + fileName + " was found!!!");
		} else {
			System.out.println("File: " + fileName + " was NOT found!!!");
		}

	}

	public static void main(String[] args) throws IOException {

		ready();

		System.out.println(Long.MAX_VALUE);
		System.out.println(System.currentTimeMillis());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(System.nanoTime());

		// copyFileTo();
		hasFileFound("THPK9.txt");
		hasFileFound("THPK.txt");

		// int processors = Runtime.getRuntime().availableProcessors();
		// System.out.println("processors: " + processors);

		// copyControlFile("dupim_test.ctl");

		// String adhoc = Test.DirectoryArt.adhoc.toString();
		// System.out.println(Test.DirectoryArt.adhoc);
		// System.out.println(adhoc);

		// String pathS = "C:/MARS/mars_reports/reports/$date/$art";
		//
		// Path path = Paths.get(pathS, "888");
		// String dop = path.toString();
		//
		// dop = dop.replace("$art", Test.DirectoryArt.adhoc.toString());

		// System.out.println(dop);

		// String asd = "aa,bb,dd,cc,rr,zz";

		// List<String> bn = Arrays.asList(asd.split(","));
		// for (String string : bn) {
		// System.out.println(string);
		// }

		// List<String> bn_0 = Arrays.asList(asd_leer.split(","));
		// System.out.println("empty:" + (bn_0.isEmpty()));
		// for (String string : bn_0) {
		// System.out.println("????:"+string);
		// }

		// String plSQL = "AND RD.MANDANT = fv.pkmdnr AND RD.NIEDERLASSUNG =
		// fv.pkdndl AND
		// mandant_kunde(fv.pkdkto,FV.DEPOT_BEZEICHNUNG)=RD.DEPOTNUMMER AND
		// RD.REPORT_ID=$ID AND RD.$EMAIL_CSV=-1";
		//
		// String idReplacement= "$ID";
		// String emailCsvReplacement= "$EMAIL_CSV";
		//
		// System.out.println(plSQL.replace(idReplacement, "7"));

		// String zeile[] = new String[28];
		// Path path = Paths.get("C:/hermann/tmp/Leer.txt");
		// BufferedReader reader = Files.newBufferedReader(path,
		// Charset.defaultCharset());
		//
		// String line;
		// int count = 0;
		//
		// do {
		// line = reader.readLine();
		//
		// System.out.println(line);
		// zeile[count++] = line;
		// count++;
		//
		// } while (line != null && count < 13);
		//
		// reader.close();
		// System.out.println(count);
		//
		// System.out.println("===============================================");
		//
		// for (int i = 0; i < zeile.length; i++) {
		// System.out.println(zeile[i]);
		//
		// }
		//
		//
		//
		// System.out.println(count);

		// System.out.println(Locale.GERMAN.toString());

		// List<String> lines = new ArrayList<>(Files.readAllLines(path,
		// Charset.defaultCharset()));
		//
		// for (String string : lines) {
		// System.out.println(string);
		// }

		// Path pathO = Paths.get("C:/MARS/ctl_files", "aaaa.ctl");
		// Path pathL = Paths.get("C:/MARS/sql_loader_logs");
		//
		// System.out.println(pathO.resolve(pathL));
		// System.out.println(pathL.relativize(pathO));

		// String[] aaa = {"aaa", "bbb", "hhh"};
		//
		// for (int i = 0; i < aaa.length; i++) {
		// System.out.println(aaa[i]);
		// }

		// List<String> list = Arrays.asList("aaa", "bbb", "hhh", "eee", "zzz",
		// "888");
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }

		// 1489761108221
		// 1489761124143

		// for (int i=0; i <11; i++) {
		// System.out.println(System.currentTimeMillis());
		// }

		// Path zipFilePath = Paths.get("C:/MARS", "report.zip");
		//
		// URI zipUri = Paths.get("jar:", zipFilePath.toString()).toFile().toURI();
		// System.out.println("zipUri: " + zipUri.toString());
		//
		// String reportsAsZip = zipFilePath.toFile().toURI().toString();
		//
		// URI zipFile = URI.create("jar:".concat(reportsAsZip));
		// System.out.println("zipFile: " + zipFile.toString());

	}

}
