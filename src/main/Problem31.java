package main;

public class Problem31 {

	private static final int[] coinValues = new int[] { 200, 100, 50, 20, 10, 5, 2, 1, };

	public static void main(String[] args) {
		System.out.println(numPossible(200,0));
	}

	private static int numPossible(int value, int coini) {
		int res = 0;
		if(coinValues[coini]==1) {
			return 1;
		}
		for (int numCoins = 0; numCoins <= value / coinValues[coini]; numCoins++) {
			res+=numPossible(value-coinValues[coini]*numCoins,coini+1);
		}
		return res;
	}
}
