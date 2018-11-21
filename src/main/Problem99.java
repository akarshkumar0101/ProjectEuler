package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem99 {
	public static final File file = new File(
			"/Users/akarshkumar0101/Programming/ProjectEuler/res/p099_base_exp.txt");

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Double> list = new ArrayList<Double>();
		while (scan.hasNextLine()) {
			String[] numstrs = scan.nextLine().split(",");
			long a = Long.parseLong(numstrs[0]);
			long b = Long.parseLong(numstrs[1]);
			double num = (long) (b*Math.log(a));
			list.add(num);
		}
		double max=-1;
		int maxi=-1;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>max) {
				max=list.get(i);
				maxi=i;
			}
		}
		System.out.println(maxi+1);
		
	}
}
