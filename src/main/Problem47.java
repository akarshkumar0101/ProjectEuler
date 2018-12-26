package main;

import java.util.HashMap;

public class Problem47 {

	public static void main(String[] args) {
		HashMap<Integer, Integer> f1 = math.Factorization.factorize(644);
		HashMap<Integer, Integer> f2 = math.Factorization.factorize(645);
		HashMap<Integer, Integer> f3 = math.Factorization.factorize(646);
		HashMap<Integer, Integer> f4 = math.Factorization.factorize(647);

		int ans = 0;
		for (int i = 644; true; i++) {
			if (checkUnique(f1, f2, f3, f4)) {
				ans = i;
				break;
			}
			f1 = f2;
			f2 = f3;
			f3 = f4;
			f4 = math.Factorization.factorize(i + 4);
		}
		System.out.println(ans);
	}

	public static boolean checkUnique(HashMap<Integer, Integer> f1, HashMap<Integer, Integer> f2,
			HashMap<Integer, Integer> f3, HashMap<Integer, Integer> f4) {
		return checkUnique(f1, f2) && checkUnique(f2, f3) && checkUnique(f1, f3) && checkUnique(f1, f4)
				&& checkUnique(f2, f4) && checkUnique(f3, f4);
	}

	public static boolean checkUnique(HashMap<Integer, Integer> f1, HashMap<Integer, Integer> f2) {
		if (f1.keySet().size() != 4 || f2.keySet().size() != 4)
			return false;
		for (int fact : f1.keySet()) {
			if (f1.get(fact) == f2.get(fact) && f1.get(fact) != null) {
				return false;
			}
		}
		return true;
	}

}
