package exp.test.observer;

import java.util.ArrayList;
import java.util.List;

public class Gold {
	private List<Observer> observers = new ArrayList<Observer>();
	private double ounce;

	public double getOunce() {
		return ounce;
	}

	public void setOunce(double amount) {
		this.ounce = amount;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
