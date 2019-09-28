/**
 * Find the greatest subarray of length K from a given array.
 * 
 * @author Marios
 *
 */
public class GreatestSubarray {
	public static int[] greatestSubarray(int[] A, int K) {
		if (K > A.length) {
			int[] greatest = {};
			return greatest;
		}
		int[] greatest = new int[K];
		greatest[0] = A[0];
		int pointer = 0;
		for (int i = 1; i < A.length - K + 1; i++) {
			if (A[i] > greatest[0]) {
				greatest[0] = A[i];
				pointer = i;
			} else if (A[i] == greatest[0]) {
				for (int j = 1; j < K; j++) {
					if (A[j + i] != A[pointer + j]) {
						if (A[j + i] > A[pointer + j]) {
							System.out.println("b");
							greatest[0] = A[i];
							pointer = i;
						}
						break;
					}
				}
			}
		}
		for (int i = 0; i < K; i++) {
			greatest[i] = A[pointer];
			pointer++;
		}
		return greatest;
	}

	public static void main(String[] args) {
		int[] A = { 1, 4, 3, 2, 5 };
		for (int x = 1; x <= 5; x++) {
			int[] output = greatestSubarray(A, x);
			System.out.print("[");
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]);
				if (i != output.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
		System.out.println();

		int[] B = { 8, 8, 5, 4, 1, 8, 7, 2, 7, 9 };
		for (int x = 1; x <= 5; x++) {
			int[] output = greatestSubarray(B, x);
			System.out.print("[");
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]);
				if (i != output.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}

	}

}
