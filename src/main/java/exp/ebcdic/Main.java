package exp.ebcdic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
	
	public static List<String> stringToLines(String line) {

		int von = 0;
		int offset = 4500;
		int plus = 4500;

		int size = line.length();

		int linesCount = size / offset;

		List<String> decoded = new ArrayList<>(linesCount);

		StringJoiner joiner = new StringJoiner("\n");
		System.out.println("LINES: " + linesCount);
		for (int i = 0; i < linesCount; i++) {
			// joiner.add(klarString.substring(von, offset));
			decoded.add(line.substring(von, offset));
			von += plus;
			offset += plus;
		}

		return decoded;
	}
	
	public static void main(String[] args) throws IOException {
		
		File input = new File("C:/hermann/MARS_REP_BUGS/TIMYA_20171204_084532.txt");
//		File temp = new File("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_KLAR_TEXT_TEMP.txt");
		File output = new File("C:/hermann/MARS_REP_BUGS/TIMYA_20171204_084532.klar.txt");
		
		Charset cp273 = Charset.forName("CP273");
		Charset utf8 = Charset.forName("UTF-8");
		
		FileConverter converter = new FileConverter(cp273, utf8);
		
		converter.convert(input, output);
		
//		Path origin = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_KLAR_TEXT_TEMP.txt");
//
//		ArrayList<String> lines = new ArrayList<>(Files.readAllLines(origin, Charset.forName("UTF-8")));
//
//		List<String> decoded = stringToLines(lines.get(0));
//
//		Path output = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_KLAR_TEXT_05.txt");
//
//		Files.write(output, decoded, Charset.forName("UTF-8"), StandardOpenOption.CREATE);
	}

}
