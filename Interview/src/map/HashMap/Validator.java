package map.HashMap;

public class Validator {
	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyMap<>();
		map.put(12, "shubham");
		map.put(9, "vardaan");
		map.put(12, "ankur");
		for (int i = 0; i < 100; i++) {
			map.put(i, "" + i);
		}
		System.out.println(map.get(12));
		System.out.println(map.size());
	}
}
