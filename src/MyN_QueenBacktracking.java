/**
 * This class solves the N Queen problem with the backtracking algorithm. It
 * finds all the possible solutions for a specific input 1 <= N <= 10
 * 
 * @author Marios
 *
 */
public class MyN_QueenBacktracking {

	public static boolean isSafe(int[][] board, int N, int row, int col) {
		boolean horizontal = true;
		boolean vertical = true;
		boolean r_diagonal = true;
		boolean l_diagonal = true;

		// Check horizontal
		for (int i = 0; i < N; i++) {
			if (board[row][i] != 0) {
				horizontal = false;
				break;
			}
		}

		// Check vertical
		for (int i = 0; i < N; i++) {
			if (board[i][col] != 0) {
				vertical = false;
				break;
			}
		}

		// Check right diagonal
		int i = 0;
		while (row + i < N && col + i < N) {
			if (board[row + i][col + i] != 0) {
				r_diagonal = false;
				break;
			}
			i++;
		}
		i = -1;
		while (row + i >= 0 && col + i >= 0) {
			if (board[row + i][col + i] != 0) {
				l_diagonal = false;
				break;
			}
			i--;
		}

		// Check left diagonal
		i = 0;
		while (row + i < N && col - i >= 0) {
			if (board[row + i][col - i] != 0) {
				r_diagonal = false;
				break;
			}
			i++;
		}
		i = -1;
		while (row + i >= 0 && col - i < N) {
			if (board[row + i][col - i] != 0) {
				l_diagonal = false;
				break;
			}
			i--;
		}

		return horizontal && vertical && r_diagonal && l_diagonal;

	}

	public static boolean solveNQueenRec(int[][] board, int N, int Queens) {
		// All the Queens are placed
		if (Queens == 0) {
			return true;
		}
		int row = -1;
		int col = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;
					if (isSafe(board, N, row, col)) {
						board[row][col] = 1;
						if (solveNQueenRec(board, N, Queens - 1)) {
							return true;
						} else {
							board[row][col] = 0;
						}
					}
				}
			}
		}
		return false;
	}

	public static void print(int[][] board, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void initializeArray(int[][] board, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static boolean containsSolution(int[][][] solutions, int[][] board, int N) {
		for (int k = 0; k < N; k++) {
			boolean same = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (solutions[k][i][j] != board[i][j]) {
						same = false;
					}
				}
			}
			if (same) {
				return true;
			}
		}
		return false;
	}

	public static void addSolution(int[][][] solutions, int[][] board, int N, int solved) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solutions[solved][i][j] = board[i][j];
			}
		}
	}

	public static void solveNQueen(int N) {
		int[][] board = new int[N][N];
		// Initialize with zeros the board
		initializeArray(board, N);
		System.out.println("\nBefore\n");
		System.out.println("N Queen: " + N + " x " + N + " puzzle");
		print(board, N);
		System.out.println("\nAfter\n");
		int[][][] solutions = new int[N * N][N][N];
		int solved = 0;
		// Solve the N Queen puzzle
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				initializeArray(board, N);
				board[i][j] = 1;
				if (solveNQueenRec(board, N, N - 1)) {
					if (!containsSolution(solutions, board, N)) {
						addSolution(solutions, board, N, solved);
						solved++;
					}
				}
			}
		}
		if (solved == 0) {
			System.out.println("No solutions!");
		} else {
			for (int i = 0; i < solved; i++) {
				System.out.println("Solution: " + (i + 1) + "\n");
				print(solutions[i], N);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int N = 4;
		solveNQueen(N);
	}
}
