package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//SOLVED!
public class Problem96 {
	public static final File file = new File("/Users/akarshkumar0101/Developer/ProjectEuler/res/p096_sudoku.txt");

	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(Problem96.file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int threeDigitSum = 0;
		while (scan.hasNextLine()) {
			scan.nextLine();


			Suduko sud = new Suduko(scan);
			System.out.println(sud.temporaryString());
			solve(sud);
			System.out.println(sud.temporaryString());

			int threeDigitNum = 100*sud.grid[0][0]+10*sud.grid[0][1]+sud.grid[0][2];
			threeDigitSum+=threeDigitNum;


		}
		scan.close();

		System.out.println(threeDigitSum);
	}

	public static void solve(Suduko suduko){
		int[] firstBlank = suduko.nextBlank(-1,0);
		search(suduko,firstBlank[0],firstBlank[1]);
	}
	public static boolean search(Suduko suduko, int x, int y){
		Set<Integer> candidates = candidatesForBlank(suduko,x,y);

		int[] nextBlank = suduko.nextBlank(x,y);

		for(int candidate:candidates){
			suduko.grid[y][x] = candidate;
			if(nextBlank!=null) {
				//if search results in solve then return, don't do more search or set number back to 0
				if(search(suduko, nextBlank[0], nextBlank[1])){
					return true;
				}
			}
			else{
				//solved it
				return true;
			}
		}
		suduko.grid[y][x] = 0;

		return false;
	}
	public static Set<Integer> candidatesForBlank(Suduko suduko, int x, int y){
		Set<Integer> candidates = new HashSet<>(9);
		//add all possible candidate numbers
		for(int i=1;i<=9;i++){
			candidates.add(i);
		}

		//remove row consideration
		for(int xx=0;xx<9;xx++){
			candidates.remove(suduko.grid[y][xx]);
		}
		//remove column consideration
		for(int yy=0;yy<9;yy++){
			candidates.remove(suduko.grid[yy][x]);
		}
		//remove 3x3 block consideration
		int blockx = x/3, blocky=y/3;
		for(int dx=0;dx<3;dx++){
			for(int dy=0;dy<3;dy++){
				candidates.remove(suduko.grid[blocky*3+dy][blockx*3+dx]);
			}
		}

		return candidates;
	}
}

class Suduko {
	public final int[][] grid;// [y][x]

	public Suduko(String[] rows) {
		this.grid = new int[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				int num = rows[y].charAt(x) - '0';
				this.grid[y][x] = num;
			}
		}
	}

	public Suduko(Scanner scan) {
		this.grid = new int[9][9];

		for (int y = 0; y < 9; y++) {
			String row = scan.nextLine();
			for (int x = 0; x < 9; x++) {
				grid[y][x] = row.charAt(x) - '0';
			}
		}

	}

	public int[] nextBlank(int x, int y){
		x++;
		for(;y<9;y++){
			for(;x<9;x++){
				if(grid[y][x]==0){
					return new int[]{x,y};
				}
			}
			x=0;
		}
		return null;
	}
	public String temporaryString(){
		String str = "";
		for(int[] row:grid){
			for(int i:row){
				if(i!=0) {
					str += i;
				}else{
					str+='.';
				}
			}
		}

		return str;
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
				if (this.grid[y][x] != 0) {
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