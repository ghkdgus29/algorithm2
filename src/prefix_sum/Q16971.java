package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16971 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[][] a = new int[h][w];
		long[][] rowSum = new long[h + 1][w + 1];
		long[][] colSum = new long[h + 1][w + 1];

		for (int y = 0; y < h; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++) {
				a[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 1; y <= h; y++) {
			for (int x = 1; x <= w; x++) {
				if (x == 1 || x == w) {
					rowSum[y][x] = a[y - 1][x - 1] + rowSum[y][x - 1];
				} else {
					rowSum[y][x] = 2 * a[y - 1][x - 1] + rowSum[y][x - 1];
				}
			}
		}

		for (int x = 1; x <= w; x++) {
			for (int y = 1; y <= h; y++) {
				if (y == 1 || y == h) {
					colSum[y][x] = a[y - 1][x - 1] + colSum[y - 1][x];
				} else {
					colSum[y][x] = 2 * a[y - 1][x - 1] + colSum[y - 1][x];
				}
			}
		}


		long ans = Integer.MIN_VALUE;

		long firstRowSum = rowSum[1][w];
		long lastRowSum = rowSum[h][w];
		for (int y = 1; y < h; y++) {
			long tmp = lastRowSum;
			for (int i = 1; i < h; i++) {
				if (i == y) {
					tmp += rowSum[i][w];
				} else {
					tmp += 2 * rowSum[i][w];
				}
			}
			ans = Math.max(ans, tmp);
		}

		for (int y = 2; y <= h; y++) {
			long tmp = firstRowSum;
			for (int i = 2; i <= h; i++) {
				if (i == y) {
					tmp += rowSum[i][w];
				} else {
					tmp += 2 * rowSum[i][w];
				}
			}
			ans = Math.max(ans, tmp);
		}

		long firstColumnSum = colSum[h][1];
		long lastColumnSum = colSum[h][w];
		for (int x = 1; x < w; x++) {
			long tmp = lastColumnSum;
			for (int i = 1; i < w; i++) {
				if (i == x) {
					tmp += colSum[h][i];
				} else {
					tmp += 2 * colSum[h][i];
				}
			}
			ans = Math.max(ans, tmp);
		}

		for (int x = 2; x <= w; x++) {
			long tmp = firstColumnSum;
			for (int i = 2; i <= w; i++) {
				if (i == x) {
					tmp += colSum[h][i];
				} else {
					tmp += 2 * colSum[h][i];
				}
			}
			ans = Math.max(ans, tmp);
		}

		System.out.println(ans);
	}
}
