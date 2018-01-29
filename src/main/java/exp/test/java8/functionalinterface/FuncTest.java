package exp.test.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncTest {

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		list.stream().filter(integer -> predicate.test(integer)).forEach(System.out::println);
	}

	public static void rest(List<Double> list, Function<Double, Integer> function) {
		list.stream().map(zahl -> function.apply(zahl)).forEach(System.out::println);
	}

	public static void main(String[] args) {

		double fg = 12.345D;
		int rest = (int) ((fg % 1) * 100);
		System.out.println(rest);

		Predicate<Integer> isGerade = integer -> (integer & 1) == 0;
		Predicate<Integer> isUnGerade = integer -> (integer & 1) == 1;
		Function<Double, Integer> restAsInt = zahl -> (int) ((zahl % 1) * 100);
		// Integer kl = 13;
		int kl = 12;

		System.out.println((12 & 1));

		if ((kl & 1) == 0) {
			System.out.println("Zahl ist gerade");
		} else {
			System.out.println("Zahl ist ungerade");
		}

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// eval(integers, isGerade);
		// eval(integers, isUnGerade);

		List<Double> klo = Arrays.asList(1.45, 2.89, 3.34, 4.12, 5.07, 6.98);

		rest(klo, restAsInt);
	}

}
