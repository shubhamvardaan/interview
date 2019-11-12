package recursion;

public class PowerSetRecur1 {

	static void printPowerSet(int[] shubham, int index, String temp) {
		int n = shubham.length;
		if (index == n) {
			System.out.println(temp);
			return;
		}
		printPowerSet(shubham, index + 1, temp);
		printPowerSet(shubham, index + 1, temp + shubham[index]);

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] shubham = { 1, 2, 3 };
		String temp = "";
		printPowerSet(shubham, 0, temp);

	}

}
