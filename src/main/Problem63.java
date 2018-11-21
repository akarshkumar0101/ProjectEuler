package main;

public class Problem63 {

	public static void main(String[] args) {
		int numInts = 0;
		for (int n = 1; n < 12; n++) {
			System.out.println(n + ": " + numCounts(n));
			numInts += numCounts(n);
		}
		System.out.println(numInts);
	}

	public static int numCounts(int n) {
		long min = minNum(n), max = maxNum(n);
		double lowroot = (double) nthRoot(min, n), highroot = (double) nthRoot(max, n);
		for (int i = (int) Math.ceil(lowroot); i <= highroot; i++) {
			System.out.println(i + "^" + n + "=" + Math.pow(i, n));
		}
		return (int) (Math.floor(highroot) - Math.ceil(lowroot));
	}

	public static double nthRoot(long a, int n) {
		return (double) Math.pow(a, (double) 1 / n);
	}
//	public static BigDecimal minNthRoot(int n) {
//		BigDecimal num = new BigDecimal(a);
//		num.
//	}

	public static long minNum(int ndigits) {
		return (long) (Math.pow(10, ndigits - 1));
	}

	public static long maxNum(int ndigits) {
		return (long) (Math.pow(10, ndigits) - 1);
	}
//	public static BigInteger minNum(int ndigits) {
//		return BigInteger.TEN.pow(ndigits - 1);
//	}

//	public static BigInteger maxNum(int ndigits) {
//		return BigInteger.TEN.pow(ndigits).subtract(BigInteger.ONE);
//	}

}
