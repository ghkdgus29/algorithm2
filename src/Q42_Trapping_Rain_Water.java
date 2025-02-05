public class Q42_Trapping_Rain_Water {
	public int trap(int[] height) {
		int start = 0;
		int total = 0;
		int cur = 0;
		for (int h : height) {
			cur += Math.max(start - h, 0);
			if (start <= h) {
				total += cur;
				cur = 0;
				start = h;
			}
		}

		start = cur = 0;
		for (int i=height.length-1; i >= 0; i--) {
			cur += Math.max(start - height[i], 0);
			if (start < height[i]) {
				total += cur;
				cur = 0;
				start = height[i];
			}
		}

		return total;
	}
}
