package miscelleneous;

import java.util.Arrays;

public class ReverseWordInSentence {

	static void reverse(char[] s, int start, int end) {

		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}

	static String reverseInSentence(String str) {
		str = "#" + str;
		int start = 0;
		int end = str.length() - 1;
		int length = str.length();
		char[] s = str.toCharArray();
		reverse(s, start, end);
		int i = 0;
		start = 0;
		end = 0;
		while (i < str.length()) {
			if (s[i] != ' ' || s[i] == '#')
				end++;
			if (s[i] == ' ' || i == length - 1) {
				if (i == length - 1)
					end = end - 2;
				else
					end--;
				reverse(s, start, end);
				start = i + 1;
				end = i + 1;
			}
			i++;
		}
		return String.valueOf(s).substring(0,String.valueOf(s).length()-1 );
	}

	public static void main(String[] args) {
		String str = "this is shubham vardaan";
		reverseInSentence(str);
		System.out.println(reverseInSentence(str));

	}

}
