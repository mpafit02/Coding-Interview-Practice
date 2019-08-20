import java.util.ArrayList;

public class StringPermutations {
	public static void main(String args[]) {
		String str = "abcdefg";
		System.out.println("Permutations for the world: " + str);
		System.out.println(permutations(str));
	}

	public static ArrayList<String> permutations(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add("");
		return permutationsRec(str, 0, perms);
	}

	public static ArrayList<String> permutationsRec(String str, int index, ArrayList<String> perms) {
		if (index >= str.length()) {
			return perms;
		}
		ArrayList<String> temp = new ArrayList<String>();
		char c = str.charAt(index);
		for (String perm : perms) {
			for (int i = 0; i <= perm.length(); i++) {
				String pref = perm.substring(0, i);
				String suf = perm.substring(i);
				String new_perm = pref + c + suf;
				temp.add(new_perm);
			}
		}
		return permutationsRec(str, index + 1, temp);
	}
}
