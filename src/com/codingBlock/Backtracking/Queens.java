package com.codingBlock.Backtracking;

public class Queens {
	static int count = 0;

	/*
	 * 4P2
	 */
	public static void QueenPermutations(boolean[] boxes, int qsfp, int tq, String ans) {

		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		for (int i = 0; i < boxes.length; i++) {

			if (boxes[i] == false) {
				boxes[i] = true;
				QueenPermutations(boxes, qsfp + 1, tq, ans + "Q" + qsfp + "b" + i + " ");
				boxes[i] = false;
			}
		}
	}

	/*
	 * 4C2 => arrangement not matter here
	 */
	public static void QueenCombinations(boolean[] boxes, int qsfp, int tq, String ans, int lastboxused) {

		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		for (int i = lastboxused + 1; i < boxes.length; i++) {
			boxes[i] = true;
			QueenCombinations(boxes, qsfp + 1, tq, ans + "Q" + qsfp + "b" + i + " ", i);
			boxes[i] = false;

		}
	}

	/*
	 * 4C2 => arrangement not matter here
	 */
	public static void QueenCombinationsBoxRespect(boolean[] boxes, int col, int qsfp, int tq, String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Negative bc
		if (col == boxes.length) {
			return;
		}

		boxes[col] = true;
		// Placed Queen
		QueenCombinationsBoxRespect(boxes, col + 1, qsfp + 1, tq, ans + "Q" + qsfp + "b" + col + " ");
		boxes[col] = false;
		// Not Placed Queen
		QueenCombinationsBoxRespect(boxes, col + 1, qsfp, tq, ans);

	}

	/*
	 * 4C2 => arrangement not matter here
	 */
	public static void QueenCombinationsBoxRespect2D(boolean[][] boxes, int row, int col, int qsfp, int tq,
			String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Reset Row and col
		if (col == boxes[0].length) {
			row++;
			col = 0;
		}

		// Negative bc
		if (row == boxes.length) {
			return;
		}
		boxes[row][col] = true;
		// Placed Queen
		QueenCombinationsBoxRespect2D(boxes, row, col + 1, qsfp + 1, tq, ans + "{" + row + ", " + col + "}" + " ");
		boxes[row][col] = false;
		// Not Placed Queen
		QueenCombinationsBoxRespect2D(boxes, row, col + 1, qsfp, tq, ans);

	}

	/*
	 * 4C2 => arrangement not matter here
	 */
	public static void QueenCombinationsBoxRespect2DRecCall(boolean[][] boxes, int row, int col, int qsfp, int tq,
			String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Reset Row and col by call
		if (col == boxes[0].length) {
			QueenCombinationsBoxRespect2DRecCall(boxes, row + 1, 0, qsfp, tq, ans);
			return;
		}

		// Negative bc
		if (row == boxes.length) {
			return;
		}
		boxes[row][col] = true;
		// Placed Queen
		QueenCombinationsBoxRespect2DRecCall(boxes, row, col + 1, qsfp + 1, tq,
				ans + "{" + row + ", " + col + "}" + " ");
		boxes[row][col] = false;
		// Not Placed Queen
		QueenCombinationsBoxRespect2DRecCall(boxes, row, col + 1, qsfp, tq, ans);

	}

	public static void QueenCombinationsBoxRespect2DKill(boolean[][] boxes, int row, int col, int qsfp, int tq,
			String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Reset Row and col
		if (col == boxes[0].length) {
			row++;
			col = 0;
		}

		// Negative bc
		if (row == boxes.length) {
			return;
		}

		if (itISSafeToPlaceQueen(boxes, row, col)) {
			boxes[row][col] = true;
			// Placed Queen
			QueenCombinationsBoxRespect2DKill(boxes, row, col + 1, qsfp + 1, tq,
					ans + "{" + row + ", " + col + "}" + " ");
			boxes[row][col] = false;
		}
		// Not Placed Queen
		QueenCombinationsBoxRespect2DKill(boxes, row, col + 1, qsfp, tq, ans);

	}

	public static void nQueen(boolean[][] boxes, int row, int col, int qsfp, int tq, String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Reset Row and col
		if (col == boxes[0].length) {
			row++;
			col = 0;
		}

		// Negative bc
		if (row == boxes.length) {
			return;
		}

		if (itISSafeToPlaceQueen(boxes, row, col)) {
			boxes[row][col] = true;
			// Placed Queen
			nQueen(boxes, row + 1, 0, qsfp + 1, tq, ans + "{" + row + ", " + col + "}" + " ");
			boxes[row][col] = false;
		}
		// Not Placed Queen
		nQueen(boxes, row, col + 1, qsfp, tq, ans);

	}

