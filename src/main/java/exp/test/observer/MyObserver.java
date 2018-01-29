package exp.test.observer;

public class MyObserver extends Observer {
	private double rate = 1000;

	public MyObserver(Gold gold) {
		this.gold = gold;
		this.gold.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Euro amount: " + gold.getOunce() * rate);
	}
}
