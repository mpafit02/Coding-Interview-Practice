/**
 * This is an approach that uses less space than the SudokuBacktracking.java
 * because it doesn't use extra tables to check whether the assignment of a
 * value is safe or not.
 * 
 * @author Marios
 *
 */
public class MySudokuBacktracking {

	/**
	 * Recursive method to solve the Sudoku
	 * 
	 * @param board
	 * @param N
	 * @return
	 */
	public static boolean solveSudoku(int[][] board, int N) {
		int row = -1;
		int col = -1;
		boolean isFinished = true;

		// Check for each cell if it has some value and it is not 0
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					// Get the row and the column of the 0 cell
					row = i;
					col = j;
					isFinished = false;
					break;
				}
			}
			if (!isFinished) {
				break;
			}
		}

		// If the Sudoku is solved
		if (isFinished) {
			return true;
		}

		// Try the numbers in the empty cell
		for (int n = 1; n <= N; n++) {
			// Check whether is safe to put this value in this cell
			if (isSafe(board, N, row, col, n)) {
				board[row][col] = n;
				if (solveSudoku(board, N)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	/**
	 * Method to check if we can assign the value in the specific cell
	 * 
	 * @param board
	 * @param N
	 * @param row
	 * @param col
	 * @param n
	 * @return
	 */
	public static boolean isSafe(int[][] board, int N, int row, int col, int n) {
		boolean rowOkay = true;
		boolean colOkay = true;
		boolean squareOkay = true;

		// Check if row doesn't already have the n assigned
		for (int i = 0; i < N; i++) {
			if (board[row][i] == n) {
				rowOkay = false;
				break;
			}
		}

		// Check if column doesn't already have the n assigned
		for (int i = 0; i < N; i++) {
			if (board[row][i] == n) {
				colOkay = false;
				break;
			}
		}

		// Check if square doesn't already have the n assigned
		int sqrt = (int) Math.sqrt(N);
		int startRow = row - row % sqrt;
		int startCol = col - col % sqrt;

		for (int i = startRow; i < sqrt + startRow; i++) {
			for (int j = startCol; j < sqrt + startCol; j++) {
				if (board[i][j] == n) {
					squareOkay = false;
					break;
				}
			}
		}

		return rowOkay && colOkay && squareOkay;
	}

	/**
	 * This method prints the Sudoku
	 * 
	 * @param board
	 * @param N
	 */
	public static void print(int[][] board, int N) {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;
		System.out.println("\n\nSudoku 1");
		System.out.println("\nBefore");
		print(board, N); // print solution
		System.out.println("\nAfter");
		if (solveSudoku(board, N)) {
			print(board, N); // print solution
		} else {
			System.out.println("No solution");
		}

		int[][] board2 = new int[][] { { 7, 3, 0, 8, 6, 0, 0, 0, 0 }, { 6, 0, 4, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 3, 0, 0, 4, 1 }, { 8, 1, 9, 4, 7, 0, 0, 0, 5 }, { 0, 0, 0, 2, 0, 5, 0, 0, 0 },
				{ 5, 0, 0, 0, 9, 6, 3, 8, 4 }, { 1, 4, 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 5, 0, 8 },
				{ 0, 0, 0, 0, 1, 8, 0, 2, 9 } };
		System.out.println("\n\nSudoku 2");
		System.out.println("\nBefore");
		print(board2, N); // print solution
		System.out.println("\nAfter");
		if (solveSudoku(board2, N)) {
			print(board2, N); // print solution
		} else {
			System.out.println("No solution");
		}

	}

}
