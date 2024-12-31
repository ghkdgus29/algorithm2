public class Q88_Merge_Sorted_Array {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx = m + n - 1;
		int left = m - 1;
		int right = n - 1;
		while (idx >= 0) {
			if (left < 0) {
				while (right >= 0) {
					nums1[idx--] = nums2[right--];
				}
				break;
			} else if (right < 0) {
				break;
			}

			// nums1 last element is bigger
			else if (nums1[left] > nums2[right]) {
				nums1[idx] = nums1[left--];
			}

			// nums2 last element is bigger or equal
			else {
				nums1[idx] = nums2[right--];
			}
			idx--;
		}
	}
}
