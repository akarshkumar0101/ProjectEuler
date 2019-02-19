package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import array.Arrays;
import array.DoubleArrays;
import data.function.DoubleFunction1D;

public class Problem67 {
	public static final File triFile = new File(
			"C:\\Users\\akars\\Documents\\Programming\\Project Euler Workspace\\Project Euler\\res\\p067_triangle.txt");

	public static void main(String[] args) {
		double[][] tri = Problem67.loadTriangle(Problem67.triFile, 100);
		System.out.println(Problem67.dijk(tri));
	}

	public static double[][] loadTriangle(File file, int height) {

		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		double[][] tri = new double[height][];
		for (int h = 0; h < height; h++) {
			String[] dbs = scan.nextLine().split(" ");
			tri[h] = new double[dbs.length];
			for (int i = 0; i < dbs.length; i++) {
				tri[h][i] = Double.parseDouble(dbs[i]);
			}
		}
		return tri;
	}

	public static double dijk(double[][] tri) {
		double[][] map = DoubleArrays.performFunction(tri, new DoubleFunction1D() {
			@Override
			public double evaluate(double inp) {
				return 0;
			}
		});
		map[0][0] = tri[0][0];
		for (int h = 0; h < tri.length - 1; h++) {
			for (int i = 0; i < tri[h].length; i++) {
				double current = map[h][i];
				double next1 = current + tri[h + 1][i], next2 = current + tri[h + 1][i + 1];

				if (map[h + 1][i] < next1) {
					map[h + 1][i] = next1;
				}
				if (map[h + 1][i + 1] < next2) {
					map[h + 1][i + 1] = next2;
				}
			}
		}

		int mi = DoubleArrays.maxi(Arrays.lastElement(map));
		return Arrays.lastElement(map)[mi];
	}

}
