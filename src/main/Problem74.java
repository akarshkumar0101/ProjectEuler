package main;

import java.util.ArrayList;
import java.util.List;

import math.Probability;

public class Problem74 {

	public static void main(String[] args) {
		int num60 = 0;
		for (int i = 0; i < 1000000; i++) {
			if (lengthChain(i) == 60)
				num60++;
		}
		System.out.println(num60);
	}

	public static long digitFactorial(long num) {
		String str = num + "";
		long ans = 0;
		for (char c : str.toCharArray()) {
			int digit = c - '0';
			ans += Probability.intFactorial(digit);
		}
		return ans;
	}

	public static int lengthChain(long num) {
		List<Long> list = new ArrayList<Long>();

		while (true) {
			list.add(num);
			num = digitFactorial(num);
			if (list.contains(num)) {
				return list.size();
			}
		}
	}
}
