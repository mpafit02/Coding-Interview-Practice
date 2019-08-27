
public class SudokuBacktracking {

	public static boolean checkRow(int[][] board, int N, int row) {
		boolean[] nums = new boolean[10];
		for (int i = 0; i < N; i++) {
			if (nums[board[row][i]] == true && board[row][i] != 0) {
				return false;
			}
			nums[board[row][i]] = true;
		}
		return true;
	}

	public static boolean checkColumn(int[][] board, int N, int column) {
		boolean[] nums = new boolean[10];
		for (int i = 0; i < N; i++) {
			if (nums[board[i][column]] == true && board[i][column] != 0) {
				return false;
			}
			nums[board[i][column]] = true;
		}
		return true;
	}

	public static boolean checkSquare(int[][] board, int num, int row, int col) {
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean solveSudoku(int[][] board, int N) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
//		System.out.println(row + " " + col);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				System.out.println(i + " " + j + " " + board[i][j] );
				if (board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}
//		System.out.println(row + " " + col);
		if (isEmpty) {
			return true;
		}
		for (int num = 1; num <= N; num++) {
			if (checkRow(board, N, row) && checkColumn(board, N, col) && checkSquare(board, num, row, col)) {
				board[row][col] = num;
				if (solveSudoku(board, N)) {
					return true;
				} else {
					board[row][col] = 0;
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

	public static void main(String args[]) {
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;
		System.out.println("Before");
		print(board, N); // print solution
		System.out.println("After");
		if (solveSudoku(board, N)) {
			print(board, N); // print solution
		} else {
			System.out.println("No solution");
		}
	}
}
