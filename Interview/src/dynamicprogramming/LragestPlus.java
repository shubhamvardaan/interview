package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LragestPlus {
	// static final int N = 6;

	static int checkTop(String[] grid, int x, int y, char colour) {
		int count = 0;
		while (x >= 0) {
			if (grid[x].charAt(y) == colour)
				count = count + 1;
			else
				break;
			x--;
		}
		return count;
	}

	static int checkBottom(String[] grid, int x, int y, char colour) {
		int count = 0;
		int N = grid.length;
		while (x < N) {
			if (grid[x].charAt(y) == colour)
				count = count + 1;
			else
				break;
			x++;
		}
		return count;
	}

	static int checkLeft(String[] grid, int x, int y, char colour) {
		int count = 0;
		while (y >= 0) {
			if (grid[x].charAt(y) == colour)
				count = count + 1;
			else
				break;
			y--;
		}
		return count;
	}

	static int checkRight(String[] grid, int x, int y, char colour) {
		int count = 0;
		int N = grid[0].length();
		while (y < N) {
			if (grid[x].charAt(y) == colour)
				count = count + 1;
			else
				break;
			y++;
		}
		return count;
	}

	static int largestPlusSign(String[] grid) {
		int result = 1;
		int currMax = 0;
		int M = grid.length;
		List<Integer> indexes = new ArrayList<>();
		int N = grid[0].length();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int t = checkTop(grid, i, j, grid[i].charAt(j));
				int b = checkBottom(grid, i, j, grid[i].charAt(j));
				int l = checkLeft(grid, i, j, grid[i].charAt(j));
				int r = checkRight(grid, i, j, grid[i].charAt(j));
				currMax = 4 * Integer.min(Integer.min(r, l), Integer.min(t, b)) - 3;
				if (indexes.contains(i) || indexes.contains(j))
					break;
				if (currMax > 1) {
					indexes.add(i);
					indexes.add(j);
				}

				if (currMax > 0)
					result *= currMax;
			}

		}
		return result;
	}

	public static void main(String args[]) {
		String[] grid = { "GGGGGGG", "BGBBBBG", "BGBBBBG", "GGGGGGG", "GGGGGGG", "BGBBBBG" };
		System.out.println(largestPlusSign(grid));
	}
}
