package miscelleneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AshtonandString {

	static String intToBinary(long number) {
		String str = "";
		while (number > 0) {
			str = str + number % 2;
			number = number / 2;
		}
		return new StringBuffer(str).reverse().toString();
	}

	static char ashtonString(String s, int k) {
		List<String> result = new ArrayList<>();
		int length = s.length();
		double number = Math.pow(2, length);
		String s1 = null;
		for(int i=0;i<number;i++) {
			s1=intToBinary(i);
		}

		//Collections.sort(result, (s1, s2) -> s1.compareTo(s2));
		String s12 = "";
		for (String s2 : result)
			s1 = s1 + s2;
		return s1.charAt(k - 1);

	}

	public static void main(String[] args) {
		System.out.println(ashtonString(
				"zsbhetzecbhhepbqrrxwoipsrnqfaplbjmiqgkwklesrvvhmpeidnzxgopnphyqqnbitlfdwlxpgtxtibblqdlyramihkzazcisppynaxchqzcadfotizuazgihsjhsnrmchmphksqcruduatqkskktsvcmgjeudtwkfmtrgmuxgzugsmrmwdfqyichtjbwexijlcdtoxtuyndqzwcxbhnarrhlckjgjssvuvokuhgswjixhmujvjlnduafejmnbgkxbzhviophzzehlbsgkdvpxxvdhjqkpdiscrpmhethdaqqbkynnudmrapalhlckvuooldwryfuyxmzhknugsiaszafinhtkdjzqoxhncdlzpngbaciumimlkttyaokfylvoicbmhpnwctxcxhyjpmwafqahemmeyjtinwvulisneprdxppoblqgdsnkfbodmjlziittrlhxdaacqpstdjcgbrqgthlfqzhyhcuaodztdaxvrppuarbcitkdawltxstewnhmqgfwieraugwuzzyktjnthaoeuikrxtdoclkkpdmlklilkivdtlzanpgixtbvmglqrxbjapwmaeylpvqiirlwhrggmhbzpophlssoioakvavkyoughfcozkvlrymhpeqawkqgatrvvohteecmjeairxuiygrnkjpjvgpwzitwzbqdfspqyszprvapbteofuxacowdzqzytpbajtqilpzckzuovycasbaupzzopzmiqqiajakwqjyclsqiruilvkiljhbagqkzguzrvlnlunphggpzazkykujvcmwkcgjkbkdwvsjsgyzogrnjqzhauswweuijcsvdczbarksxlrlriaabahbubzsgvaryumbzlfzfprcckquvqwwqgzmhzepuhgubtwagbzlssovfgrawnwptxddykstrzpsslvyowkjpaguizwgmuvirbnqlflceawyorzeolnflvbvuxbjtztkagcllnpsqlqgfrkvcaapvdksambvlwfnckypzphpca",
				476910));
	}
}
