package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		double[] minHappy = new double[n];
		double[] maxHappy = new double[n];
		double[] maxTired = new double[n];
		double[] minTired = new double[n];

		double[] happy = new double[n];
		double[] tired = new double[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			happy[i] = Integer.parseInt(st.nextToken());
			tired[i] = Integer.parseInt(st.nextToken());
		}

		minHappy[0] = happy[0] == 0 ? 1_000_000_001 : happy[0];
		maxTired[0] = tired[0];
		for (int i = 1; i < n; i++) {
			if (happy[i] == 0) {
				minHappy[i] = minHappy[i - 1];
			} else {
				minHappy[i] = Math.min(happy[i], minHappy[i - 1]);
			}
			maxTired[i] = Math.max(tired[i], maxTired[i - 1]);
		}

		maxHappy[n - 1] = happy[n - 1];
		minTired[n - 1] = tired[n - 1] == 0 ? 1_000_000_001 : tired[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxHappy[i] = Math.max(happy[i], maxHappy[i + 1]);
			if (tired[i] == 0) {
				minTired[i] = minTired[i + 1];
			} else {
				minTired[i] = Math.min(tired[i], minTired[i + 1]);
			}
		}

		int ans = -1;
		for (int i = 0; i < n - 1; i++) {
			if (minHappy[i] >= maxHappy[i + 1] && maxTired[i] <= minTired[i + 1]) {
				ans = i;
			}
		}

		System.out.println(ans == -1 ? -1 : ans + 1);
	}

}

// idx 기점으로 min[idx] > max[idx+1] 이 최대인 지점 찾으면 된다 (happy)
// idx 기점으로 max[idx] < min[idx+1] 이 최대인 지점 찾으면 된다 (tired)


