package exp.test.java8.functionalinterface;

@FunctionalInterface
public interface FirstInterface {

	public void firstWork();

	default void doThis() {
		System.out.println("Do this");
	}

	default void doOther() {
		System.out.println("Do other");
	}
}
