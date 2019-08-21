package main;

public class Problem66 {
	public static void main(String[] args) {
		long largestX = Integer.MIN_VALUE;
		long largestXD = -1;
		for (long d = 2; d <= 1000; d++) {
			if (Math.sqrt(d) % 1 == 0) {
				continue;
			}
			long x = findMinX(d);
			if(x>largestX){
				largestX = x;
				largestXD = d;
			}
		}
		System.out.println(largestX);
		System.out.println(largestXD);
	}

	public static long findMinX(long D) {
		for(long x=2;;x++){
			long y = findY(x,D);
			if(y!=-1){
				return x;
			}
		}
	}
	public static long findY(long x, long D){
		long t = x*x - 1;
		if(t%D!=0){
			return -1;
		}
		t = t/D;

		//y is sqrt t
		double y = Math.sqrt(t);
		if(y%1==0){
			return (long) y;
		}

		return -1;
	}
}
