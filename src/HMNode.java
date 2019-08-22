/**
 * Class that implements the Nodes of a Hash Map
 * 
 * @author Marios
 *
 */
public class HMNode {

	private String key;
	private int value;

	public HMNode(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
