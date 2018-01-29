package exp.test.java8.functionalinterface;

public class ImplFirst implements FirstInterface, SecondInterface {

	@Override
	public void firstWork() {
		System.out.println("First work");
	}

	@Override
	public void secondWwork() {
		System.out.println("Second work");
	}

	public static void main(String[] args) {
		ImplFirst implFirst = new ImplFirst();

		implFirst.firstWork();
		implFirst.doThis();
		implFirst.doOther();
		implFirst.secondWwork();
		implFirst.doAnother();
	}

}
