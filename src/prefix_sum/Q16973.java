package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[][] a = new int[h][w];
		int[][] s = new int[h + 1][w + 1];

		for (int y = 0; y < h; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < w; x++) {
				a[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 1; y <= h; y++) {
			for (int x = 1; x <= w; x++) {
				s[y][x] = s[y - 1][x] + s[y][x - 1] - s[y - 1][x - 1] + a[y - 1][x - 1];
			}
		}

		Queue<List<Integer>> queue = new ArrayDeque<>();
		int[][] dist = new int[h + 1][w + 1];

		for (int y = 0; y < dist.length; y++) {
			for (int x = 0; x < dist[0].length; x++) {
				dist[y][x] = -1;
			}
		}

		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};


		st = new StringTokenizer(br.readLine());
		int yOffset = Integer.parseInt(st.nextToken()) - 1;
		int xOffset = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		int ex = Integer.parseInt(st.nextToken());

		sy += yOffset;
		ey += yOffset;
		sx += xOffset;
		ex += xOffset;

		if (ex > w || ey > h) {
			System.out.println(-1);
			return;
		}

		queue.add(List.of(sx, sy));
		dist[sy][sx] = 0;

		while (!queue.isEmpty()) {
			List<Integer> pop = queue.poll();
			int x = pop.get(0);
			int y = pop.get(1);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (xOffset < nx && nx <= w && yOffset < ny && ny <= h) {
					if (dist[ny][nx] != -1) {
						continue;
					}
					if ((s[ny][nx] - s[ny - yOffset - 1][nx] - s[ny][nx - xOffset - 1] + s[ny - yOffset - 1][nx - xOffset - 1]) == 0) {
						queue.add(List.of(nx, ny));
						dist[ny][nx] = dist[y][x] + 1;
					}
				}
			}
		}
		System.out.println(dist[ey][ex]);
	}
}
