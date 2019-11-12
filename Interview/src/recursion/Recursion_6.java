package recursion;

public class Recursion_6 {
	static class shubham {
		int n = 0;
		boolean flag;
		int x;

		shubham(int x) {
			this.x = x;
		}
	}

	static void print(int k, shubham s) {
		System.out.print(k + "  ");
		if (s.n > 0 && k == s.x) {
			return;
		}
		s.n++;
		if (k > 0 && s.flag == false) {
			k = k - 5;
			if (k <= 0) {
				s.flag = true;
			}
		} else
			k = k + 5;

		if (k > 0)
			print(k, s);
		else
			print(k, s);
	}

	public static void main(String[] args) {
		print(20, new shubham(20));
	}
}
