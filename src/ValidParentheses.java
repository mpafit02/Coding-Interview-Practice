import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * 
 * Example 1:
 * 
 * Input: "()"
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * Input: "()[]{}"
 * 
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * Input: "(]"
 * 
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * Input: "([)]"
 * 
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * Input: "{[]}"
 * 
 * Output: true
 * 
 * 
 * @author Marios
 *
 */
public class ValidParentheses {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char c, c_pop;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				c_pop = stack.pop();
				if ((c == '}' && c_pop != '{') || (c == ']' && c_pop != '[') || (c == ')' && c_pop != '(')) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void validParentheses(String s) {
		System.out.println("Input: \"" + s + "\"");
		System.out.println("Ouptut: " + isValid(s));
		System.out.println();
	}

	public static void main(String[] args) {
		String strs[] = { "()", "()[]{}", "([({})])[]", "(])", "(]", "([)]", "{[]}", "", "(" };
		for (String str : strs) {
			validParentheses(str);
		}
	}

}
