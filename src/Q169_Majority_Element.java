public class Q169_Majority_Element {
	public int majorityElement(int[] nums) {
		int candidate = Integer.MAX_VALUE;
		int count = 0;

		for (int num: nums) {
			if (count == 0) {
				candidate = num;
			}
			if (candidate == num) {
				count++;
			}else  {
				count--;
			}
		}
		return candidate;
	}
}
