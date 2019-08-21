package main;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem57 {

	public static void main(String[] args) {


		int num = 0;

		for (int i = 1; i < 1000; i++) {
			//System.out.println(i+" "+calculate(i));
			if (numHasMoreDigits(getExpansion(i))) {
				num++;
			}
		}

		System.out.println(num);

	}

	public static Ratio getExpansion(int it){
		Ratio ratio = calculate(it);
		ratio.add(1);
		ratio.simplify();
		return ratio;
	}

	public static final Map<Integer, Ratio> calculatedFracs = new HashMap<>();

	public static Ratio calculate(int it) {
		Ratio ratio = new Ratio(1,2);

		if(it>1) {
//			for (int i = 1; i < it; i++) {
//				ratio.add(2);
//				ratio.inverse();
//			}
			ratio = calculatedFracs.get(it-1).clone();

			ratio.add(2);
			ratio.inverse();

		}
		ratio.simplify();

		calculatedFracs.put(it, ratio.clone());

		return ratio;
	}

	public static boolean numHasMoreDigits(Ratio ratio) {
		return getDigitCount(ratio.numerator)>getDigitCount(ratio.denominator);
	}

	public static int getDigitCount(BigInteger number) {
		double factor = Math.log(2) / Math.log(10);
		int digitCount = (int) (factor * number.bitLength() + 1);
		if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
			return digitCount - 1;
		}
		return digitCount;
	}


	static class Ratio {
		BigInteger numerator;
		BigInteger denominator;
		public Ratio(int numerator, int denominator){
			this.numerator = BigInteger.valueOf(numerator);
			this.denominator = BigInteger.valueOf(denominator);
		}
		public void inverse(){
			BigInteger prevNum = numerator;
			numerator = denominator;
			denominator = prevNum;
		}
		public void add(int num){
			numerator = numerator.add(denominator.multiply(BigInteger.valueOf(num)));
		}

		public void simplify(){
			BigInteger gcd = numerator.gcd(denominator);
			numerator = numerator.divide(gcd);
			denominator = denominator.divide(gcd);
		}

		public Ratio clone(){
			Ratio ratio = new Ratio(1,1);
			ratio.numerator = numerator;
			ratio.denominator = denominator;
			return ratio;
		}
		public String toString(){
			return numerator +" / "+denominator;
		}
	}

}

