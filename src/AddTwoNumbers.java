/**
 * This class implements the addition between two linked list with there
 * elements being integer values in reverse order. It creates and returns
 * recursively a new linked list with their sum.
 * 
 * @author Marios
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersRec(l1, l2, 0);
	}

	public ListNode addTwoNumbersRec(ListNode l1, ListNode l2, int carry) {
		int sum = 0;
		int new_carry = 0;
		int digit = 0;
		ListNode l3 = null;
		if (l1 == null && l2 == null) {
			if (carry != 0) {
				l3 = new ListNode(carry);
			}
		} else if (l1 == null) {
			sum = l2.val + carry;
			if (sum >= 10) {
				digit = sum % 10;
				new_carry = 1;
			} else {
				digit = sum;
				new_carry = 0;
			}
			l3 = new ListNode(digit);
			l3.next = addTwoNumbersRec(l1, l2.next, new_carry);
		} else if (l2 == null) {
			sum = l1.val + carry;
			if (sum >= 10) {
				digit = sum % 10;
				new_carry = 1;
			} else {
				digit = sum;
				new_carry = 0;
			}
			l3 = new ListNode(digit);
			l3.next = addTwoNumbersRec(l1.next, l2, new_carry);
		} else {
			sum = l1.val + l2.val + carry;
			if (sum >= 10) {
				digit = sum % 10;
				new_carry = 1;
			} else {
				digit = sum;
				new_carry = 0;
			}
			l3 = new ListNode(digit);
			l3.next = addTwoNumbersRec(l1.next, l2.next, new_carry);
		}
		return l3;
	}
}

public class AddTwoNumbers {

	public static void print(ListNode l) {
		ListNode temp = l;
		System.out.print("[");
		while (temp != null) {
			System.out.print(temp.val);
			if (temp.next != null) {
				System.out.print(" -> ");
			}
			temp = temp.next;
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		print(l1);
		System.out.print(" + ");
		print(l2);
		System.out.println();

		Solution s1 = new Solution();
		ListNode l3 = s1.addTwoNumbers(l1, l2);
		print(l3);

		System.out.println();
		System.out.println();
		l1 = new ListNode(1);
		l1.next = new ListNode(8);

		l2 = new ListNode(0);

		print(l1);
		System.out.print(" + ");
		print(l2);
		System.out.println();

		s1 = new Solution();
		l3 = s1.addTwoNumbers(l1, l2);
		print(l3);
	}

}
