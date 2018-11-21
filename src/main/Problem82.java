package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem82 {

	public static final File matrixFile = new File(
			"/Users/akarshkumar0101/Programming/ProjectEuler/res/p082_matrix.txt");

	public static void main(String[] args) {
		int[][] matrix = loadMatrix(matrixFile);
		long[][] minSum = new long[80][80];

		for (int y = 0; y < 80; y++) {
			for (int x = 0; x < 80; x++) {
				minSum[y][x] = Long.MAX_VALUE;
			}
		}

		for (int y = 0; y < 80; y++) {
			minSum[y][0] = matrix[y][0];
		}

		for (int x = 0; x < 80; x++) {
			for (int y = 0; y < 80; y++) {
				if (y != 0) { // update up cell
					minSum[y - 1][x] = Math.min(minSum[y - 1][x], minSum[y][x] + matrix[y - 1][x]);
				}
				if (y != 79) { // update down cell
					minSum[y + 1][x] = Math.min(minSum[y + 1][x], minSum[y][x] + matrix[y + 1][x]);
				}
				if (x != 79) { // update right
					minSum[y][x + 1] = Math.min(minSum[y][x + 1], minSum[y][x] + matrix[y][x + 1]);
				}
			}
			for (int y = 79; y >= 0; y--) {
				if (y != 0) { // update up cell
					minSum[y - 1][x] = Math.min(minSum[y - 1][x], minSum[y][x] + matrix[y - 1][x]);
				}
				if (y != 79) { // update down cell
					minSum[y + 1][x] = Math.min(minSum[y + 1][x], minSum[y][x] + matrix[y + 1][x]);
				}
				if (x != 79) { // update right
					minSum[y][x + 1] = Math.min(minSum[y][x + 1], minSum[y][x] + matrix[y][x + 1]);
				}
			}
		}
		long min = Long.MAX_VALUE;
		for (int y = 0; y < 80; y++) {
			long num = minSum[y][79];
			if (num < min) {
				min = num;
			}
		}
		System.out.println(min);
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
