import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Q380_Insert_Delete_GetRandom_O1 {

	 class RandomizedSet {

		private Map<Integer, Integer> map;
		private List<Integer> list;
		private Random random = new Random();

		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}
			map.put(val, list.size());
			list.add(val);
			return true;
		}

		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int index = map.get(val);
			int lastVal = list.get(list.size()-1);
			list.set(index, lastVal);
			map.replace(lastVal, index);

			list.remove(list.size()-1);
			map.remove(val);
			return true;
		}

		public int getRandom() {
			int randomIndex = random.nextInt(list.size());
			return list.get(randomIndex);
		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet();
	 * boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val);
	 * int param_3 = obj.getRandom();
	 */
}
