package miscelleneous;

import java.util.HashMap;

public class TimeInWord {
	static String getNumberInWord(int minute) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "ninteen");
		map.put(20, "twenty");
		map.put(21, "twenty one");
		map.put(22, "twenty two");
		map.put(23, "twenty three");
		map.put(24, "twenty four");
		map.put(25, "twenty five");
		map.put(26, "twenty six");
		map.put(27, "twenty seven");
		map.put(28, "twenty eight");
		map.put(29, "fourteen");

		return map.get(minute);
	}

	static void printTimeInWord(int hour, int minute) {
		if (String.valueOf(minute).equals("00"))
			System.out.println(getNumberInWord(hour) + " o' clock");
		String number = String.valueOf(minute);
		char ch = number.charAt(0);

		if (minute < 30) {
			if (ch == '0')
				System.out.println(getNumberInWord(number.charAt(1) - 'a') + " minute past" + getNumberInWord(hour));
			else if (minute == 15)
				System.out.println("quarter past" + getNumberInWord(hour));
			else
				System.out.println(getNumberInWord(minute) + " minute past " + getNumberInWord(hour));
		} else if (minute == 30)
			System.out.println("half past" + getNumberInWord(hour));
		else {
			if (minute == 15)
				System.out.println("quarter to " + getNumberInWord(hour));
			else
				System.out.println(getNumberInWord(minute - 30) + " minutes to " + getNumberInWord(hour)+1);
		}
	}

	public static void main(String[] args) {
		printTimeInWord(7, 02);
	}
}
