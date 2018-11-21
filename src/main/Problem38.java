package main;

public class Problem38 {

	public static void main(String[] args) {
		long largest = -1;
		for (int k = 1; k < 100000; k++) {
			for (int n = 2; n < 10; n++) {
				int[] arr = new int[n];
				for (int i = 1; i <= n; i++) {
					arr[i - 1] = k * i;
				}
				if (isPandigital(arr)) {
					long l = getLong(arr);
					if (l > largest) {
						largest = l;
					}
				}
			}
		}
		System.out.println(largest);
	}

	public static boolean isPandigital(int[] arr) {
		String str = "";
		for (int i : arr) {
			str += i;
		}
		if (str.length() != 9)
			return false;
		for (int i = 1; i <= 9; i++) {
			char cc = (char) (i + '0');
			if (!str.contains(cc + "")) {
				return false;
			}
		}
		return true;
	}

	public static long getLong(int[] arr) {
		String str = "";
		for (int i : arr) {
			str += i;
		}
		return Long.parseLong(str);
	}

}
