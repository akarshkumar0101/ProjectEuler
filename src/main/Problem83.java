package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.tuple.Tuple2D;

public class Problem83 {
	public static final File matrixFile = new File(
			"/Users/akarshkumar0101/Programming/ProjectEuler/res/p083_matrix.txt");

	public static void main(String[] args) {
		int[][] matrix = Problem83.loadMatrix(Problem83.matrixFile);
		long[][] minSum = new long[80][80];

		for (int y = 0; y < 80; y++) {
			for (int x = 0; x < 80; x++) {
				minSum[y][x] = Long.MAX_VALUE;
			}
		}
		minSum[0][0] = matrix[0][0];

		List<Tuple2D<Integer, Integer>> notCalculated = new ArrayList<>(6400);
		for (int x = 0; x < 80; x++) {
			for (int y = 0; y < 80; y++) {
				notCalculated.add(new Tuple2D<>(x, y));
			}
		}
		while (!notCalculated.isEmpty()) {
			Tuple2D<Integer, Integer> currentTuple = null;
			long leastValueTuple = Long.MAX_VALUE;
			for (Tuple2D<Integer, Integer> tup : notCalculated) {
				if (minSum[tup.getA()][tup.getB()] < leastValueTuple) {
					leastValueTuple = minSum[tup.getA()][tup.getB()];
					currentTuple = tup;
				}
			}
			int x = currentTuple.getA(), y = currentTuple.getB();
			long currentSum = minSum[x][y];
			if (x != 0) {
				long nextSum = currentSum + matrix[x - 1][y];
				if (nextSum < minSum[x - 1][y]) {
					minSum[x - 1][y] = nextSum;
				}
			}
			if (x != 79) {
				long nextSum = currentSum + matrix[x + 1][y];
				if (nextSum < minSum[x + 1][y]) {
					minSum[x + 1][y] = nextSum;
				}
			}
			if (y != 0) {
				long nextSum = currentSum + matrix[x][y - 1];
				if (nextSum < minSum[x][y - 1]) {
					minSum[x][y - 1] = nextSum;
				}
			}
			if (y != 79) {
				long nextSum = currentSum + matrix[x][y + 1];
				if (nextSum < minSum[x][y + 1]) {
					minSum[x][y + 1] = nextSum;
				}
			}

			notCalculated.remove(currentTuple);
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
