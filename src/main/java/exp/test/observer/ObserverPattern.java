package exp.test.observer;

public class ObserverPattern {
	public static void main(String[] args) {
		Gold gold = new Gold();
		new MyObserver(gold);

		System.out.println("10 ounces of gold:");
		gold.setOunce(10);

		System.out.println("\n\ngold increased from 10 to 20 ounces:");
		gold.setOunce(20);
	}
}
