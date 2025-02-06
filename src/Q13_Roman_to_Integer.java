import java.util.HashMap;
import java.util.Map;

public class Q13_Roman_to_Integer {
	public int romanToInt(String s) {
		Map<String, Integer> converter = new HashMap<>();
		converter.put("I", 1);
		converter.put("IV", 4);
		converter.put("V", 5);
		converter.put("IX", 9);
		converter.put("X", 10);
		converter.put("XL", 40);
		converter.put("L", 50);
		converter.put("XC", 90);
		converter.put("C", 100);
		converter.put("CD", 400);
		converter.put("D", 500);
		converter.put("CM", 900);
		converter.put("M", 1000);

		int num = 0;
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == 'I' || cur == 'X' || cur == 'C') {
				if (i + 1 < s.length()) {
					String key = "" + cur + s.charAt(i+1);
					if (converter.containsKey(key)) {
						num += converter.get(key);
						i++;
						continue;
					}
				}
			}
			num += converter.get(String.valueOf(cur));
		}

		return num;
	}
}
