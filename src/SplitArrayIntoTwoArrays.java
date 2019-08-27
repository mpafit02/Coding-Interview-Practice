import java.util.ArrayList;

/**
 * This script assigns load into to two servers. It tries to have as similar
 * load as possible on each server. The time complexity is O(n^2). It should be
 * improved in the future.
 * 
 * @author Marios
 *
 */
public class SplitArrayIntoTwoArrays {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 6, 7, 8, 10, 20, 20 };
		int[] C = { 5, 4, 3, 2, 1, 2, 3, 4, 5 };
		int[] D = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 10, 20, 20 };
		int[] E = { 20, 20, 19, 10, 5, 6, 7, 13 };
		int[] F = { 20, 20, 19, 10, 8, 6, 13 };
		int[] G = { 1, 20, 5, 10, 20, 10, 2, 4 };
		splitArray(A);
		splitArray(B);
		splitArray(C);
		splitArray(D);
		splitArray(E);
		splitArray(F);
		splitArray(G);
	}

	public static void splitArray(int[] A) {

		System.out.print("\n\n--Split Array: ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");

		ArrayList<Integer> server1 = new ArrayList<>();
		ArrayList<Integer> server2 = new ArrayList<>();

		int sum1 = 0;
		int sum2 = 0;

		// Sort the array O(nlogn) Time Complexity
		QuickSort qs = new QuickSort();
		qs.sort(A, 0, A.length - 1);

		System.out.print("Sorted Array: ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\n");

		for (int i = A.length - 1; i >= 0; i--) {
			if (sum2 > sum1) {
				server1.add(A[i]);
				sum1 += A[i];
			} else {
				server2.add(A[i]);
				sum2 += A[i];
			}
		}

		System.out.println("Server 1: " + server1 + " Load: " + sum1);
		System.out.println("Server 2: " + server2 + " Load: " + sum2);
		// There is space for improvement in case that the difference is grater than 1
		if (Math.abs(sum1 - sum2) > 1) {
			System.out.println("Improve it!");
			int i = 0;
			int j = 0;
			boolean changed = false;
			for (int num1 : server1) {
				j = 0;
				for (int num2 : server2) {
					if (sum1 > sum2) {
						if (!changed && num1 - num2 > 0 && num1 - num2 <= sum1 - sum2) {
							System.out.println("Swap: " + num1 + " " + num2);
							sum1 = sum1 - num1 + num2;
							sum2 = sum2 - num2 + num1;
							server1.set(i, num2);
							server2.set(j, num1);
							changed = true;
						}
					} else {
						if (!changed && num2 - num1 > 0 && num2 - num1 <= sum2 - sum1) {
							System.out.println("Swap: " + num1 + " " + num2);
							sum1 = sum1 - num1 + num2;
							sum2 = sum2 - num2 + num1;
							server1.set(i, num2);
							server2.set(j, num1);
							changed = true;
						}
					}
					j++;
				}
				i++;
			}

			System.out.println("Server 1: " + server1 + " Load: " + sum1);
			System.out.println("Server 2: " + server2 + " Load: " + sum2);
		}

	}
}
