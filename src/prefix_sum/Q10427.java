package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long[] a = new long[n];
			long[] s = new long[n + 1];

			for (int j = 0; j < n; j++) {
				a[j] = Long.parseLong(st.nextToken());
			}

			Arrays.sort(a);
			for (int j = 1; j <= n; j++) {
				s[j] = s[j - 1] + a[j - 1];
			}

			long ans = 0;
			long min = Integer.MAX_VALUE;
			for (int j = 2; j <= n; j++) {
				for (int k = j; k <= n; k++) {
					min = Math.min(min, j * a[k - 1] - (s[k] - s[k - j]));
				}
				ans += min;
				min = Integer.MAX_VALUE;
			}
			System.out.println(ans);
		}
	}
}
// 추가적으로 갚아야 할 돈 최소화가 목적
// 최소값을 가진 부분배열?
// 그러면서 그 안의 값들은 even 해야함 (가장 커야함)
// 1 3 4 5 8
// 구간 누적합 계산?
