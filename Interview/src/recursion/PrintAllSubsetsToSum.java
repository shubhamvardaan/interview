package recursion;

public class PrintAllSubsetsToSum {

	static void printNumberUtil(int number, int current, String str) {
		if (current == 0) {
			System.out.println(str);
			return;
		}
		for (int i = 1; i <= number; i++) {
			if (i <= current) {
				printNumberUtil(number, current - i, str + i);
			}
		}
	}

	static void printAllNumbers(int number) {
		String str = "";
		int current = number;
		printNumberUtil(number, current, str);
	}

	public static void main(String[] args) {
		printAllNumbers(10);

	}

}
