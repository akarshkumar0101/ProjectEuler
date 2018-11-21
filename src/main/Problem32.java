package main;

import java.util.ArrayList;
import java.util.List;

public class Problem32 {

	public static void main(String[] args) {
		long ans = 0;
		List<Integer> nums = new ArrayList<Integer>();
		for (int a = 0; a < 10000000; a++) {
			if (!isProper(a))
				continue;
			int lena = (a + "").length();
			double minb = 4 - lena, maxb = 5 - lena;
			for (int b = (int) (Math.pow(10, minb) - 1); b <= Math.pow(10, maxb) - 1; b++) {

				int pro = a * b;
				if (isPandigital(a, b, pro) && !nums.contains(pro)) {
					System.out.println(a + " " + b + " " + pro);
					ans += pro;
					nums.add(pro);
				}
			}
		}
		System.out.println(ans);
	}

	public static boolean isProper(int a) {
		String str = a + "";
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.indexOf(str.charAt(i)) != i)
				return false;
		}

		return true;
	}

	public static boolean isPandigital(int a, int b, int c) {
		String str = a + "" + b + "" + c;
		if (str.length() != 9)
			return false;
		for (int i = 1; i <= 9; i++) {
			char cc = (char) (i + '0');
			if (!str.contains(cc + "")) {
				return false;
			}
		}
		return true;
	}

}
