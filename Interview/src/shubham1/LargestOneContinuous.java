package shubham1;

public class LargestOneContinuous {
	static int get(int number) {
		int len = 0;
		int maxLen = Integer.MIN_VALUE;
		boolean seen = false;
		int index = -1;
		for (int i = 0; i < 32; i++) {
			if ((number & 1) == 1) {
				len = len + 1;
			} else {
				if ((number & 2) == 2) {
					if (seen == true) {
						len = Math.abs(i - index);
					} else {
						len = len + 1;
						index = i;
						seen = true;
					}
				} else {
					len = 1;
				}
			}
			if (maxLen < len)
				maxLen = len;
			number = number >> 1;

		}
		return maxLen;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(get(1775));
	}

}
