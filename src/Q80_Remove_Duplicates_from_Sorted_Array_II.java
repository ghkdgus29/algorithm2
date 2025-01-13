public class Q80_Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
		int prev = nums[0];
		int idx = 1;
		boolean duplicate = false;

		for (int i=1; i< nums.length; i++) {
			if (nums[i] == prev) {
				if (!duplicate) {
					duplicate = true;
					nums[idx++] = nums[i];
				}
			} else {
				duplicate = false;
				prev = nums[i];
				nums[idx++] = nums[i];
			}
		}
		return idx;
	}
}
