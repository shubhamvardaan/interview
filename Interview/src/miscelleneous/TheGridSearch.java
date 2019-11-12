package miscelleneous;

public class TheGridSearch {
	static String gridSearch(String[] G, String[] P) {
		int gLen = G.length;
		int pLen = P.length;
		int index = -1;
		int j = 0;
		for (int i = 0; i < gLen - pLen; i++) {
			for (j = 0; j < pLen; j++) {
				if (G[i+j].contains(P[j]) && (index == -1 || index == G[i+j].indexOf(P[j]))) {
					index = G[i].indexOf(P[j]);
				} 
			}
			if (j == pLen)
				break;
		}
		if (j == pLen)
			return "YES";
		return "NO";
	}

	public static void main(String[] args) {
		String[] G = { "7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293",
				"7053106601", "0834282956", "4607924137" };
		String[] P = { "9505", "3845", "3530" };
		System.out.println(gridSearch(G, P));
	}
}
