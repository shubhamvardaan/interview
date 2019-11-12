package miscelleneous;

import java.util.Arrays;
import java.util.Collections;

public class MaxChainlength {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair temp) {
			return this.x - temp.x;
		}
	}

	static int maxChainLength(Pair[] array) {
		Collections.sort(Arrays.asList(array));
		int length = array.length;
		int maxChainLen = Integer.MIN_VALUE;
		int currentLen = 0;
		for (int i = 1; i < length; i++) {
			currentLen =1;
			for (int j = 0; j <= i & j + 1 != length; j++) {
				if (array[j].y < array[j + 1].x)
					currentLen++;
			}
			if (maxChainLen < currentLen)
				maxChainLen = currentLen;

		}
		return maxChainLen;
	}

	public static void main(String[] args) {
		Pair[] array = { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
		System.out.println(maxChainLength(array));
	}

}
