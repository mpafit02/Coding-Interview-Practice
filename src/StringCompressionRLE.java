/**
 * This class compress strings by applying the Run Length Encoding. It replaces
 * multiple occurrences of a character by a number. If the compressed string is
 * larger of the original then it returns the original string.
 * 
 * @author Marios
 *
 */
public class StringCompressionRLE {

	public static String stringCompress(String str) {
		String compressedStr = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				char temp = (char) str.charAt(i - 1);
				compressedStr = compressedStr + count + temp;
				count = 1;
			}
		}
		char temp = (char) str.charAt(str.length() - 1);
		compressedStr = compressedStr + count + temp;
		if (compressedStr.length() < str.length()) {
			return compressedStr;
		} else {
			return str;
		}
	}

	public static void main(String[] args) {
		String[] inputs = { "aabcccccaaa", "abc", "abbcc", "aabbcc", "!!!!!!", "abcdefggggggggg",
				"aabbbaaADbbbaaabaaa" };
		for (String input : inputs) {
			System.out.println("Compress String: '" + input + "' -> '" + stringCompress(input) + "'");
		}
	}

}
