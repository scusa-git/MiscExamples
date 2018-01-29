package exp.test.enumtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

	public static void print(List<ITest> list) {

		for (ITest a : list) {
			System.out.println(a.getString());

		}

	}

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("abc", "ABC");

		System.out.println(map.get(Purum.abc.toString()));

	}

}