	public static void nKnight(boolean[][] boxes, int row, int col, int ksfp, int tq, String ans) {

		// Postive bc always first
		if (ksfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		// Reset Row and col
		if (col == boxes[0].length) {
			row++;
			col = 0;
		}

		// Negative bc
		if (row == boxes.length) {
			return;
		}

		if (itISSafeToPlaceKnight(boxes, row, col)) {
			boxes[row][col] = true;
			// Placed
			nKnight(boxes, row, col + 1, ksfp + 1, tq, ans + "{" + row + ", " + col + "}" + " ");
			boxes[row][col] = false;
		}
		// Not Placed
		nKnight(boxes, row, col + 1, ksfp, tq, ans);

	}

	private static boolean itISSafeToPlaceKnight(boolean[][] boxes, int row, int col) {
		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {

			int r = row + rowArr[i];
			int c = col + colArr[i];
			if (r >= 0 && r < boxes.length && c >= 0 && c < boxes[0].length) {
				if (boxes[r][c]) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean itISSafeToPlaceQueen(boolean[][] boxes, int row, int col) {

		int r = row - 1;
		int c = col;

		// Vertical Check
		while (r >= 0) {
			if (boxes[r][c]) {
				return false;
			}
			r--;
		}

		// Horizontal Check
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (boxes[r][c]) {
				return false;
			}
			c--;
		}

		// diagonal left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (boxes[r][c]) {
				return false;
			}
			r--;
			c--;
		}

		// diagonal Right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < boxes[0].length) {
			if (boxes[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}

	/*
	 * 4^4
	 */
	public static void NQueenPermutations(boolean[][] boxes, int row, int qsfp, int tq, String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}
		// Negative bc
		if (row == boxes.length) {
			return;
		}
		for (int col = 0; col < boxes[0].length; col++) {

			boxes[row][col] = true;
			// Placed Queen
			NQueenPermutations(boxes, row + 1, qsfp + 1, tq, ans + "{" + row + ", " + col + "}" + " ");
			boxes[row][col] = false;
		}

	}

	public static void KQueenPermutations(boolean[][] boxes, int row, int qsfp, int tq, String ans) {

		// Postive bc always first
		if (qsfp == tq) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}
		// Negative bc
		if (row == boxes.length) {
			return;
		}
		for (int col = 0; col < boxes[0].length; col++) {
			if (itISSafeToPlaceQueen(boxes, row, col)) {
				boxes[row][col] = true;
				// Placed Queen
				KQueenPermutations(boxes, row + 1, qsfp + 1, tq, ans + "{" + row + ", " + col + "}" + " ");
				boxes[row][col] = false;
			}
		}
		KQueenPermutations(boxes, row + 1, qsfp, tq, ans);

	}

	public static void BlockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			count++;
			System.out.println(count + " " + ans);
			return;
		}

		if (row == -1 || row == maze.length || col == -1 || col == maze[0].length || maze[row][col] == 1
				|| visited[row][col] == true) {
			return;
		}
		visited[row][col] = true;
		// Down
		BlockedMaze(maze, row + 1, col, ans + "D", visited);
		// Up
		BlockedMaze(maze, row - 1, col, ans + "U", visited);
		// Left
		BlockedMaze(maze, row, col - 1, ans + "L", visited);
		// right
		BlockedMaze(maze, row, col + 1, ans + "R", visited);
		
		visited[row][col] = false;

	}

	public static void main(String[] args) {
		QueenPermutations(new boolean[4], 0, 2, "");
		System.out.println("----------------------------");
		count = 0;
		QueenCombinations(new boolean[4], 0, 2, "", -1);
		System.out.println("----------------------------");
		count = 0;
		QueenCombinationsBoxRespect(new boolean[4], 0, 0, 2, "");
		System.out.println("----------------------------");
		count = 0;
		QueenCombinationsBoxRespect2D(new boolean[2][2], 0, 0, 0, 2, "");
		System.out.println("----------------------------");
		count = 0;
		QueenCombinationsBoxRespect2DRecCall(new boolean[2][2], 0, 0, 0, 2, "");
		System.out.println("----------------------------");
		count = 0;
		QueenCombinationsBoxRespect2DKill(new boolean[3][4], 0, 0, 0, 3, "");
		System.out.println("----------------------------");
		count = 0;
		nQueen(new boolean[4][4], 0, 0, 0, 4, "");
		System.out.println("----------------------------");
		count = 0;
		nKnight(new boolean[3][3], 0, 0, 0, 3, "");
		System.out.println("----------------------------");
		count = 0;
		NQueenPermutations(new boolean[4][4], 0, 0, 4, "");
		System.out.println("----------------------------");
		count = 0;
		KQueenPermutations(new boolean[4][4], 0, 0, 3, "");
		System.out.println("----------------------------");
		count = 0;
		int[][] maze = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		BlockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
	}

}
