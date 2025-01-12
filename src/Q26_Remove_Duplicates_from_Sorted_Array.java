public class Q26_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		int uniqueIndex = 1;
		int totalCount = 1;

		for(int i=1; i< nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				if (uniqueIndex < nums.length) {
					nums[uniqueIndex] = nums[i];
				}
				totalCount++;
				uniqueIndex++;
			}
		}

		return totalCount;
	}
}
