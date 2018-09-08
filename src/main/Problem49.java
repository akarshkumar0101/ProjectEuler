package main;

import java.util.ArrayList;
import java.util.List;

import array.Arrays;

public class Problem49 {

	public static void main(String[] args) {
		for (byte a = 0; a < 10; a++) {
			for (byte b = 0; b < 10; b++) {
				for (byte c = 0; c < 10; c++) {
					for (byte d = 0; d < 10; d++) {
						List<Integer> list = getScrambledPrimes(a, b, c, d);
						if (list.size() >= 3) {
							//System.out.println(list.get(0));
							for (int x : list) {
								for (int y : list) {
									if (y >= x)
										continue;
									int diff = x - y;
									if (list.contains(x + diff)) {
										System.out.println(y + " " + x + " " + (x + diff));
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static List<Integer> getScrambledPrimes(byte a, byte b, byte c, byte d) {
		List<Integer> list = new ArrayList<>();
		Byte[] fixed = new Byte[] {}, more = new Byte[] { a, b, c, d };
		appendList(list, fixed, more);
		return list;
	}

	public static void appendList(List<Integer> list, Byte[] fixed, Byte[] more) {
		if (more.length == 1) {
			String str = "";
			for (byte b : fixed) {
				str += b;
			}
			str += more[0];
			int i = Integer.parseInt(str);
			if (i >= 1000 && Prime.isPrime(i))
				list.add(i);
			return;
		}
		for (byte b : more) {
			appendList(list, Arrays.append(fixed, b), Arrays.remove(more, b));
		}
	}

}
