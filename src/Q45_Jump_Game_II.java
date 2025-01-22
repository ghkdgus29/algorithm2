import java.util.ArrayDeque;
import java.util.Queue;

public class Q45_Jump_Game_II {
	public int jump(int[] nums) {
		Queue<Integer> queue = new ArrayDeque<>();

		int[] dist = new int[nums.length];
		dist[0] = 0;
		queue.add(0);

		while(!queue.isEmpty()) {
			int pos = queue.remove();

			for (int i=1; i<= nums[pos]; i++) {
				if (pos + i < nums.length && dist[pos+i] == 0) {
					dist[pos + i] = dist[pos] + 1;
					queue.add(pos + i);
				}
			}
		}

		return dist[nums.length - 1];
	}
}
