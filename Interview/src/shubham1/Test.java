package shubham1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class person {
	String name;
	int age;

	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}

public class Test {
	static void print(List<person> list) {
		for (person p : list) {
			System.out.println(p.name + " " + p.age);
		}
	}

	public static void main(String[] args) {
		List<person> list = new ArrayList<>();
		list.add(new person("shubham", 15));
		list.add(new person("kumar", 1));
		list.add(new person("vardaan", 5));
		list.add(new person("patna", 62));
		list.add(new person("ankur", 9));
		list.add(new person("pune", 27));
		Collections.sort(list, (p1, p2) -> ((String) p2.name).compareTo((String) p1.name));
		print(list);
	}
}
