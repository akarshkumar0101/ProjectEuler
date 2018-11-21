package main;

import java.math.BigInteger;

public class Problem97 {

	public static void main(String[] args) {
		// 28433*2^27830457+1

		BigInteger two = new BigInteger("2");
		BigInteger a=new BigInteger("28433");
		BigInteger b=new BigInteger("7830457");
		
		BigInteger mod = new BigInteger("1000000000000");
		
		
		BigInteger exp = two.modPow(b, mod);
		BigInteger ans = exp.multiply(a).add(BigInteger.ONE).mod(mod);
		
		System.out.println(ans);
		
	}
}
