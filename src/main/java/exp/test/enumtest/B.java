package exp.test.enumtest;

import java.util.Arrays;
import java.util.List;

public enum B implements ITest {
	B1("B1");

	private String b;

	private B(String b) {
		this.b = b;
	}

	@Override
	public String getString() {
		return b;
	}

	public static List<ITest> valuesAsList() {
		return Arrays.<ITest> asList(values());
	}
}
