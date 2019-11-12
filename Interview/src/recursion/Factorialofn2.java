package recursion;

class shubham {
	int number = 0;
	long fact = 1;
}

public class Factorialofn2 {

	static shubham s = new shubham();

	static long getFactofn2(int n) {
		if (n == 0 || n == 1)
			return 1;
		s.number = n * n;
		for (int i = s.number; i > (n - 1) * (n - 1); i--) 
			s.fact = s.fact * i;

		return s.fact * getFactofn2(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFactofn2(3);
		System.out.println(s.fact);
	}

}
