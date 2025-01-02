public class Q27_Remove_Element {
	public int removeElement(int[] nums, int val) {
		int tail = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == val) {
				int tmp = nums[tail];
				nums[tail] = nums[i];
				nums[i] = tmp;
				tail--;
			}
		}
		return tail + 1;
	}
}
