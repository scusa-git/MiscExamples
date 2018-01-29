package exp.numberformat;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatTest {

	public static void numberFormatter(Double zahl) {

		Locale locale = Locale.UK;

		String pattern = "###,##0.0000 \u00A4\u00A4";
		NumberFormat numberFormat = NumberFormat.getInstance(locale);
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;

		decimalFormat.applyPattern(pattern);

		System.out.println(decimalFormat.format(zahl) + " -- " + locale.toString());
	}

	public static void numberFormatter(BigDecimal zahl, int scale) {

		Locale locale = Locale.GERMANY;

		String pattern = "###,##0.0000 \u00A4\u00A4";
		NumberFormat numberFormat = NumberFormat.getInstance(locale);
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;

		decimalFormat.applyPattern(pattern);

		System.out.println(decimalFormat.format(zahl) + " -- " + locale.toString());
	}

	public static void numberFormatterV2(BigDecimal zahl, int scale) {

		Locale locale = Locale.GERMANY;

		String pattern = "###,##0.0000 \u00A4\u00A4";
		// NumberFormat numberFormat = NumberFormat.getInstance(locale);
		DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
		decimalFormat.applyPattern("###,##0.00");

		System.out.println(decimalFormat.format(zahl) + " -- " + locale.toString());
	}

	public static void allCurrencys() {
		for (Currency currency : Currency.getAvailableCurrencies()) {
			System.out.printf("%s, %s, %s (%s)%n", currency.getCurrencyCode(), currency.getSymbol(), currency.getDisplayName(),
					currency.getDisplayName(Locale.ENGLISH));
		}
	}

	public static void main(String[] args) {

		Double zahl = 12400D;
		numberFormatter(zahl);
		System.out.println();

		BigDecimal zero = new BigDecimal(0D);
		BigDecimal nz = new BigDecimal(-1234.12666D);
		BigDecimal pz = new BigDecimal(1234D);

	}

}
