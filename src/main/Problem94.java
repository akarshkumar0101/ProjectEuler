package main;

import java.math.BigInteger;

public class Problem94 {

	public static void main(String[] args) {
		long limit = 1000000000 / 3 + 3;
		// limit = 10;
		long ans = 0;
		for (long a = 1; a <= limit; a+=2) {

			for (long b = a - 1; b <= a + 1; b += 2) {
				if (a + a + b <= 1000000000 && a != 0 && b != 0) {
//					BigInteger areaSqr = Problem94.getAreaSquared(a, a, b);
//					if (areaSqr != null && Problem94.isPerfectSquare(areaSqr)) {
//						ans += a + a + b;
//					}
					if(isAreaInt(a, b)){
						ans+=a+a+b;
					}
				}
			}
			if (a % 1000001 == 0) {
				System.out.println(a);
			}
		}
		System.out.println(ans);
	}

	//sides: a a b
	public static boolean isAreaInt(long a, long b){
		// b/2 will be a .5 decimal if b is odd
		if(b%2==1){
			return false;
		}
		long hbsqr = a*a-(b/2)*(b/2);
		BigInteger hbsqrBig = new BigInteger(String.valueOf(hbsqr));

		BigInteger hb = hbsqrBig.sqrt();
		if(hb.multiply(hb).equals(hbsqrBig)){
			return true;
		}

		return false;
	}

	public static BigInteger getAreaSquared(int a, int b, int c) {
		int p = a + b + c;
		BigInteger area = BigInteger.valueOf(p).multiply(BigInteger.valueOf(p - 2 * a))
				.multiply(BigInteger.valueOf(p - 2 * b)).multiply(BigInteger.valueOf(p - 2 * c));
		BigInteger mod = area.mod(BigInteger.valueOf(16));
		if (mod.signum() != 0)
			return null;
		else
			return area.divide(BigInteger.valueOf(16));
	}

	public static boolean isPerfectSquare(BigInteger big) {
		BigInteger i = BigInteger.ZERO;
		if (big.compareTo(BigInteger.valueOf(100)) > 0) {
			i = BigInteger.TEN;
		}
		if (big.compareTo(BigInteger.valueOf(10000)) > 0) {
			i = BigInteger.valueOf(100);
		}
		if (big.compareTo(BigInteger.valueOf(1000000)) > 0) {
			i = BigInteger.valueOf(1000);
		}
		if (big.compareTo(BigInteger.valueOf(100000000)) > 0) {
			i = BigInteger.valueOf(10000);
		}

		for (;; i = i.add(BigInteger.ONE)) {
			BigInteger mul = i.multiply(i);
			if (mul.compareTo(big) > 0)
				return false;
			if (mul.compareTo(big) == 0)
				return true;
		}
	}

}
