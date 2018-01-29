package exp.test.enumtest;

import java.util.Map;
import java.util.TreeMap;

public enum Global implements ITest {
	;

	private static Map<String, ITest> map = new TreeMap<>();

	private String global;

	private Global(String global) {
		this.global = global;
	}

	// static {
	// for (Global iTest : values()) {
	// map.put(iTest.getString(), iTest);
	// }
	// }

	@Override
	public String getString() {
		return global;
	}
}
