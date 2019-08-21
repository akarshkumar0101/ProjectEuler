package main;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {

	public static void main(String[] args) {
		
		int leastElement = Integer.MAX_VALUE;
		int maxLen = 0;
		int maxLenStart = -1;
		
		for(int i=0;i<=1000000;i++) {
			int num = i;
			int least = i;
			List<Integer> chain = new ArrayList<>();
			chain.add(num);
			boolean invalid = false;
			while(true) {
				num= amic(num);
				if(num>1000000) {
					invalid= true;
					break;
				}
				if(num<least) {
					least = num;
				}
				if(chain.contains(num)) {
					if(num!=i){
						invalid=true;
					}
					break;
				}
				chain.add(num);
			}
			if(invalid) {
				continue;
			}
			
			int len = chain.size();
			if(i%10000==0)
				System.out.println(i+": "+len);
			if(len>maxLen) {
				maxLen = len;
				maxLenStart = i;
				leastElement = least;
			}
		}
		//System.out.println(maxLen);
		System.out.println(leastElement);
		
//		int num = maxLenStart;
//		for(int i=0; i <maxLen+1;i++) {
//			System.out.print(num+" ");
//			num=amic(num);
//		}

	}
	
	public static int amic(int inp) {
		int amic = 1;
		double sqrt = Math.sqrt(inp);
		for(int i=2; i <= sqrt; i++) {
			if(inp%i==0) {
				amic+=i;
				int div = inp/i;
				if(div != i) {
					amic+=div;
				}
				if(amic>1000000){
					//return -1;
				}
			}
		}
		return amic;
	}
}
