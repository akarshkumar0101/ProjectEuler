package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Problem100 {

	public static void main(String[] args) {
		// (X/10^12)([X-1]/[10^12-1])=1/2
		// X^2-X-(10^12*(10^12-1)/2)=0
		BigInteger c = new BigInteger("1000000000000");
		BigInteger a = BigInteger.ONE, b = BigInteger.ONE.multiply(new BigInteger("-1"));
		c = c.multiply(c.subtract(BigInteger.ONE)).divide(new BigInteger("2")).multiply(new BigInteger("-1"));

		System.out.println(a + " " + b + " " + c);

		BigInteger negb = b.multiply(new BigInteger("-1"));
		BigInteger disc = b.multiply(b).subtract(a.multiply(c).multiply(new BigInteger("4")));
		BigInteger sqrt = sqrt(disc);
		BigInteger ans = negb.add(sqrt).divide(a.multiply(new BigInteger("2")));
		System.out.println(ans);

		System.out.println(sqrt(new BigInteger("99")));
	}

	public static BigInteger sqrt(BigInteger num_) {
		// solution to: x^2-num=0

		BigDecimal num = new BigDecimal(num_);
		// double error = 1;

		BigDecimal x = num;
		for (int i = 0; i < 100; i++) {
			BigDecimal slope = x.add(x);
			BigDecimal y = x.multiply(x).subtract(num);

			// y-y0=m(x-x0)
			// -y0=m(x-x0)
			// -y0/m+x0=x;
			x = (y.multiply(new BigDecimal("-1"))).divide(slope, RoundingMode.HALF_UP).add(x);

			// error = y.doubleValue();
		}
		return x.toBigInteger();

	}

}
