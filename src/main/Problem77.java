package main;

import java.util.*;

public class Problem77 {

    public static void main(String... args) {

        int n;
        for(n=5;;n++) {
            List<List<Integer>> ways = new ArrayList<>();
            int val = numWaysToSplit(n, n - 1, new ArrayList<>(), ways);
            if(val>5000){
                break;
            }
        }
        System.out.println(n);
    }

    public static Map<Problem76.Int2, Integer> map = new HashMap<>();

    public static int numWaysToSplit(int n, int maxGroupSize, List<Integer> building, List<List<Integer>> ways) {
        if (n == 0) {
            //ways.add(new ArrayList<>(building));
            return 1;
        }
        Problem76.Int2 input = new Problem76.Int2(n, maxGroupSize);
        if (map.containsKey(input)) {
            return map.get(input);
        }

        maxGroupSize = Math.min(n, maxGroupSize);
        int numWays = 0;
        for (int firstGroupSize = maxGroupSize; firstGroupSize >= 1; firstGroupSize--) {
            if(!isPrime(firstGroupSize)){
                continue;
            }
            int leftToGroup = n - firstGroupSize;

            building.add(firstGroupSize);

            numWays += numWaysToSplit(leftToGroup, Math.min(firstGroupSize, maxGroupSize), building, ways);

            building.remove(building.size() - 1);
        }

        map.put(input, numWays);
        return numWays;
    }


    static class Int2 {
        int a, b;

        public Int2(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object another) {
            return another instanceof Problem76.Int2 && ((Problem76.Int2) another).a == a && ((Problem76.Int2) another).b == b;
        }

        @Override
        public int hashCode() {
            return 1000000 * a + b;
        }
    }

    private static Map<Integer, Boolean> isPrimeMap = new HashMap<>();

    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(isPrimeMap.containsKey(n)){
            return isPrimeMap.get(n);
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                isPrimeMap.put(n,false);
                return false;
            }
        }
        isPrimeMap.put(n,true);
        return true;
    }
}

