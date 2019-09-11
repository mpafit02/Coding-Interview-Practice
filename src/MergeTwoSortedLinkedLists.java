class MyListNode {
	int val;
	MyListNode next;

	MyListNode(int x) {
		val = x;
	}
}

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * 
 * Output: 1->1->2->3->4->4
 * 
 * @author Marios
 *
 */
public class MergeTwoSortedLinkedLists {
	public static MyListNode mergeTwoListsRec(MyListNode l1, MyListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoListsRec(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRec(l1, l2.next);
			return l2;
		}
	}

	public static MyListNode mergeTwoLists(MyListNode l1, MyListNode l2) {
		MyListNode p = l1;
		MyListNode q = l2;
		MyListNode l3 = new MyListNode(0);
		MyListNode m = l3;
		while (p != null && q != null) {
			if (p.val < q.val) {
				m.next = new MyListNode(p.val);
				p = p.next;
			} else {
				m.next = new MyListNode(q.val);
				q = q.next;
			}
			m = m.next;
		}
		if (p == null && q == null) {
			m = null;
		} else if (p == null) {
			while (q != null) {
				m.next = new MyListNode(q.val);
				m = m.next;
				q = q.next;
			}
		} else if (q == null) {
			while (p != null) {
				m.next = new MyListNode(p.val);
				m = m.next;
				p = p.next;
			}
		}
		return l3.next;
	}

	public static void print(MyListNode l) {
		if (l != null) {
			System.out.print(l.val + " -> ");
			print(l.next);
		} else {
			System.out.print("null");
		}
		return;
	}

	public static void main(String[] args) {
		MyListNode list1 = new MyListNode(1);
		list1.next = new MyListNode(2);
		list1.next.next = new MyListNode(4);

		MyListNode list2 = new MyListNode(1);
		list2.next = new MyListNode(3);
		list2.next.next = new MyListNode(4);

		System.out.println("Input: ");

		print(list1);
		System.out.println();
		print(list2);
		System.out.println();

		MyListNode list3 = mergeTwoLists(list1, list2);

		System.out.println();
		System.out.println("Output: ");
		print(list3);

	}

}
