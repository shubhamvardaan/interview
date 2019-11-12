package miscelleneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderBoardClimbing {
	static class pair {
		int rank;
		int score;

		pair(int rank, int score) {
			this.rank = rank;
			this.score = score;
		}
	}

	static void reverse(int[] arr) {
		int len = arr.length;
		int i = 0;
		int j = len - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int scoreLen = scores.length;
		int aliceLen = alice.length;
		if (scores[0] < scores[scoreLen - 1])
			reverse(scores);
		if (alice[0] > alice[aliceLen - 1])
			reverse(alice);
		List<pair> indexes = new ArrayList<>();
		indexes.add(new pair(1, scores[0]));
		for (int i = 1; i < scoreLen; i++) {
			if (scores[i - 1] == scores[i])
				indexes.add(new pair(indexes.get(i - 1).rank, scores[i]));
			else
				indexes.add(new pair(indexes.get(i - 1).rank + 1, scores[i]));
		}
		int result[] = new int[aliceLen];
		for (int j = 0; j < aliceLen; j++) {
			for (int i = scoreLen - 1; i >= 0; i--) {
				if (alice[j] < indexes.get(i).score) {
					result[j] = indexes.get(i).rank + 1;
					break;
				}
				if (alice[j] == indexes.get(i).score) {
					result[j] = indexes.get(i).rank;
					break;
				}
			}
		}
		if (result[aliceLen - 1] == 0)
			result[aliceLen - 1] = 1;

		return result;
	}

	static void printArr(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		int[] scores = { 5, 5, 6, 14, 19, 20, 23, 25, 29, 29, 30, 30, 32, 37, 38, 38, 38, 41, 41, 44, 45, 45, 47, 59,
				59, 62, 63, 65, 67, 69, 70, 72, 72, 76, 79, 82, 83, 90, 91, 92, 93, 98, 98, 100, 100, 102, 103, 105,
				106, 107, 109, 112, 115, 118, 118, 121, 122, 122, 123, 125, 125, 125, 127, 128, 131, 131, 133, 134, 139,
				140, 141, 143, 144, 144, 144, 144, 147, 150, 152, 155, 156, 160, 164, 164, 165, 165, 166, 168, 169, 170,
				171, 172, 173, 174, 174, 180, 184, 187, 187, 188, 194, 197, 197, 197, 198, 201, 202, 202, 207, 208, 211,
				212, 212, 214, 217, 219, 219, 220, 220, 223, 225, 227, 228, 229, 229, 233, 235, 235, 236, 242, 242, 245,
				246, 252, 253, 253, 257, 257, 260, 261, 266, 266, 268, 269, 271, 271, 275, 276, 281, 282, 283, 284, 285,
				287, 289, 289, 295, 296, 298, 300, 300, 301, 304, 306, 308, 309, 310, 316, 318, 318, 324, 326, 329, 329,
				329, 330, 330, 332, 337, 337, 341, 341, 349, 351, 351, 354, 356, 357, 366, 369, 377, 379, 380, 382, 391,
				391, 394, 396, 396, 400 };
		int[] alice = { 295, 294, 291, 287, 287, 285, 285, 284, 283, 279, 277, 274, 274, 271, 270, 268, 268, 268, 264,
				260, 259, 258, 257, 255, 252, 250, 244, 241, 240, 237, 236, 236, 231, 227, 227, 227, 226, 225, 224, 223,
				216, 212, 200, 197, 196, 194, 193, 189, 188, 187, 183, 182, 178, 177, 173, 171, 169, 165, 143, 140, 137,
				135, 133, 130, 130, 130, 128, 127, 122, 120, 116, 114, 113, 109, 106, 103, 99, 92, 85, 81, 69, 68, 63,
				63, 63, 61, 57, 51, 47, 46, 38, 30, 28, 25, 22, 15, 14, 12, 6, 4295, 294, 291, 287, 287, 285, 285, 284,
				283, 279, 277, 274, 274, 271, 270, 268, 268, 268, 264, 260, 259, 258, 257, 255, 252, 250, 244, 241, 240,
				237, 236, 236, 231, 227, 227, 227, 226, 225, 224, 223, 216, 212, 200, 197, 196, 194, 193, 189, 188, 187,
				183, 182, 178, 177, 173, 171, 169, 165, 143, 140, 137, 135, 133, 130, 130, 130, 128, 127, 122, 120, 116,
				114, 113, 109, 106, 103, 99, 92, 85, 81, 69, 68, 63, 63, 63, 61, 57, 51, 47, 46, 38, 30, 28, 25, 22, 15,
				14, 12, 6, 4 };
		printArr(climbingLeaderboard(scores, alice));
	}

}
