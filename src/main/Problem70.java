package main;

import java.util.HashMap;

import math.Factorization;
import math.Prime;

public class Problem70 {

	public static void main(String[] args) {

		double minratio = Double.MAX_VALUE;
		int minn = -1;
		for (int n = 2; n < 10000000; n++) {
			int phi = phi(n);

			if (n % 500000 == 0)
				System.out.println(n);
			if (!isPermuation(n, phi)) {
				continue;
			}
			double ratio = (double) n / phi;
			if (ratio < minratio) {
				minratio = ratio;
				minn = n;
			}
		}
		System.out.println(minn);
	}

	public static int phi(int n) {
		if (Prime.isPrime(n)) {
			return n - 1;
		}
		HashMap<Integer, Integer> primes = Factorization.factorize(n);
		double mul = n;
		for (int p : primes.keySet()) {
			if (p == n) {
				continue;
			}
			mul *= (double) ((double) 1 - (double) 1 / p);
		}

		int phi = (int) mul;
		return phi;
	}

	public static boolean isPermuation(int a, int b) {
		String as = a + "", bs = b + "";
		bs = matchZeros(as, bs);

		if (as.length() != bs.length())
			return false;
		for (char c : as.toCharArray()) {
			int ind = bs.indexOf(c);
			if (ind == -1) {
				return false;
			}
			bs = bs.substring(0, ind) + bs.substring(ind + 1, bs.length());
		}
		return true;
	}

	public static String matchZeros(String a, String b) {
		int zeros1 = num0(a), zeros2 = num0(b);
		if (zeros2 < zeros1) {
			for (int i = 0; i < (zeros1 - zeros2); i++) {
				b = "0" + b;
			}
		}
		return b;
	}

	public static int num0(String a) {
		int zeros = 0;
		for (char c : a.toCharArray()) {
			if (c == '0')
				zeros++;
		}
		return zeros;
	}

}
