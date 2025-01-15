public class Q189_Rotate_Array {
	public void rotate(int[] nums, int k) {
		k %= nums.length;

		if (k == 0) {
			return;
		}

		int idx = 0;
		int prev = nums[idx];
		int tmp;

		int common = gcd(nums.length, k);

		for (int i=0; i<common; i++) {
			swap(i, nums, nums.length/common, k);
		}
	}

	private void swap(int start, int[] nums, int count, int step) {
		int idx = start;
		int prev = nums[idx];
		int tmp;

		for (int i=0; i<count; i++) {
			idx = (idx + step)%nums.length;
			tmp = nums[idx];
			nums[idx] = prev;
			prev = tmp;
		}
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a%b);
		}
	}
}
