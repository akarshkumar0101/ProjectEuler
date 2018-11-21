package main;

import java.util.ArrayList;
import java.util.List;

import array.Arrays;
import math.Prime;

public class Problem49 {
	public static void main(String[] args) {
		List<Integer> considered = new ArrayList<Integer>();
		for (int i = 1000; i <= 9999; i++) {
			if (considered.contains(i))
				continue;
			int[] combo = allArrangements(i + "");
			for (int x : combo) {
				considered.add(x);
			}
			int numPrime = numPrime(combo);
			if (numPrime < 3) {
				continue;
			}
			int[] primes = getPrimes(combo, numPrime);
			int[] seq = getArithSequence(primes);
			if (seq != null) {
				System.out.println(seq[0] + " " + seq[1] + " " + seq[2]);
			}
		}
	}

	public static int[] allArrangements(String str) {
		int[] combo = new int[24];
		int i = 0;
		for (int i1 = 0; i1 < 4; i1++) {
			for (int i2 = 0; i2 < 4; i2++) {
				if (i2 == i1)
					continue;
				for (int i3 = 0; i3 < 4; i3++) {
					if (i3 == i1 || i3 == i2)
						continue;
					for (int i4 = 0; i4 < 4; i4++) {
						if (i4 == i1 || i4 == i2 || i4 == i3)
							continue;
						String numstr = str.charAt(i1) + "" + str.charAt(i2) + "" + str.charAt(i3) + ""
								+ str.charAt(i4);
						combo[i++] = Integer.parseInt(numstr);
					}
				}
			}
		}
		return combo;
	}

	public static int numPrime(int[] arr) {
		int numPrime = 0;
		for (int i : arr) {
			if (Prime.isPrime(i)) {
				numPrime++;
			}
		}
		return numPrime;
	}

	public static int[] getPrimes(int[] arr, int l) {
		int[] primes = new int[l];

		int i = 0;
		for (int a : arr) {
			if (Prime.isPrime(a)) {
				primes[i++] = a;
			}
		}
		return primes;
	}

	public static int[] getArithSequence(int[] array) {
		for (int i1 = 0; i1 < array.length; i1++) {
			for (int i2 = 0; i2 < array.length; i2++) {
				if (i2 == i1)
					continue;
				int diff = array[i2] - array[i1];
				int next = array[i2] + diff;
				for (int i3 = 0; i3 < array.length; i3++) {
					if (i3 == i1 || i3 == i2)
						continue;
					if (next == array[i3]) {
						return new int[] { array[i1], array[i2], array[i3] };
					}
				}
			}
		}
		return null;
	}

	public static void mainf(String[] args) {
		for (byte a = 0; a < 10; a++) {
			for (byte b = 0; b < 10; b++) {
				for (byte c = 0; c < 10; c++) {
					for (byte d = 0; d < 10; d++) {
						List<Integer> list = getScrambledPrimes(a, b, c, d);
						if (list.size() >= 3) {
							// System.out.println(list.get(0));
							for (int x : list) {
								for (int y : list) {
									if (y >= x)
										continue;
									int diff = x - y;
									if (list.contains(x + diff)) {
										System.out.println(y + " " + x + " " + (x + diff));
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static List<Integer> getScrambledPrimes(byte a, byte b, byte c, byte d) {
		List<Integer> list = new ArrayList<>();
		Byte[] fixed = new Byte[] {}, more = new Byte[] { a, b, c, d };
		appendList(list, fixed, more);
		return list;
	}

	public static void appendList(List<Integer> list, Byte[] fixed, Byte[] more) {
		if (more.length == 1) {
			String str = "";
			for (byte b : fixed) {
				str += b;
			}
			str += more[0];
			int i = Integer.parseInt(str);
			if (i >= 1000 && Prime.isPrime(i))
				list.add(i);
			return;
		}
		for (byte b : more) {
			appendList(list, Arrays.append(fixed, b), Arrays.remove(more, b));
		}
	}

}
