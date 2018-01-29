package exp.test.java8.functionalinterface;

@FunctionalInterface
public interface SecondInterface {

	public void secondWwork();

	default void doAnother() {
		System.out.println("Do Another");
	}
}
