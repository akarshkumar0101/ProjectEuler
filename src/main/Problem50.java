package main;

import java.util.ArrayList;
import java.util.List;

import math.Prime;

public class Problem50 {

	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < 1000000; i++) {
			if (Prime.isPrime(i)) {
				primes.add(i);
			}
		}
		int largePrime = 0;
		int numPrimes = 1;
		for (int i1 = 0; i1 < primes.size() - 1; i1++) {
			for (int i2 = i1 + numPrimes; i2 < primes.size(); i2++) {
				int sum = sum(primes, i1, i2);
				// System.out.println(i1 + " " + i2);
				if (sum > 1000000) {
					break;
				}
				if (Prime.isPrime(sum)) {
					numPrimes = i2 - i1;
					largePrime = sum;
				}
			}
		}
		System.out.println(largePrime);

	}

	public static int sum(List<Integer> list, int i1, int i2) {
		int sum = 0;
		for (int i = i1; i < i2; i++)
			sum += list.get(i);
		return sum;
	}

}
