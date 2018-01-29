package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class BigDecimalTest {

	public static void main(String[] args) {

		// BigDecimal zahl = new BigDecimal(2512.72D);
		// BigDecimal rate = new BigDecimal(1.0504D);
		// System.out.println(zahl.divide(rate, 2, RoundingMode.HALF_DOWN));

		// BigDecimal zahl = new BigDecimal(2263.30D);
		// BigDecimal rate = new BigDecimal(1.0504D);
		// System.out.println(zahl.divide(rate, RoundingMode.HALF_DOWN));

		BigDecimal zahl = new BigDecimal(2222.00D);
		BigDecimal rate = new BigDecimal(1.0504D);
		System.out.println(zahl.divide(rate, 2, RoundingMode.HALF_DOWN));
		System.out.println(zahl.divide(rate, 2, RoundingMode.FLOOR));

		String datum = "12.02.2017";
		System.out.println(datum.substring(datum.indexOf(".") + 1, datum.indexOf(".") + 3));

		LocalDate localDate = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

		System.out.println(LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy")).format(DateTimeFormatter.ofPattern("MMMM", Locale.GERMANY)));

		// System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM",
		// Locale.GERMANY)));

		System.out.println(localDate.getMonth().toString());
		System.out.println(localDate.getYear());

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);

		System.out.println(new SimpleDateFormat("MMMM", Locale.GERMANY).format(new Date()));

		DecimalFormat decimalFormat = new DecimalFormat("###,##0.0000");
		System.out.println(decimalFormat.format(zahl));

		// Date.

	}

}
