/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"]
 * 
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * Input: ["dog","racecar","car"]
 * 
 * Output: ""
 * 
 * Explanation: There is no common prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 * @author Marios
 *
 */
public class LongestCommonPrefix {
	/**
	 * Time Complexity is O(N*M) where N is the amount of strings and M the length
	 * of the smallest string.
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		int count = 0;
		boolean done = false;
		String prefix = "";
		char c = '\0';
		while (!done) {
			if (c != '\0') {
				prefix += c;
			}
			c = '\0';
			for (int i = 0; i < strs.length; i++) {
				System.out.println(strs[i]);
				// We reached the length of one string
				if (count >= strs[i].length()) {
					done = true;
					break;
				}
				// We found different character
				if (c != '\0' && strs[i].charAt(count) != c) {
					done = true;
					break;
				}
				c = strs[i].charAt(count);
				System.out.println(c);
			}
			count++;
		}
		return prefix;
	}

	/**
	 * Improved version. Don't create the string character by character just get the
	 * substring.
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefixImproved(String[] strs) {
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		int count = 0;
		boolean done = false;
		char c = '\0';
		char temp;
		while (!done) {
			c = '\0';
			for (int i = 0; i < strs.length; i++) {
				System.out.println(strs[i]);
				// We reached the length of one string
				if (count >= strs[i].length()) {
					done = true;
					break;
				}
				// We found different character
				temp = strs[i].charAt(count);
				if (c != '\0' && temp != c) {
					done = true;
					break;
				}
				if (c != temp) {
					c = temp;
				}
				System.out.println(c);
			}
			count++;
		}
		return strs[0].substring(0, count - 1);
	}

	/**
	 * The optimized version given as a solution to the problem.
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefixMoreImproved(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		char[] ch = strs[0].toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			for (int j = 1; j < strs.length; j++) {
				if (i > strs[j].length() - 1 || c != strs[j].charAt(i)) {
					return sb.toString();
				}
			}
			sb.append(c);
		}

		return sb.toString();
	}

	public static void longestCommonPrefixCalcualte(String[] strs) {
		System.out.print("Input: [");
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				System.out.print(" \"" + strs[i] + "\" ");
			} else {
				System.out.print(", \"" + strs[i] + "\" ");
			}
		}
		System.out.println("]");
		System.out.println("Ouptut: \"" + longestCommonPrefixImproved(strs) + "\"");
	}

	public static void main(String[] args) {
		String strs[] = { "flower", "flow", "flight" };
		longestCommonPrefixCalcualte(strs);
		String strs1[] = { "", "" };
		longestCommonPrefixCalcualte(strs1);
		String strs2[] = { "c", "c" };
		longestCommonPrefixCalcualte(strs2);
	}

}
