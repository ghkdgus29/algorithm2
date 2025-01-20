import java.util.ArrayDeque;
import java.util.Queue;

public class Q55_Jump_Game {
	public boolean canJump(int[] nums) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[nums.length];

		visit[0] = true;
		queue.add(0);
		while (!queue.isEmpty()) {
			int cur = queue.remove();
			cur = Math.min(nums.length -1, cur);
			for(int i=1; i<=nums[cur]; i++) {
				if (cur + i < nums.length && !visit[cur+i]) {
					visit[cur + i] = true;
					queue.add(cur + i);
				}
			}
		}

		return visit[nums.length-1];
	}
}
