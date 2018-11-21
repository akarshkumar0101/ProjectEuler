package main;

public class Problem78 {

	public static void main(String[] args) {
		System.out.println(5);
	}

	public static long p(int n) {
		if (n == 1)
			return 1;
		long num = 1;
		for (int i = n - 1; i >= (double) n / 2; i--) {
			num += p(i);
		}
		return num;
	}

}
