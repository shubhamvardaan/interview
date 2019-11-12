package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;;

class Trader {
	private final String name;

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	private final String city;

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
}

class Transaction {
	private final Trader trader;

	public Trader getTrader() {
		return trader;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getValue() {
		return value;
	}

	private final Integer year;
	private final Integer value;

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

	public Transaction(Trader trader, Integer year, Integer value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
}

public class TestStream {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge ");
		Trader mario = new Trader("Mario", "Milan ");
		Trader alan = new Trader("Alan", "Cambridge ");
		Trader brian = new Trader("Brian", "Cambridge ");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		// Stream<Transaction> t = transactions.stream().filter(a -> a.getYear() ==
		// 2011)
		// .sorted((a, b) -> a.getYear().compareTo(b.getYear()));
		// t.forEach(a -> System.out.println(a.toString())); // answer for 1
		// transactions.stream().map(a ->
		// a.getTrader().getCity()).distinct().collect(Collectors.toList()).stream()
		// .forEach(System.out::print); // answer for 2

		// transactions.stream().filter(a -> a.getTrader().getCity().equals("Cambridge
		// "))
		// .sorted((s1, s2) ->
		// s1.getTrader().getName().compareTo(s2.getTrader().getName()))
		// .collect(Collectors.toList()).stream().forEach(System.out::print); // answer
		// for 3

		// Stream<String> strings = transactions.stream().map(a ->
		// a.getTrader().getName()).distinct()
		// .sorted((s1, s2) -> s1.compareTo(s2));
		// strings.forEach(System.out::println); // answer for 4

		// if (transactions.stream().anyMatch(a -> a.getTrader().getCity().equals("Milan
		// ")))
		// System.out.println("true"); // answer 5

		// transactions.stream().filter(a -> a.getTrader().getCity().equals("Cambridge
		// "))
		// .forEach(a -> System.out.println(a)); // answer for 6

		System.out.println(transactions.stream().map(a -> a.getValue()).reduce(Integer::max).get());
		System.out.println(transactions.stream().map(a -> a.getValue()).reduce(Integer::min).get());

	}

}
