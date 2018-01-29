package exp.test.pair;

public class Main {

	public static void main(String[] args) {

		Pair<String, Boolean> p1 = new Pair<>("aaa", true);
		Pair<String, Boolean> p2 = new Pair<>("bbb", false);
		Pair<String, Boolean> p3 = new Pair<>("aaa", false);
		Pair<String, Boolean> p4 = new Pair<>("aaa", true);

		System.out.println("p1 == p2" + p1.equals(p2));
		System.out.println("p2 == p3" + p2.equals(p3));
		System.out.println("p1 == p3" + p1.equals(p3));
		System.out.println("p1 == p4" + p1.equals(p4));

	}
}
