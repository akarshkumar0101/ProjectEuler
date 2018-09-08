package main;

public class Problem33 {

	public static void main(String[] args) {
		int totn = 1, totd = 1;

		for (int d = 0; d < 100; d++) {
			for (int n = 0; n < d; n++) {
				if (hasCommonDigit(n, d)) {
					int[] newFrac = cancelDigits(n, d);
					int a = newFrac[0], b = newFrac[1];
					if ((double) a / b == (double) n / d) {
						totn *= a;
						totd *= b;
					}
				}
			}
		}
		System.out.println(totn+"/"+totd);
	}

	public static boolean hasCommonDigit(int a, int b) {
		if (a == b)
			return false;
		for (char c : (a + "").toCharArray()) {
			if ((b + "").contains(c + "") && c != '0')
				return true;
		}
		return false;
	}

	public static int[] cancelDigits(int a, int b) {
		if (!hasCommonDigit(a, b))
			return null;
		String stra = a + "", strb = b + "";
		if (stra.length() == 1)
			stra = "0" + stra;
		if (strb.length() == 1)
			strb = "0" + strb;
		char aa = stra.charAt(0), ab = stra.charAt(1), ba = strb.charAt(0), bb = strb.charAt(1);

		char x = 0, y = 0;
		if (aa == ba) {
			x = ab;
			y = bb;
		} else if (aa == bb) {
			x = ab;
			y = ba;
		} else if (ab == ba) {
			x = aa;
			y = bb;
		} else if (ab == bb) {
			x = aa;
			y = ba;
		}
		return new int[] { Integer.parseInt(x + ""), Integer.parseInt(y + "") };
	}

}
