package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem81 {

	public static final File matrixFile = new File(
			"/Users/akarshkumar0101/Programming/ProjectEuler/res/p081_matrix.txt");

	public static void main(String[] args) {
		int[][] matrix = loadMatrix(matrixFile);
		long[][] minSum = new long[80][80];
		for (int y = 0; y < 80; y++) {
			for (int x = 0; x < 80; x++) {
				minSum[y][x] = Long.MAX_VALUE;
			}
		}

		minSum[0][0] = matrix[0][0];

		for (int y = 0; y < 80; y++) {
			for (int x = 0; x < 80; x++) {
				if (y == 0 && x == 0)
					continue;
				if (y != 0) { // update from up
					minSum[y][x] = Math.min(minSum[y][x], minSum[y - 1][x] + matrix[y][x]);
				}
				if (x != 0) { // update from left
					minSum[y][x] = Math.min(minSum[y][x], minSum[y][x - 1] + matrix[y][x]);
				}
			}
		}
		System.out.println(minSum[79][79]);
	}

	public static int[][] loadMatrix(File file) {
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[][] matrix = new int[80][80];

		for (int i = 0; i < 80; i++) {
			int x = 0;
			String line = scan.nextLine();
			String[] numStrs = line.split(",");
			for (String s : numStrs) {
				matrix[i][x++] = Integer.parseInt(s);
			}
		}

		scan.close();
		return matrix;
	}

}
