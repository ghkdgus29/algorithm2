public class Q274_H_Index {
	public int hIndex(int[] citations) {
		int[] counter = new int[1001];

		for (int num : citations) {
			counter[num]++;
		}

		int sum = 0;
		for (int i= 1000; i>=0; i--) {
			sum += counter[i];
			if (i <= sum) {
				return i;
			}
		}

		return 0;
	}
}
