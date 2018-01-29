package exp.test;

import java.util.Arrays;

public class LargeString {
	public static void main(String... args) {
		// char[] largeText = new char[10 * 1000 * 1000];

		char[] largeText = new char[100];

		Arrays.fill(largeText, 'A');
		String superString = new String(largeText);

		long bytes = Memory.threadAllocatedBytes();
		// String[] subStrings = new String[largeText.length / 1000];

		String[] subStrings = new String[largeText.length];
		String tmp = null;

		for (int i = 0; i < subStrings.length; i++) {
			// subStrings[i] = superString.substring(i * 1000, i * 1000 + 1000);
			tmp = superString.substring(i, i + 1);
			System.out.println(i + "=" + tmp);
			subStrings[i] = tmp;

		}
		bytes = Memory.threadAllocatedBytes() - bytes;
		System.out.printf("%,d%n", bytes);
	}

}
