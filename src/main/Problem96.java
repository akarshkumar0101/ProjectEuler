package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem96 {
	public static final File file = new File("/Users/akarshkumar0101/Programming/ProjectEuler/res/p096_sudoku.txt");

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(Problem96.file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			scan.nextLine();
			String[] rows = new String[9];
			for (int i = 0; i < 9; i++) {
				rows[i] = scan.nextLine();
			}
			Suduko sud = new Suduko(rows);
			System.out.println(sud);

			sud.solve();
			System.out.println(sud);
		}
		scan.close();
	}

}

class Suduko {
	private final Object[][] grid;// [y][x]

	public Suduko(String[] rows) {
		this.grid = new Object[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				int num = rows[y].charAt(x) - '0';
				if (num != 0) {
					this.grid[y][x] = num;
				} else {
					this.grid[y][x] = Suduko.getGuessesList();
				}
			}
		}
	}

	public void solve() {
		while (!this.isSolved()) {
			System.out.println(this);
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					this.solve(y, x);
				}
			}
		}
	}

	public void solve(int y, int x) {
		if (this.grid[y][x] instanceof Integer)
			return;

		List<Integer> list = (List<Integer>) this.grid[y][x];

		int gy = y / 3 * 3;
		int gx = x / 3 * 3;

		for (int xx = 0; xx < 9; xx++) {
			list.remove(this.grid[y][xx]);
		}
		for (int yy = 0; yy < 9; yy++) {
			list.remove(this.grid[yy][x]);
		}
		for (int yy = gy; yy < gy + 3; yy++) {
			for (int xx = gx; xx < gx + 3; xx++) {
				list.remove(this.grid[yy][xx]);
			}
		}
		if (list.size() == 1) {
			this.grid[y][x] = list.get(0);
		}

	}

	public boolean isSolved() {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (!(this.grid[y][x] instanceof Integer))
					return false;
			}
		}
		return true;
	}

	public static List<Integer> getGuessesList() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		return list;
	}

	@Override
	public String toString() {
		String str = "";

		for (int y = 0; y < 9; y++) {
			if (y % 3 == 0) {
				str += "-------------\n";
			}
			for (int x = 0; x < 9; x++) {
				if (x % 3 == 0) {
					str += "|";
				}
				if (this.grid[y][x] instanceof Integer) {
					str += this.grid[y][x];
				} else {
					str += "?";
				}
			}
			str += "|\n";
		}
		str += "-------------\n\n";

		return str;
	}
}