package main;

import java.util.ArrayList;
import java.util.List;

import math.Prime;

public class Problem60 {
	public static final List<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		int l = 1;
		while (Problem60.primes.size() < 1000) {
			if (Prime.isPrime(l)) {
				Problem60.primes.add(l);
			}

			l++;
		}
		List<Integer> primeSet = new ArrayList<>();
		int p = 0;
		for (int i1 = 0; i1 < Problem60.primes.size(); i1++) {
			System.out.println(i1);
			primeSet.add(Problem60.primes.get(i1));
			for (int i2 = 0; i2 < i1; i2++) {
				p = Problem60.primes.get(i2);
				if (primeSet.contains(p)) {
					continue;
				}
				primeSet.add(p);
				if (Problem60.satisfiesPrimeConcatenating(primeSet)) {
					for (int i3 = 0; i3 < i2; i3++) {
						p = Problem60.primes.get(i3);
						if (primeSet.contains(p)) {
							continue;
						}
						primeSet.add(p);
						if (Problem60.satisfiesPrimeConcatenating(primeSet)) {
							for (int i4 = 0; i4 < i3; i4++) {
								p = Problem60.primes.get(i4);
								if (primeSet.contains(p)) {
									continue;
								}
								primeSet.add(p);
								if (Problem60.satisfiesPrimeConcatenating(primeSet)) {
									for (int i5 = 0; i5 < i4; i5++) {
										p = Problem60.primes.get(i5);
										if (primeSet.contains(p)) {
											continue;
										}
										primeSet.add(p);
										if (Problem60.satisfiesPrimeConcatenating(primeSet)) {
											System.out.println(primeSet);
										}
										primeSet.remove(4);
									}
								}
								primeSet.remove(3);
							}
						}
						primeSet.remove(2);
					}
				}
				primeSet.remove(1);
			}
			primeSet.remove(0);
		}
	}

	public static boolean satisfiesPrimeConcatenating(List<Integer> primes) {
		for (int p1 : primes) {
			for (int p2 : primes) {
				if (p1 == p2) {
					continue;
				}
				long newp = Long.parseLong(p1 + "" + p2);
				if (!Prime.isPrime(newp))
					return false;
			}
		}
		return true;
	}

}
