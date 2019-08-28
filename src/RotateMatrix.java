/**
 * This class rotates a matrix without using extra array in Time Complexity
 * O(N^2)
 * 
 * @author Marios
 *
 */
public class RotateMatrix {

	public static void print(int[][] matrix, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rotate90degrees(int[][] matrix, int N) {
		int new_N = (int) N / 2;
		if (N % 2 != 0) {
			new_N = (int) N / 2 + 1;
		}
		for (int i = 0; i < new_N; i++) {
			for (int j = 0; j < (int) N / 2; j++) {
				// Flip 4 numbers;
				int x = i;
				int y = j;
				int src = matrix[x][y];
				for (int k = 0; k < 4; k++) {
					int z = N - 1 - x;
					int dest = matrix[y][z];
					matrix[y][z] = src;
					x = y;
					y = z;
					src = dest;
				}
			}
		}
	}

	public static void main(String[] args) {
		int N = 10;
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = i;
			}
		}
		System.out.println("Original Matrix");
		// Before Rotation
		print(matrix, N);

		rotate90degrees(matrix, N);

		System.out.println("Rotate 90 degrees:");
		// After Rotation
		print(matrix, N);

		rotate90degrees(matrix, N);

		System.out.println("Rotate 90 degrees:");
		// After Rotation
		print(matrix, N);

		rotate90degrees(matrix, N);

		System.out.println("Rotate 90 degrees:");
		// After Rotation
		print(matrix, N);

		rotate90degrees(matrix, N);

		System.out.println("Rotate 90 degrees:");
		// After Rotation
		print(matrix, N);
	}

}
