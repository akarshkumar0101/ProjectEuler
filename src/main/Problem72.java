package main;

import java.util.*;

public class Problem72 {

    public static void main(String... args) {
        Set<Integer> toConsider = new HashSet<>();
        Set<Integer> basisSet = new HashSet<>();

        for(int i=2;i<=1000000;i++){
            toConsider.add(i);
        }
        for(int n=1000000;n>=2;n--){
            if(toConsider.isEmpty()){
                break;
            }
            if(toConsider.contains(n)){
                toConsider.remove(n);
                basisSet.add(n);
                Map<Integer,Integer> factorization = factorize(n);
                for(int factor:factorization.keySet()){
                    toConsider.remove(factor);
                }
            }
        }
        System.out.println(basisSet.size());

    }

    public static Map<Integer, Integer> factorize(int number) {
        Stack<Integer> toFactorize = new Stack<>();
        Map<Integer, Integer> factorization = new HashMap<>();

        toFactorize.push(number);
        while (!toFactorize.isEmpty()) {
            int num = toFactorize.pop();
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    //add i as a factor
                    if (factorization.containsKey(i)) {
                        factorization.put(i,factorization.get(i)+1);
                    } else {
                        factorization.put(i,1);
                    }
                    toFactorize.push(num / i);
                    break;
                }
            }
            if(isPrime) {
                //num is Prime
                if (factorization.containsKey(num)) {
                    factorization.put(num, factorization.get(num) + 1);
                } else {
                    factorization.put(num, 1);
                }
            }
        }
        return factorization;
    }


    private static Map<Integer, Boolean> isPrimeMap = new HashMap<>();

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (isPrimeMap.containsKey(n)) {
            return isPrimeMap.get(n);
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrimeMap.put(n, false);
                return false;
            }
        }
        isPrimeMap.put(n, true);
        return true;
    }
}
