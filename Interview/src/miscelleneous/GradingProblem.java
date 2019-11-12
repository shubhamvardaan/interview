package miscelleneous;

import java.util.ArrayList;
import java.util.List;

public class GradingProblem {

	static List<Integer> gradingStudents(List<Integer> grades) {
		List<Integer> shubham = new ArrayList<>();
		for (Integer grade : grades) {
			int num = ((grade / 5) + 1) * 5;
			if ((num - grade) < 3 && num >= 40) {

				shubham.add(num);
			} else
				shubham.add(grade);

		}
		return shubham;
	}

	public static void main(String[] args) {
		List<Integer> grades = new ArrayList<>();
		grades.add(84);
		grades.add(29);
		grades.add(38);
		grades.add(33);
		for (Integer grade : gradingStudents(grades)) {
			System.out.println(grade);
		}

	}

}
