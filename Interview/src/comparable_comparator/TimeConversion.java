package comparable_comparator;

public class TimeConversion {

	static String convertTime(String time) {
		int number = Integer.parseInt(time.substring(0, 2));
		if (time.contains("P")) {
			if (number != 12)
				number = number + 12;
			return number + time.substring(2, time.length() - 2);
		} else {
			if (number == 12)
				return "00" + time.substring(2, time.length() - 2);
			return time.substring(0, time.length() - 2);
		}

	}

	public static void main(String[] args) {
		String time = "12:45:54PM";
		System.out.println(convertTime(time));
	}

}
