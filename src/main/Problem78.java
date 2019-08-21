package main;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {

	public static void main(String[] args) {
		for(int n=1;;n++){
			if(n%10==0)
				System.out.println(n);
			int pn = p(n);
			if(pn%1000000==0){
				System.err.println(n+" "+pn);
				break;
			}
		}
	}
	public static int p(int n){
		List<List<Integer>> ways = new ArrayList<>();
		int val = Problem76.numWaysToSplit(n,n, new ArrayList<>(), ways);
		return val;
	}

//	//the ways that you can split n into groups given a maximum group size of groupLimit
//	public static int p(int n, int groupLimit){
//		if(n<=1){
//			//System.out.println();
//			return 1;
//		}
//		int totalWays = 0;
//		if(groupLimit>=n){
//			totalWays++;
//		}
//		for(int firstGroup = Math.min(groupLimit,n-1); firstGroup>=1;firstGroup--){
//			//System.out.print(firstGroup+", ");
//			totalWays+=p(n-firstGroup,firstGroup);
//		}
//		return totalWays;
//	}
}
