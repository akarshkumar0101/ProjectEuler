package main;

import math.Prime;

public class Problem41 {

	public static void main(String[] args) {
		for (int i = 0; i < 10000000; i++) {
			if (Prime.isPrime(i)) {
				if (isPandigital(i)) {
					System.out.println(i);
				}
			}
		}
	}

	public static boolean isPandigital(int num) {
		String chars = (num + "");
		for (int i = 1; i <= chars.length(); i++) {
			char c = (char) (i + '0');
			if (!chars.contains(c + ""))
				return false;
		}
		return true;
	}

}
