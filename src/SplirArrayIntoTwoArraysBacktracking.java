import java.util.ArrayList;

/**
 * This is the backtracking solution for contributing the oad between two
 * servers. This method is completely correct!
 * 
 * @author Marios
 *
 */
public class SplirArrayIntoTwoArraysBacktracking {

	public static int min = 10000;
	public static int min_sum1 = 0;
	public static int min_sum2 = 0;
	public static String min_s1;
	public static String min_s2;

	public static void main(String args[]) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 5, 4, 3, 2, 1 };
		int[] C = { 5, 4, 3, 2, 1, 2, 3, 4, 5 };
		int[] D = { 1, 1, 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 10, 20, 20 };
		int[] E = { 20, 20, 19, 10, 5, 6, 7, 13 };
		int[] F = { 20, 20, 19, 10, 8, 6, 13 };
		int[] G = { 1, 20, 5, 10, 20, 10, 2, 4 };
		int[] H = { 11, 7, 40, 19, 50, 5, 30 };
		int[] J = { 6, 7, 8, 10, 20, 20 };
		int[] K = { 1, 1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 10, 20, 20, 11, 7, 40, 19, 50, 5, 30, 8, 10};

		splitArray(A);
		splitArray(B);
		splitArray(C);
		splitArray(D);
		splitArray(E);
		splitArray(F);
		splitArray(G);
		splitArray(H);
		splitArray(J);
		splitArray(K);

	}

	public static void splitArray(int[] A) {
		min = 10000;
		min_s1 = "";
		min_s2 = "";
		min_sum1 = 0;
		min_sum2 = 0;
		ArrayList<Integer> s1 = new ArrayList<>();
		ArrayList<Integer> s2 = new ArrayList<>();
		long startTime = System.nanoTime();
		splitArrayRec(A, s1, s2, 0, 0, 0);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("\n\nMin S1: " + min_s1 + "\nMin S2: " + min_s2);
		System.out.println("Min Sum1: " + min_sum1 + " Min Sum2: " + min_sum2 + " --> Min Total: " + min);
		System.out.printf("\nExecution time in milliseconds : %.2f", (float) timeElapsed / 1000000);
	}

	/**
	 * Splits the array recursively. It backtracks all the possible solutions and it
	 * returns the minimum one. Optimization, it could stop when reaches min == 0.
	 * 
	 * @param A
	 * @param s1
	 * @param s2
	 * @param sum1
	 * @param sum2
	 * @param i
	 */
	public static void splitArrayRec(int[] A, ArrayList<Integer> s1, ArrayList<Integer> s2, int sum1, int sum2, int i) {
		// We found one optimal solution
		if (min == 0) {
			return;
		}
		// termination
		if (i == A.length) {

			if (Math.abs(sum1 - sum2) < min) {
				min = Math.abs(sum1 - sum2);
				min_sum1 = sum1;
				min_sum2 = sum2;
				min_s1 = s1.toString();
				min_s2 = s2.toString();
			}

			return;
		}

		s1.add(A[i]);
		sum1 += A[i];

//		System.out.println("\n+Sum1 = " + sum1 + " Sum2 = " + sum2);
//		System.out.println("S1: " + s1 + "  S2: " + s2);

		// Recursive Method
		splitArrayRec(A, s1, s2, sum1, sum2, i + 1);

		// For optimization
		if (min == 0) {
			return;
		}

		if (s1.contains(A[i])) {
			s1.remove(s1.indexOf(A[i]));
			sum1 -= A[i];
		}

		s2.add(A[i]);
		sum2 += A[i];

//		System.out.println("\n-Sum1 = " + sum1 + " Sum2 = " + sum2);
//		System.out.println("S1: " + s1 + "  S2: " + s2);

		// Recursive Method
		splitArrayRec(A, s1, s2, sum1, sum2, i + 1);
		// For optimization
		if (min == 0) {
			return;
		}

		if (s2.contains(A[i])) {
			s2.remove(s2.indexOf(A[i]));
			sum2 -= A[i];
		}
	}

}
