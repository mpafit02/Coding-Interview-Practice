import java.util.HashSet;

/**
 * @author Marios
 * 
 * This class calculates recursively all the possible permutations of a given string 
 * 
 * @param args
 */
public class StringPermutations {
	public static void main(String args[]) {
		String str0 = "abc"; // Examples
		String str1 = "abcdef"; // Examples
		String str2 = "abcdefghi"; // Examples
		String str3 = "aaaaaaa"; // Examples

		HashSet<String> perms2 = permutations(str2);
		print(perms2);

		HashSet<String> perms0 = permutations(str0);
		print(perms0);

		HashSet<String> perms1 = permutations(str1);
		print(perms1);

		HashSet<String> perms3 = permutations(str3);
		print(perms3);
	}

	/**
	 * Function for calling the recursive function to find the string permutations
	 */
	public static HashSet<String> permutations(String str) {

		System.out.println("Permutations for the world: " + str);

		HashSet<String> perms = new HashSet<String>();
		perms.add("");

		return permutationsRec(str, 0, perms);
	}

	/**
	 * Recursive function for creating the permutations
	 */
	public static HashSet<String> permutationsRec(String str, int index, HashSet<String> perms) {
		// Terminate if we reached the end of the string
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
		return permutationsRec(str, index + 1, temp);
	}

	/**
	 * Print function
	 */
	public static void print(HashSet<String> perms) {
		int i = 0;
		for (String perm : perms) {
			if (i % 10 == 0) {
				System.out.println();
				i = 0;
			}
			System.out.print(perm + " ");
			i++;
		}
		System.out.println();
		System.out.println();
	}
}
