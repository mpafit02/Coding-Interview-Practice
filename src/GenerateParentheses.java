import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author Marios
 *
 */
public class GenerateParentheses {
	public static void generateParenthesesRec(List<String> parentheses, String s, int left, int right) {
		if (left > right) {
			return;
		}
		if (left == 0 && right == 0) {
			parentheses.add(s);
			return;
		}
		if (left > 0) {
			generateParenthesesRec(parentheses, s + "(", left - 1, right);
		}
		if (right > 0) {
			generateParenthesesRec(parentheses, s + ")", left, right - 1);
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> parentheses = new ArrayList<>();
		generateParenthesesRec(parentheses, "", n, n);
		return parentheses;
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> parentheses = generateParenthesis(n);
		System.out.println("[");
		for (int i = 0; i < parentheses.size(); i++) {
			System.out.print(parentheses.get(i));
			if (i != parentheses.size() - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("]");
		System.out.println();
		n = 5;
		List<String> parentheses2 = generateParenthesis(n);
		System.out.println("[");
		for (int i = 0; i < parentheses2.size(); i++) {
			System.out.print(parentheses2.get(i));
			if (i != parentheses2.size() - 1) {
				System.out.println(", ");
			}
		}
		System.out.println("]");
	}

}
