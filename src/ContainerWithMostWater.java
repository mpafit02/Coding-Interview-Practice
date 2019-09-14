
public class ContainerWithMostWater {
	public int maxAreaBruteForce(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i; j < height.length; j++) {
				int minHeight = height[j];
				if (height[i] < height[j]) {
					minHeight = height[i];
				}
				if ((j - i + 1) * minHeight > max) {
					System.out.println(j + " " + i);
					max = (j - i + 1) * minHeight;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
