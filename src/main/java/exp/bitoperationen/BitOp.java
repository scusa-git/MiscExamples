package exp.bitoperationen;

public class BitOp {

	private static final int maske = 0b00000000000000000000000000000001;

	public static boolean andIstGerade(int toTest) {
		// return (toTest&1) == 1 ? false : true;
		return (toTest & maske) == 1 ? false : true;
	}

	public static void binaerDarstellenVonInt(String text, int zahl) {

		int maske = 0b00000000000000000000000000000001;
		char[] bitfolge = new char[32];

		for (int i = 0; i < 32; i++) {
			bitfolge[31 - i] = (zahl & maske) == 0 ? '0' : '1';
			maske = maske << 1;
		}

		System.out.print(text);
		System.out.println(bitfolge);
	}

	public static void main(String[] args) {

		binaerDarstellenVonInt("0 binär: ", 0);
		binaerDarstellenVonInt("1 binär: ", 1);
		binaerDarstellenVonInt("0&1 binär: ", 0 & 1);

		int gu = 132;

		binaerDarstellenVonInt("Binar:", gu);

		System.out.println("OR:" + (gu | 0));
		System.out.println("AND:" + (gu & 0));

		System.out.println("TEST with modulo 2 -- ist " + gu + " gerade:" + (gu % 2 == 0));

		System.out.println("Ist " + gu + " gerade:" + andIstGerade(gu));
		System.out.println();
	}

}
