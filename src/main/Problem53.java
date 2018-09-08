package main;

import math.Math;

public class Problem53 {

	public static void main(String[] args) {
		// ncr>10^6 n<=100
		
		System.out.println(Math.intFactorial(21));
		
		int num = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n / 2; r++) {
				long val = Math.nCr(n, r);
				//System.out.println(n + " " + r + " " + val);
				if (val > 1000000) {
					int end = n - r;
					num += (end - r + 1);
					break;
				}
			}
		}
		System.out.println(num);
	}

}
