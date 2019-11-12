package shubham1;

public class CountNumberof2 {

	static int countNumberOf2s(int n) {
		int count = 0;
		for (int i = 2; n / i > 0; i = i * 2)
			count = count + n / i;

		return count;
	}

	public static void main(String[] args) {
		System.out.println(countNumberOf2s(10));

	}

}
