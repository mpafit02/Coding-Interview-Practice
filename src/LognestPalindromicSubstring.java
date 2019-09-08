
public class LognestPalindromicSubstring {
	/**
	 * Checks if a given string is Plaindrome O(N)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Finds the longest substring palindrome Brute Force Solution O(N^3)
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int max = 0;
		String longest = "";
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				if (sub.length() > max && isPalindrome(sub)) {
					longest = sub;
					max = sub.length();
				}
			}
		}
		return longest;
	}

	/**
	 * Finds the longest substring palindrome Longest Common Substring solution
	 * O(N^2) - Not always working
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindromeImproved(String s) {
		String reversed = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed += s.charAt(i);
		}
		System.out.println();
		System.out.println("Original: " + s);
		System.out.println("Reversed: " + reversed);
		int temp;
		int temp_j;
		String common = "";
		String max_common = "";
		for (int i = 0; i < s.length(); i++) {
			common = "";
			temp = i;
			System.out.println();
			temp_j = 0;
			for (int j = 0; j < s.length(); j++) {
				if (temp < s.length() && s.charAt(temp) == reversed.charAt(j)) {
					common += s.charAt(temp);
					if (common.length() > max_common.length() && temp - common.length() + 1 == s.length() - 1 - j) {
						max_common = common;
						System.out.println("Max Common: " + max_common);
					}
					System.out.println(temp + " " + j + " " + (temp - common.length() + 1) + " " + (s.length() - 1 - j)
							+ " " + common);
					temp++;
				} else {
					common = "";
					temp = i;
					j = temp_j;
					temp_j++;
				}
			}
		}
		return max_common;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome("aab"));
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("aabbaa"));
		System.out.println();
		System.out.println(longestPalindrome("abcdefg"));
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindromeImproved("abcdefg"));
		System.out.println(longestPalindromeImproved("babad"));
		System.out.println(longestPalindromeImproved("cbbd"));
		System.out.println(longestPalindromeImproved("abacdfgdcaba"));
		System.out.println(longestPalindromeImproved("aaabaaaa"));
	}

}
