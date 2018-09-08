package main;

public class Problem57 {

	public static void main(String[] args) {

		int num = 0;

		for (int i = 1; i < 1000; i++) {
			if (numHasMoreDigits(calculate(i))) {
				num++;
			}
		}

		System.out.println(num);

	}

	public static int[] calculate(int it) {
		int[] frac = new int[] { 1, 2 };

		for (int i = 1; i < it; i++) {
			frac = add(frac, 2);
			frac = div(new int[] { 1, 1 }, frac);
		}

		frac = add(frac, 1);
		return frac;
	}

	public static boolean numHasMoreDigits(int[] frac) {
		return (frac[0] + "").length() > (frac[1] + "").length();
	}

	public static int[] add(int[] frac, int a) {
		return new int[] { frac[0] + a * frac[1], frac[1] };
	}

	public static int[] mul(int[] frac1, int[] frac2) {
		return new int[] { frac1[0] * frac2[0], frac1[1] * frac2[1] };
	}

	public static int[] div(int[] frac1, int[] frac2) {
		return new int[] { frac1[0] * frac2[1], frac1[1] * frac2[0] };
	}

	public static int[] simplify(int[] frac) {
		for (int i = 0; i < frac[0]; i++) {
			if (frac[0] % i == 0 && frac[1] % i == 0) {
				return simplify(new int[] { frac[0] / i, frac[1] / i });
			}
		}
		return frac;
	}

}
