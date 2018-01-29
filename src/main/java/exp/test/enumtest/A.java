package exp.test.enumtest;

import java.util.Arrays;
import java.util.List;

public enum A implements ITest {

	A1("BUHHHHHH");

	private String a;

	private A(String a) {
		this.a = a;
	}

	@Override
	public String getString() {
		return a;
	}

	public static List<ITest> valuesAsList() {
		return Arrays.<ITest> asList(values());
	}

}
