package main;

import java.util.ArrayList;
import java.util.List;

public class Problem26 {

	public static void main(String[] args) {
		int longest = -1;
		int d = -1;
		for (int i = 2; i < 1000; i++) {

			int r = numRecurrance(i);
			if (r > longest) {
				longest = r;
				d = i;
			}

		}
		System.out.println(d);

	}

	public static int numRecurrance(int d) {

		List<Integer> remainders = new ArrayList<Integer>();
		List<Integer> expansion = new ArrayList<Integer>();

		int n = 1;
		while (true) {
			int r = n % d;
			// int dec = n / d;
			// System.out.println(n + " " + r);

			for (int i = 0; i < expansion.size(); i++) {
				if (expansion.get(i) == n && remainders.get(i) == r) {
					return expansion.size() - i;
				}
			}

			expansion.add(n);
			remainders.add(r);

			n = 10 * r;
		}
	}
}
