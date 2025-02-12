public class Q14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		int validPrefixIdx = strs[0].length();
		String prefix = strs[0];
		for (String s: strs) {
			validPrefixIdx = Math.min(validPrefixIdx, s.length());
			for (int i=0; i< validPrefixIdx; i++) {
				if (prefix.charAt(i) != s.charAt(i)) {
					validPrefixIdx = i;
					break;
				}
			}
		}

		if (validPrefixIdx < 0) {
			return "";
		}
		return prefix.substring(0, validPrefixIdx);
	}
}
