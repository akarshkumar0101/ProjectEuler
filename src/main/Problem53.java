package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem53 {

	public static void main(String[] args) {
		// ncr>10^6 n<=100
		int num = 0;
		for (int n = 0; n <= 100; n++) {
			for (int r = 0; r <= 100; r++) {

				List<Integer> numerator = factorialList(n),
						denominator = combine(factorialList(r), factorialList(n - r));
				List<List<Integer>> fraction = removeCommonalities(numerator, denominator);
				numerator = fraction.get(0);
				denominator = fraction.get(1);
				if (isBiggerThanMillion(numerator, denominator)) {
					num++;
				}
			}
		}
		System.out.println(num);
	}

	public static List<Integer> factorialList(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n < 2) {
			return list;
		}
		for (int i = 2; i <= n; i++) {
			list.add(i);
		}

		return list;
	}

	public static boolean isBiggerThanMillion(List<Integer> list1, List<Integer> list2) {
		double mul = 1.0;
		for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {

			if (i < list2.size()) {
				mul /= list2.get(i);
			}
			if (i < list1.size()) {
				mul *= list1.get(i);
			}

			if (i >= list1.size() || i >= list2.size()) {
				if (mul >= 1000000.0) {
					return true;
				}
			}
		}
		return false;
	}

	public static List<Integer> combine(List<Integer> list1, List<Integer> list2) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : list1) {
			list.add(i);
		}
		for (int i : list2) {
			list.add(i);
		}
		return list;
	}

	public static List<List<Integer>> removeCommonalities(List<Integer> list1_, List<Integer> list2_) {
		List<Integer> list1 = new ArrayList<Integer>(), list2 = new ArrayList<Integer>();
		for (int i : list1_) {
			list1.add(i);
		}
		for (int i : list2_) {
			list2.add(i);
		}

		Iterator<Integer> it1 = list1.iterator();
		while (it1.hasNext()) {
			int i1 = it1.next();
			for (int i2 = 0; i2 < list2.size(); i2++) {
				if (list2.get(i2) == i1) {
					list2.remove(i2);
					it1.remove();
					break;
				}
			}
		}
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(list1);
		ret.add(list2);
		return ret;

	}

}
