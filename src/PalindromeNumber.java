/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true
 * 
 * Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 * 
 * Time Complexity O(N) where N is the number of digits of the integer.
 * @author Marios
 *
 */
public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int reverse = 0;
		int temp = x;
		while (temp != 0) {
			reverse *= 10;
			reverse += temp % 10;
			temp /= 10;
		}
		if (reverse - x == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int x = 121;
		System.out.println("Is " + x + " palindrome? " + isPalindrome(x));
		x = -121;
		System.out.println("Is " + x + " palindrome? " + isPalindrome(x));
		x = 10;
		System.out.println("Is " + x + " palindrome? " + isPalindrome(x));
	}

}
