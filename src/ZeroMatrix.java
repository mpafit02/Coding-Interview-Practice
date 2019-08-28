
/**
 * This algorithms finds all the zeros in a matrix and replaces all the column and row to zeros. Time Complexity is O(MxN) and Space Complexity is O(MxN)
 */
import java.util.HashSet;

public class ZeroMatrix {

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

	public static void main(String[] args) {
		int M = 13;
		int N = 20;
		int[][] matrix = new int[M][N];
		generateRandomNumbers(matrix, M, N);
		// Original
		System.out.println("\nOriginal\n");
		print(matrix, M, N);

		HashSet<Integer> row = new HashSet<>();
		HashSet<Integer> col = new HashSet<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		// Change the rows
		for (Object n : row.toArray()) {
			for (int j = 0; j < N; j++) {
				matrix[(int) n][j] = 0;
			}
		}

		// Change the columns
		for (Object n : col.toArray()) {
			for (int i = 0; i < M; i++) {
				matrix[i][(int) n] = 0;
			}
		}
		System.out.println("\nZero Matrix\n");
		print(matrix, M, N);
	}

}
