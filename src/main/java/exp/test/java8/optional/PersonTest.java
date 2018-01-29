package exp.test.java8.optional;

public class PersonTest {

	public static void main(String[] args) {

		Person person = new Person();

		System.out.println(person.getAge().orElse(-1));
		System.out.println(person.getName().orElse("Unknow"));

		Person otherPerson = new Person("Ejko", 236);

		System.out.println(otherPerson.getAge().orElse(-1));
		System.out.println(otherPerson.getName().orElse("Unknow"));

	}
}
