package main;

public class Problem76 {

	public static void main(String[] args) {
		// 2: 1+1

		// 3: 2+1
		// 1+1+1

		// 4: 3+1
		// 2+2
		// 2+1+1
		// 1+1+1+1

		// 5: 4+1
		// 3+2
		// 3+1+1
		// 2+2+1
		// 2+1+1+1
		// 1+1+1+1+1
		
		//6:
		//	5+1
		//	4+2
		//	4+1+1
		//	3+3
		//	3+2+1
		//	3+1+1+1
		// 	2+2+2
		//	2+2+1+1
		//	2+1+1+1+1
		//	1+1+1+1+1+1
	}

	public static int numWays(int n) {
		int ans = 0;
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		for (int i = n - 1; i > 0; i--) {
			
		}
		return ans;
	}

}
