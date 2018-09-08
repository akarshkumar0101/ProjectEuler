package main;

public class Problem39 {
	public static void main(String[] args) {
		int maxp = -1, maxSol=-1;
		for(int p=1;p<=1000;p++) {
			int sol = numSolutions(p);
			if(sol>maxSol) {
				maxSol=sol;
				maxp=p;
			}
		}
		System.out.println(maxp);
	}
	private static int numSolutions(int per) {
		int sol = 0;
		for(int a=1;a<=per/2;a++) {
			for(int b=1;b<per-a;b++){
				double c = Math.sqrt(a*a+b*b);
				if(c%1==0) {
					if(a+b+(int)c==per) {
						sol++;
					}
				}
			}
		}
		return sol/2;
	}
}
