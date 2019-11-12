package recursion;

public class ReverseString {

	static void reverse(char[] str, int low, int high) {
		if (high <= low)
			return;
		char temp = str[low];
		str[low] = str[high];
		str[high] = temp;
		low++;
		high--;
		reverse(str, low, high);
	}

	public static void main(String[] args) {
		char[] str = "shubham".toCharArray();
		System.out.println(str);
		reverse(str, 0, str.length - 1);
		System.out.println(str);

	}

}
