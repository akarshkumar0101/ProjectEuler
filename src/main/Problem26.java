package main;

import java.util.ArrayList;
import java.util.List;

public class Problem26 {

	public static void main(String[] args) {
		System.out.println(numRecurrance(99, 1));
	}

	public static int numRecurrance(int d, int a) {

		List<Integer> nums = new ArrayList<>();

		int tax = 0;
		for (;;) {
			if (a == 0) {
				return 0;
			}

			a = makeMoreThan(d, a);

			for (int ff : nums)
				System.out.println(ff);

			if (nums.contains(a)) {
				return nums.size() - nums.indexOf(a) + tax;
			}

			nums.add(a);
			int n = a / d;
			a = a - n * d;
		}
	}

	public static int makeMoreThan(int d, int a) {
		if (a < d)
			return makeMoreThan(d, 10 * a);
		else
			return a;
	}

}
