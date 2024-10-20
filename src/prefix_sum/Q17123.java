package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			int[][] a = new int[size][size];
			for (int y = 0; y < size; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < size; x++) {
					a[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] s = new int[size][size];
			for (int j = 0; j < cnt; j++) {
				st = new StringTokenizer(br.readLine());

				int sy = Integer.parseInt(st.nextToken()) - 1;
				int sx= Integer.parseInt(st.nextToken())-1;
				int ey = Integer.parseInt(st.nextToken())-1;
				int ex = Integer.parseInt(st.nextToken())-1;
				int offset = Integer.parseInt(st.nextToken());

				for (int k = sy; k <= ey; k++) {
					s[k][sx] += offset;
					if (ex + 1 < size) {
						s[k][ex + 1] -= offset;
					}
				}
			}

			for (int y = 0; y < size; y++) {
				for (int x = 1; x < size; x++) {
					s[y][x] += s[y][x - 1];
				}
			}

			for (int y = 0; y < size; y++) {
				int rowSum = 0;
				for (int x = 0; x < size; x++) {
					rowSum += a[y][x] + s[y][x];
				}
				System.out.print(rowSum + " ");
			}
			System.out.println();

			for (int x = 0; x < size; x++) {
				int colSum = 0;
				for (int y = 0; y < size; y++) {
					colSum += a[y][x] + s[y][x];
				}
				System.out.print(colSum + " ");
			}
			System.out.println();
		}
	}
}
