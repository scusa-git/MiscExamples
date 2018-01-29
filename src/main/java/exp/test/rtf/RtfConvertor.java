package exp.test.rtf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.util.regex.Pattern;

import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class RtfConvertor {

	private static Pattern htmlTrimPattern = Pattern.compile(".*<body>(.*)</body>.*", Pattern.DOTALL);

	public static void main(String[] args) {

//		toRtf("<!DOCTYPE html><html><body><h1>My First Heading</h1><br/><br/><p>My first paragraph.</p></body></html>");
		toRtf("My First Heading\n\nMy first paragraph.");

	}

	public static String toRtf(String html) {
		ByteArrayInputStream input = new ByteArrayInputStream(html.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			RTFEditorKit rtfEditorKit = new RTFEditorKit();

//			Document document = rtfEditorKit.createDefaultDocument();

			 HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
			 Document htmlDoc = htmlEditorKit.createDefaultDocument();
			 htmlEditorKit.read(input, htmlDoc, 0);
			 rtfEditorKit.write(baos, htmlDoc, 0, htmlDoc.getLength());

//			rtfEditorKit.read(input, document, 0);
//			rtfEditorKit.write(baos, document, 0, document.getLength());

		} catch (Exception ex) {
			System.out.println("Error" + ex);
		}
		System.out.println(baos.toString());
		return baos.toString();
	}

}
