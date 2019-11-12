package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(-7);
		Stream<Integer> s = list.stream();
		
		Stream<Integer> s1 = s.filter(n -> (n % 2 == 1));
		//s1.forEach((n) -> System.out.println(n));

		Optional<Integer> maxValue = s1.max(Integer::compare);
		System.out.println(maxValue.get());

	}
}
