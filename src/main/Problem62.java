package main;

import java.util.ArrayList;
import java.util.List;

import math.Math;

public class Problem62 {

	public static void main(String[] args) {

	}

	public static String[] allPermutations(String arg) {
		String[] arr = new String[(int) Math.intFactorial(arg.length())];

		List<Character> chars = new ArrayList<Character>(arg.length());
		for (char c : arg.toCharArray())
			chars.add(c);
		for (int i = 0; i < arr.length; i++) {
			
		}

		return arr;
	}

}
