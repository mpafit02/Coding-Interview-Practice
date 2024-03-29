/**
 * This class implements an algorithm for reversing integers in Time Complexity
 * O(N) where N is the length of the integer. Also, it checks if we have
 * overflow and returns zero if it is true.
 * 
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321
 * 
 * Example 2:
 * 
 * Input: -123 Output: -321
 * 
 * Example 3:
 * 
 * Input: 120 Output: 21
 * 
 * Note: Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [-2^31, 2^31 - 1]. For the
 * purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * @author Marios
 *
 */
public class ReverseInteger {
	public static int reverse(int x) {
		long reverse = 0;
		while (x != 0) {
			reverse *= 10;
			reverse += x % 10;
			x /= 10;
		}
		if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) reverse;
	}

	public static void main(String[] args) {
		int input = 123;
		System.out.println("\nInput: " + input);
		System.out.println("Output: " + reverse(input));

		input = -123;
		System.out.println("\nInput: " + input);
		System.out.println("Output: " + reverse(input));

		input = 120;
		System.out.println("\nInput: " + input);
		System.out.println("Output: " + reverse(input));
	}

}
