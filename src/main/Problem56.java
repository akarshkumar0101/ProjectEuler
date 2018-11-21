package main;

import java.math.BigInteger;

public class Problem56 {
	public static void main(String[] args) {
		int maxSum = -1;
		for (int a = 0; a < 100; a++) {
			for (int b = 0; b < 100; b++) {
				BigInteger num = new BigInteger(a + "").pow(b);
				int digSum = digSum(num);
				if (digSum > maxSum)
					maxSum = digSum;
			}
		}
		System.out.println(maxSum);
	}

	public static int digSum(BigInteger num) {
		int sum = 0;
		for (char c : num.toString().toCharArray()) {
			sum += (c - '0');
		}
		return sum;
	}
}
