import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 *
 * Output: 3
 *
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 *
 * Output: 1
 *
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 *
 * Output: 3
 *
 * Explanation: The answer is "wke", with the length of 3. Note that the answer
 * must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		HashSet<Character> seen = new HashSet<>();
		int left = 0;
		int right = 1;
		int max = 1;
		seen.add(s.charAt(left));
		while (right < s.length()) {
			if (seen.contains(s.charAt(right))) {
				if (right - left - 1 > max) {
					max = right - left - 1;
				}
				while (s.charAt(left) != s.charAt(right)) {
					seen.remove(s.charAt(left));
					left++;
				}
				left++;
				right++;
			} else {
				seen.add(s.charAt(right));
				right++;
			}
			if (right - left > max) {
				max = right - left;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println("Input: \"" + str + "\"");
		System.out.println("Output: " + lengthOfLongestSubstring(str));
		str = "bbbbb";
		System.out.println("Input: \"" + str + "\"");
		System.out.println("Output: " + lengthOfLongestSubstring(str));
		str = "pwwkew";
		System.out.println("Input: \"" + str + "\"");
		System.out.println("Output: " + lengthOfLongestSubstring(str));
		str = "tmmzuxt";
		System.out.println("Input: \"" + str + "\"");
		System.out.println("Output: " + lengthOfLongestSubstring(str));
	}

}
