package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] a = new long[n];
		long[] s = new long[n + 5];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
			s[i + 1] = s[i] + a[i];
		}

		long ans = 0;

		for (int i = 1; i < n; i++) {
			ans += s[i] * a[i];
		}

		System.out.println(ans);
	}
}
