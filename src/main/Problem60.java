package main;

import java.util.*;

import math.Prime;

public class Problem60 {
	public static final List<Long> primes = new ArrayList<>();

	//26033
	public static void main(String[] args) {
		for(long n=2;n<10000;n++){
			if(isPrime(n)){
				primes.add(n);
			}
		}


		Set<Long> primeSet = new HashSet<>();
		search(primeSet,-1);
		//System.out.println(primeSet);

		long sum = sum(primeSet);
		System.out.println(sum);

	}

	public static boolean search(Set<Long> primeSet, int lastPrimeAddedID){
		//System.out.println(primeSet);
		//fail by default
		if(!satisfiesPrimeConcatenating(primeSet)){
			return false;
		}
		//found it!
		if(primeSet.size()==5){
			return true;
		}
		//keep searching
		for(int primeID = lastPrimeAddedID+1; primeID<primes.size();primeID++){
			long prime = primes.get(primeID);
			primeSet.add(prime);
			if(search(primeSet, primeID)){
				return true;
			}
			primeSet.remove(prime);
		}
		return false;
	}
	public static long sum(Set<Long> set){
		long sum = 0;
		for(long p: set){
			sum+=p;
		}
		return sum;
	}

	public static boolean satisfiesPrimeConcatenating(Set<Long> primeSet) {
		for (long p1 : primeSet) {
			if(!isPrime(p1)){
				return false;
			}
			for (long p2 : primeSet) {
				if (p1 == p2) {
					continue;
				}
				long newp = Long.parseLong(p1 + "" + p2);
				if (!isPrime(newp))
					return false;
			}
		}
		return true;
	}

	public static final Map<Long, Boolean> primeMap = new HashMap<>();
	public static boolean isPrime(long num) {
		if (num < 2)
			return false;
		if(primeMap.containsKey(num)){
			return primeMap.get(num);
		}
		boolean isPrime = true;
		for (long i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		primeMap.put(num,isPrime);
		return isPrime;
	}
}
