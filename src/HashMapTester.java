/**
 * Class for testing the Hash Map class.
 * 
 * @author Marios
 *
 */
public class HashMapTester {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.add("a", 10);
		hm.add("b", 12);
		hm.add("", -3);
		hm.add("cd", 4);
		hm.add("dd", 9);

		System.out.println(hm.toString());

		System.out.println("Get a\t: " + hm.key("a"));
		System.out.println("Get b\t: " + hm.key("b"));
		System.out.println("Get ''\t: " + hm.key(""));
		System.out.println("Get cd\t: " + hm.key("cd"));
		System.out.println("Get dd\t: " + hm.key("dd"));
	}

}
