package main;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem29 {

	private static final List<BigInteger> numbers = new ArrayList<>();
	
	public static void main(String[] args) {
		for(int a=2; a<=100;a++) {
			for(int b=2; b<=100;b++) {
				BigInteger num = new BigInteger(a+"").modPow(new BigInteger(b+""),new BigInteger("324324324324324234238958548957283947239874238497328947382975983475294388579843275894372598423795874329857943287598423795874239875984237598437298574329857398"));
				if(!numbers.contains(num)) {
					numbers.add(num);
				}
			}
		}
		System.out.println(numbers.size());
	}

}
