package main;

public class Problem46 {

	public static void main(String[] args) {
		for (int num = 3;; num += 2) {
			if (Prime.isPrime(num)) {
				continue;
			}
			int maxsqr = (int) Math.sqrt(num / 2);
			boolean primeExists = false;
			for (int sqr = 1; sqr <= maxsqr; sqr++) {
				int rem = num - 2 * sqr * sqr;
				if (Prime.isPrime(rem)) {
					primeExists = true;
					break;
				}
			}
			if (!primeExists) {
				System.out.println(num);
				break;
			}
		}
	}

}
