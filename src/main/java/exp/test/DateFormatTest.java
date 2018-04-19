package exp.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
	
	public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
	public static void fromToFormat(String verdat) {
		
		Locale locale = Locale.US;
		
		DateFormat df = new SimpleDateFormat("dd.MMM.yyyy", locale);
		System.out.println("verdat: " + verdat);
		Date verdatDate = null;
		try {
			verdatDate = df.parse(verdat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		df = new SimpleDateFormat("yyyyMMdd");
		String verdatString = df.format(verdatDate);
		
		System.out.println("new verdatString: "+ verdatString);
	}
	
	public static void today() {
		System.out.println("TODAY:"+(YYYYMMDD.format(new Date())));
	}
	
	public static String originFormat() {
		Locale locale = Locale.US;
		DateFormat df = new SimpleDateFormat("dd.MMM.yyyy", locale);
		return df.format(new Date());
	}

	public static void main(String[] args) {
		
		String oD = originFormat();
		System.out.println("oD: "+oD);
		
		fromToFormat(oD);
		
		today();
	}

}
