package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17128 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] a = new int[n + 3];
		int[] s = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		a[n] = a[0];
		a[n + 1] = a[1];
		a[n + 2] = a[2];

		for (int i = 0; i < n; i++) {
			s[i] = a[i] * a[i + 1] * a[i + 2] * a[i + 3];
		}
		// k 번째 장난 ->  s[k-1], s[k-1-1], s[k-1-2], s[k-1-3]
		long ans = Arrays.stream(s).sum();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			int joke = Integer.parseInt(st.nextToken());

			int tmp = 0;
			tmp += (s[joke - 1] = -1 * s[joke - 1]);
			tmp += (s[((joke - 1 - 1) + n) % n] = -1 * s[((joke - 1 - 1) + n) % n]);
			tmp += (s[((joke - 1 - 2) + n) % n] = -1 * s[((joke - 1 - 2) + n) % n]);
			tmp += (s[((joke - 1 - 3) + n) % n] = -1 * s[((joke - 1 - 3) + n) % n]);

			ans += 2 * tmp;
			System.out.println(ans);
		}
	}
}
