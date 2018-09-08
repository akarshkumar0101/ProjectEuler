package main;

public class Problem30 {
	
	public static void main(String[] args) {
		int sum = 0;
		for(int num=2;num<100000000;num++) {
			if(num==sumDigits(num, 5)) {
				System.out.println(num);
				sum+=num;
			}
		}
		System.out.println();
		System.out.println(sum);
	}
	private static int sumDigits(int num,int pow) {
		int sum=0;
		
		for(char c: (num+"").toCharArray()) {
			int digit = Integer.parseInt(c+"");
			sum += (int) Math.pow(digit, pow);
		}
		
		return sum;
	}

}
//not 8301
