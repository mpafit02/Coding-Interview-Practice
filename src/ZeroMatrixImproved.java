/**
 * The algorithm finds all the zeros in an array and replaces the row and the
 * column of the zero with zeros. First it finds all the zeros an assign them in
 * the first row and column. Then it passes from the first row and column and
 * assigns the zeros to the rest of the matrix. In the case that it had zeros in
 * the first row and column from the beginning it stores it in two boolean
 * variables to replace the first row and column with zeros at the end. Time
 * Complexity is O(NxM) and Space Complexity is O(1)
 * 
 * @author Marios
 *
 */
public class ZeroMatrixImproved {

	public static void print(int[][] matrix, int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void generateRandomNumbers(int[][] matrix, int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
	}

	public static void setZeroRow(int[][] matrix, int N, int i) {
		for (int j = 0; j < N; j++) {
			matrix[i][j] = 0;
		}
	}

	public static void setZeroCol(int[][] matrix, int M, int j) {
		for (int i = 0; i < M; i++) {
			matrix[i][j] = 0;
		}
	}

	public static void main(String[] args) {
		int M = 6;
		int N = 8;
		int[][] matrix = new int[M][N];
		generateRandomNumbers(matrix, M, N);
		// Original
		System.out.println("\nOriginal\n");
		print(matrix, M, N);

		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;

		// Find if the first row has zeros
		for (int j = 0; j < N; j++) {
			if (matrix[0][j] == 0) {
				firstRowHasZero = true;
			}
		}
		// Find if the first column has zeros
		for (int i = 0; i < M; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
			}
		}
		// Find the zeros and assign them in the first row and column
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Set the zeros based on the first column
		for (int i = 0; i < M; i++) {
			if (matrix[i][0] == 0) {
				setZeroRow(matrix, N, i);
			}
		}

		// Set the zeros based on the first column
		for (int j = 0; j < N; j++) {
			if (matrix[0][j] == 0) {
				setZeroCol(matrix, M, j);
			}
		}

		// Set the first row to zero if it had zeros
		if (firstRowHasZero) {
			setZeroRow(matrix, N, 0);
		}

		// Set the first column to zero if it had zeros
		if (firstColHasZero) {
			setZeroCol(matrix, M, 0);
		}
		System.out.println("\nZero Matrix\n");
		print(matrix, M, N);
	}

}
