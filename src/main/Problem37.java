package main;

import math.Prime;

public class Problem37 {

	public static void main(String[] args) {
		int numPrime = 0;
		int sum = 0;
		for (int n = 9;; n++) {
			if (Prime.isPrime(n) && isTPrimeL(n) && isTPrimeR(n)) {
				numPrime++;
				sum += n;
				if (numPrime == 11)
					break;
			}
		}
		System.out.println(sum);
	}

	public static boolean isTPrimeL(int prime) {
		String str = prime + "";
		for (int i = 1; i < str.length(); i++) {
			String s = str.substring(i, str.length());
			if (!Prime.isPrime(Integer.parseInt(s))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isTPrimeR(int prime) {
		String str = prime + "";
		for (int i = str.length() - 1; i > 0; i--) {
			String s = str.substring(0, i);
			if (!Prime.isPrime(Integer.parseInt(s))) {
				return false;
			}
		}
		return true;
	}

}
