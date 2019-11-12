package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Stream<Integer> shubham = list.stream();
		shubham.reduce(Integer::max).ifPresent(a -> System.out.println(a));
		// shubham.reduce((a, b) -> a + b).ifPresent(System.out::println);
		// System.out.println(shubham.noneMatch(i -> i < 6));
		// System.out.println(shubham.allMatch(a -> a < 6));

		// System.out.println(shubham.anyMatch(b -> b == 5));
		IntStream shubham1 = IntStream.range(1, 101).filter(i -> i % 2 == 0);
		System.out.println(shubham1.count());
	}
}
