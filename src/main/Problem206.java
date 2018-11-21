package main;

import java.math.BigInteger;

public class Problem206 {

	public static void main(String[] args) {

		long ans=-1;
		for (long l = 1000000000L; l < 4000000000L; l+=10) {
			if (l % 1000000 == 0)
				System.out.println(l);
			if(satisfiesProp(l)) {
				ans=l;
				break;
			}
		}

		System.out.println(ans);
	}

	public static boolean satisfiesProp(long a) {
		BigInteger num = new BigInteger(a + "").multiply(new BigInteger(a + ""));
		String str = num + "";
		int i = 0;
		for (char c : str.toCharArray()) {
			int dig = c - '0';
			if (i % 2 == 0) {
				int expected = ((i + 2) / 2) % 10;
				if (dig != expected) {
					return false;
				}
			}
			i++;
		}
		return true;
	}
}
