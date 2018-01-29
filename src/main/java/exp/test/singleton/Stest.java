package exp.test.singleton;

public class Stest {
	public static void main(String[] args) {

		// System.out.println(Singleton.getInstance().getInfo() + " DU");

		Singleton.getInstance().getProperties();

		System.out.println("\n===================================\n");

		Singleton.getInstance().getProperties();

	}
}
