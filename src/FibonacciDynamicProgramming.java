/**
 * Dynamic Fibonacci implementation and compare with the normal recursive
 * solution
 * 
 * @author Marios
 *
 */
public class FibonacciDynamicProgramming {

	public static void main(String[] args) {

		for (int n = 1; n <= 10; n++) {
			System.out.println();
			long startTime = System.nanoTime();
			System.out.println("Fibo " + n + " = " + fib_normal(n));
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.printf("\nExecution time in milliseconds : %.2f\n\n", (float) timeElapsed / 1000000);

			startTime = System.nanoTime();
			System.out.println("Fibo " + n + " = " + fib_fast(n));
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			System.out.printf("\nExecution time in milliseconds : %.2f\n\n", (float) timeElapsed / 1000000);
		}
	}

	/**
	 * This method implements the normal recursive fibonacci solution
	 * 
	 * @param n
	 * @return
	 */
	public static int fib_normal(int n) {
		int result;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = fib_normal(n - 1) + fib_normal(n - 2);
		}
		return result;
	}

	/**
	 * This method implements the dynamic fibonacci solution which uses an array to
	 * store already calculated fibonaccies
	 * 
	 * @param n
	 * @return
	 */
	public static int fib_fast(int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			memo[i] = -1;
		}
		return fib_fast_rec(n, memo);
	}

	private static int fib_fast_rec(int n, int[] memo) {
		if (memo[n] != -1) {
			return memo[n];
		}
		int result;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = fib_fast_rec(n - 1, memo) + fib_fast_rec(n - 2, memo);
		}
		return result;
	}
}
