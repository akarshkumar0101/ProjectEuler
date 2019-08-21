package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		List<List<Integer>> ways = new ArrayList<>();
		int val = numWaysToSplit(100,99, new ArrayList<>(), ways);
		System.out.println(val);
	}

	public static Map<Int2, Integer> map = new HashMap<>();

	public static int numWaysToSplit(int n, int maxGroupSize, List<Integer> building, List<List<Integer>> ways){
		if(n==0){
			//ways.add(new ArrayList<>(building));
			return 1;
		}
		Int2 input = new Int2(n,maxGroupSize);
		if(map.containsKey(input)){
			return map.get(input);
		}

		maxGroupSize = Math.min(n,maxGroupSize);
		int numWays = 0;
		for(int firstGroupSize = maxGroupSize;firstGroupSize>=1;firstGroupSize--){
			int leftToGroup = n-firstGroupSize;

			building.add(firstGroupSize);

			numWays += numWaysToSplit(leftToGroup, Math.min(firstGroupSize,maxGroupSize), building, ways);

			building.remove(building.size()-1);
		}

		map.put(input,numWays);
		return numWays;
	}


	static class Int2 {
		int a, b;
		public Int2(int a, int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public boolean equals(Object another) {
			return another instanceof Int2 && ((Int2)another).a == a && ((Int2)another).b == b;
		}
		@Override
		public int hashCode(){
			return 1000000*a+b;
		}
	}
}
