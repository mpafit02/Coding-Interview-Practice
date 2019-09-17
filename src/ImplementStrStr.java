/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll"
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * 
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author Marios
 *
 */
public class ImplementStrStr {
	public static int strStrFaster(String haystack, String needle) {
		int longer = haystack.length();
		int shorter = needle.length();

		if (shorter > longer) {
			return -1;
		}
		for (int i = 0; i <= longer - shorter; i++) {
			if (haystack.substring(i, i + shorter).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.equals("")) {
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++) {
			System.out.println(haystack.charAt(i));
			if (haystack.charAt(i) == needle.charAt(0)) {
				int index = i;
				int j = 0;
				for (; j < needle.length(); j++) {
					if (index >= haystack.length()) {
						return -1;
					}
					System.out.print(haystack.charAt(index) + " ");
					if (haystack.charAt(index) == needle.charAt(j)) {
						index++;
					} else {
						break;
					}
				}
				if (j == needle.length()) {
					return i;
				}
			}
			System.out.println();
		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStr(haystack, needle));
		System.out.println();
		haystack = "aaaaa";
		needle = "bba";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStr(haystack, needle));
		System.out.println();
		haystack = "aba";
		needle = "";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStr(haystack, needle));
		System.out.println();
		haystack = "hello";
		needle = "ll";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStrFaster(haystack, needle));
		System.out.println();
		haystack = "aaaaa";
		needle = "bba";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStrFaster(haystack, needle));
		System.out.println();
		haystack = "aba";
		needle = "";
		System.out.println("Input: Haystack = \"" + haystack + "\" Needle = \"" + needle + "\"");
		System.out.println("Ouptut: " + strStrFaster(haystack, needle));
	}

}
