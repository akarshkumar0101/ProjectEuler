package main;

import java.util.ArrayList;
import java.util.List;

public class Problem44 {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i < 100000; i++) {
			nums.add(i * (3 * i - 1) / 2);
		}
		System.out.println(nums.get(2166)-nums.get(1019)); //derived from following loop:
		for (int x = 0; x < nums.size(); x++) {
			for (int y = 0; y < x; y++) {
				if (x % 100 == 0 && y == 0)
					System.out.println(x + " " + y);
				int xx = nums.get(x), yy = nums.get(y);
				if (nums.contains(xx + yy) && nums.contains(xx - yy)) {
					System.out.println(x + " " + y);
				}
			}
		}
	}

}
