import java.util.HashSet;

/**
 * This algorithm finds all the palindrome permutations of a given string.
 * 
 * @author Marios
 *
 */
public class PalindromePermutation {

	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static HashSet<String> permutations(String str, int index, HashSet<String> perms) {
		if (index >= str.length()) {
			return perms;
		}

		// Temporary HashSet for storing the new strings
		HashSet<String> temp = new HashSet<String>();

		// The character that we are going to add to the old permutations in order to
		// create new strings
		char c = str.charAt(index);

		// For each string in the existing set
		for (String perm : perms) {

			// Create all the possible string by adding the new character in all the
			// positions of the existing permutations
			for (int i = 0; i <= perm.length(); i++) {

				// The prefix
				String prefix = perm.substring(0, i);

				// The suffix
				String suffix = perm.substring(i);

				// Create the new string by adding the prefix the character and the suffix all
				// together
				String new_perm = prefix + c + suffix;

				// Add the new string to the HashSet
				temp.add(new_perm);
			}
		}
		// Call recursive again with the new permutations and the index for the new
		// character that we are going to add
		return permutations(str, index + 1, temp);
	}

	public static void main(String[] args) {
		String input = "Tact Coa";
		String new_input = input.replace(" ", "").toLowerCase();
		System.out.println("Input: " + new_input);
		HashSet<String> perms = new HashSet<>();
		perms.add("");
		System.out.print("Output: ");
		int i = 0;
		for (String perm : permutations(new_input, 0, perms)) {
			if (isPalindrome(perm)) {
				System.out.print(perm + " ");
				i++;
				if (i % 10 == 0) {
					System.out.println();
					i = 0;
				}
			}
		}
	}

}
