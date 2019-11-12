package arrayProblem;

import java.util.ArrayList;
import java.util.List;

public class StringPerm {

	static private void permutations(String prefix, String suffix, List<String> results) {
		if (suffix.length() == 0) {
			if (!results.contains(prefix))
				results.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permutations(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
			}
		}
	}

	static List<String> permutations(String s) {
		String prefix = "";
		String suffix = s;
		List<String> results = new ArrayList<>();
		permutations(prefix, suffix, results);
		return results;
	}

	public static void main(String[] args) {
		System.out.println(permutations("aaaab"));

	}

}
