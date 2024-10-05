package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] togo = new int[m];
		long[] visit = new long[n + 5];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			togo[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m - 1; i++) {
			if (togo[i] < togo[i + 1]) {
				visit[togo[i]] += 1;
				visit[togo[i + 1]] -= 1;
			} else {
				visit[togo[i + 1]] += 1;
				visit[togo[i]] -= 1;
			}
		}

		for (int i = 1; i < n; i++) {
			visit[i] += visit[i - 1];
		}

		long ans = 0;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			ans += Math.min(a * visit[i], b * visit[i] + c);
		}
		System.out.println(ans);
	}
}
