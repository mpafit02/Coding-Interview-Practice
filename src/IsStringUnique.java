/**
 * Class to check whether a string is unique or not. Time Complexity is O(c)
 * where c is the length of the string. Because the maximum length string that
 * we are going to check is 128 characters then the complexity is O(1). We are
 * using an additional data structure though which is a boolean array;
 * 
 * @author Marios
 *
 */
public class IsStringUnique {

	public static void main(String[] args) {
		String strs[] = { "abcdefghij", "abcdefgaij", "abcdbfgaij", "", "  ", "aa", "121212", "b",
				"abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" };
		for (String str : strs) {
			System.out.println("Is string '" + str + "' unique? " + ((isUnique(str)) ? "Yes" : "No"));
		}
	}

	public static boolean isUnique(String str) {
		// Characters of ASCII code
		if (str.length() > 128) {
			return false;
		}
		boolean[] chars = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			if (chars[str.charAt(i)] == true) {
				return false;
			}
			chars[str.charAt(i)] = true;
		}
		return true;
	}

}

