package shubham1;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryNumber {
	static void generate(char[] shubham, int k, int index, List<String> results) {
		if (index == k) {
			results.add(String.valueOf(shubham));
			return;
		}
		shubham[index] = '0';
		generate(shubham, k, index + 1, results);
		shubham[index] = '1';
		generate(shubham, k, index + 1, results);
	}

	static void print(List<String> results) {
		for (String s : results) {
			System.out.println(s);
		}
	}

	static List<String> generate(int k) {
		char[] shubham = new char[k];
		int index = 0;
		List<String> results = new ArrayList<>();
		generate(shubham, k, index, results);
		return results;
	}

	public static void main(String[] args) {
		print(generate(4));
	}
}
