/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * Given input matrix =
 * 
 * [
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 * ]
 * 
 * rotate the input matrix in-place such that it becomes:
 * 
 * [
 *  [7,4,1],
 *  [8,5,2],
 *  [9,6,3]
 * ]
 * 
 * Example 2:
 * 
 * Given input matrix = 
 * 
 * [
 *  [ 5, 1, 9,11],
 *  [ 2, 4, 8,10],
 *  [13, 3, 6, 7],
 *  [15,14,12,16]
 * ], 
 *
 * rotate the input matrix in-place such that it becomes:
 * 
 * [
 *  [15,13, 2, 5],
 *  [14, 3, 4, 1],
 *  [12, 6, 8, 9],
 *  [16, 7,10,11]
 * ]
 *
 * @author Marios
 *
 */
public class RotateImage {
	public static int[][] rotate(int[][] matrix) {
		int N = matrix.length;
		int M = N;
		if (M % 2 != 0) {
			M++;
		}
		for (int i = 0; i < M / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				int x = i;
				int y = j;
				int z = N - 1 - x;
				int src = matrix[x][y];
				int dest = matrix[y][z];
				for (int k = 0; k < 4; k++) {
					matrix[y][z] = src;
					x = y;
					y = z;
					z = N - 1 - x;
					src = dest;
					dest = matrix[y][z];
				}
			}
		}
		return matrix;
	}

	public static void print(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Input:");
		print(matrix);

		System.out.println("Ouput:");
		print(rotate(matrix));

		System.out.println();
		int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		System.out.println("Input:");
		print(matrix2);

		System.out.println("Ouput:");
		print(rotate(matrix2));
	}

}
