package exp.test.java8;

import java.util.Objects;
import java.util.stream.Stream;

public class EqAndH {

	private Integer id;
	private String name;

	public EqAndH() {
		// TODO Auto-generated constructor stub
	}

	public EqAndH(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof EqAndH) {
			EqAndH x = (EqAndH) other;
			return Objects.equals(this.id, x.id) && Objects.equals(x.name, this.name);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	public static void main(String[] args) {

		String cb = "Herr";
		System.out.println(cb.contains("er"));

		Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();

		Integer.valueOf("1");

		EqAndH aaa = new EqAndH(23, "AAA");
		System.out.println("hash of aaa:" + aaa.hashCode());
		EqAndH a_copy = aaa;
		System.out.println("hash of a_copy:" + a_copy.hashCode());

		EqAndH a_kl = new EqAndH(23, "AAA");
		System.out.println("hash of a_kl:" + a_kl.hashCode());

		EqAndH bbb = new EqAndH(23, "bbb");
		System.out.println("hash of bbb:" + bbb.hashCode());

		System.out.println("gleich:" + aaa.equals(a_copy));
		System.out.println("gleich:" + aaa.equals(a_kl));
		System.out.println("gleich:" + aaa.equals(bbb));

		String sd = "asd";
		System.out.println("gleich:" + aaa.equals(sd));

	}
}
