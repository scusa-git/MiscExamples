package exp.test.bla;

public class TestBla {

	public static void main(String[] args) {

		int tz = 9;
		for (int i = 0; i < 9; i++) {

			try {

				if (tz == i) {
					System.out.println("OK");
				} else {
					System.out.println("UPS");
					throw new RuntimeException("No valid Verdat found in file ");
				}

			} catch (Exception e) {

				System.out.println("FEHLER");
				e.printStackTrace();
			}

		}
	}

}
