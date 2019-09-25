/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author Marios
 *
 */
class ListNode_S {
	int val;
	ListNode_S next;

	ListNode_S(int x) {
		val = x;
	}
}

public class SwapNodesInPairs {

	public static ListNode_S swapPairsRec(ListNode_S node) {
		ListNode_S p = node;
		if (p == null) {
			return null;
		}
		ListNode_S q = node.next;
		if (q == null) {
			return node;
		}
		ListNode_S temp = q.next;
		q.next = p;
		p.next = swapPairsRec(temp);
		return q;
	}

	public static ListNode_S swapPairs(ListNode_S head) {
		return swapPairsRec(head);
	}

	public static void main(String[] args) {
		ListNode_S list1 = new ListNode_S(1);
		list1.next = new ListNode_S(2);
		list1.next.next = new ListNode_S(3);
		list1.next.next.next = new ListNode_S(4);
		ListNode_S p = list1;
		while (p != null) {
			System.out.print(p.val + " -> ");
			p = p.next;
		}
		System.out.println();
		ListNode_S swap_p = swapPairs(list1);
		while (swap_p != null) {
			System.out.print(swap_p.val + " -> ");
			swap_p = swap_p.next;
		}

		System.out.println();
		System.out.println();

		ListNode_S list2 = new ListNode_S(1);
		list2.next = new ListNode_S(2);
		list2.next.next = new ListNode_S(3);
		list2.next.next.next = new ListNode_S(4);
		list2.next.next.next.next = new ListNode_S(5);
		p = list2;
		while (p != null) {
			System.out.print(p.val + " -> ");
			p = p.next;
		}
		System.out.println();
		swap_p = swapPairs(list2);
		while (swap_p != null) {
			System.out.print(swap_p.val + " -> ");
			swap_p = swap_p.next;
		}
	}

}
