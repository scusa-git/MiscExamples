package exp.ebcdic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import java.nio.charset.CharacterCodingException;

import java.nio.charset.Charset;

import java.nio.charset.CharsetDecoder;

import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ConvertBetweenCharacterSetEncodingsWithCharBuffer {


	public static void readStringFromFile() throws IOException {
		// C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_20171004.txt
		Path origin = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_20171004.txt");

		// Files.readAllLines(origin);

		ArrayList<String> lines = new ArrayList<>(Files.readAllLines(origin, Charset.forName("CP273")));
		// lines.get(0);
		// System.out.println(lines.get(0));

		Path output = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_KLAR_TEXT.txt");
		Files.write(output, lines.get(0).getBytes(), StandardOpenOption.CREATE);

		// ConvertAndWriteToFile(lines.get(0), "CP273", "ISO-8859-1");
		// System.out.println(Convert(lines.get(0), "CP273", "UTF-8"));
	}

	private static List<String> stringToLines(String line, int delta) {

		int von = 0;
		int offset = delta;
		int plus = delta;

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
	
	public static void readFromFileLines() throws IOException {
		
		Path origin = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_20171006.txt");

		ArrayList<String> lines = new ArrayList<>(Files.readAllLines(origin, Charset.forName("CP273")));
		
		
		System.out.println(lines.size());
		StringJoiner joiner = new StringJoiner("");
		for (String line : lines) {
			joiner.add(line);
		}

		List<String> decoded = stringToLines(joiner.toString(), 798);

		// Path output =
		// Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_KLAR_TEXT_01.txt");
		Path output = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_KLAR_TEXT_01.txt");
//		 Files.write(output, joiner.toString().getBytes(), StandardOpenOption.CREATE);

		Files.write(output, decoded, Charset.forName("UTF-8"), StandardOpenOption.CREATE);

		// ConvertAndWriteToFile(lines.get(0), "CP273", "ISO-8859-1");
		// System.out.println(Convert(lines.get(0), "CP273", "UTF-8"));
	}

	public static void readFromFile() throws IOException {
		// C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_20171004.txt
		// Path origin =
		// Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_20171004.txt");
		// SDMMYA_OLD.txt
		Path origin = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_20171006.txt");

		ArrayList<String> lines = new ArrayList<>(Files.readAllLines(origin, Charset.forName("CP273")));
		// System.out.println(lines.get(0));
		
		System.out.println(lines.size());

		List<String> decoded = stringToLines(lines.get(0), 4500);

		// Path output =
		// Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_KLAR_TEXT_01.txt");
		Path output = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/THPJ_KLAR_TEXT_01.txt");
		// Files.write(output, joiner.toString().getBytes(),
		// StandardOpenOption.CREATE);

		Files.write(output, decoded, Charset.forName("UTF-8"), StandardOpenOption.CREATE);

		// ConvertAndWriteToFile(lines.get(0), "CP273", "ISO-8859-1");
		// System.out.println(Convert(lines.get(0), "CP273", "UTF-8"));
	}

	public static void main(String[] args) throws IOException {

//		readFromFile();
		readFromFileLines();
		// reader();

		// String cadena = "òðñ÷ðññð ðððð";
		// System.out.println(Convert(cadena, "CP1047", "ISO-8859-1"));
		// System.out.println(Convert(cadena, "CP273", "ISO-8859-1"));
		// cadena = "1SWCHD363";
		// System.out.println(Convert(cadena, "ISO-8859-1", "CP1047"));
		// System.out.println(Convert(cadena, "ISO-8859-1", "CP273"));

	}

	public static void ConvertAndWriteToFile(String strToConvert, String in, String out) throws IOException {

		Path output = Paths.get("C:/hermann/JASPERREPORTS_ALL/EMIR_TEST/SDMMYA_KLAR_TEXT.txt");

		try {

			Charset charset_in = Charset.forName(out);
			Charset charset_out = Charset.forName(in);

			CharsetDecoder decoder = charset_out.newDecoder();

			CharsetEncoder encoder = charset_in.newEncoder();

			CharBuffer uCharBuffer = CharBuffer.wrap(strToConvert);

			ByteBuffer bbuf = encoder.encode(uCharBuffer);

			CharBuffer cbuf = decoder.decode(bbuf);

			Files.write(output, cbuf.toString().getBytes(), StandardOpenOption.CREATE);

		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
	}

	public static String Convert(String strToConvert, String in, String out) {
		try {

			Charset charset_in = Charset.forName(out);
			Charset charset_out = Charset.forName(in);

			CharsetDecoder decoder = charset_out.newDecoder();

			CharsetEncoder encoder = charset_in.newEncoder();

			CharBuffer uCharBuffer = CharBuffer.wrap(strToConvert);

			ByteBuffer bbuf = encoder.encode(uCharBuffer);

			CharBuffer cbuf = decoder.decode(bbuf);

			String s = cbuf.toString();

			// System.out.println("Original String is: " + s);
			return s;

		} catch (CharacterCodingException e) {
			e.printStackTrace();
			// System.out.println("Character Coding Error: " + e.getMessage());
			return "";

		}
	}
}
