package prefix_sum;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Q17390 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int len = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		int[] a = new int[len];
		long[] s = new long[len + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		for (int i = 1; i <= len; i++) {
			s[i] = s[i - 1] + a[i - 1];
		}

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(s[end] - s[start - 1]);
		}

	}
}
