public class Q392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        if (s.isEmpty()) {
            return true;
        }
        for(int i=0; i< t.length(); i++) {
            if (s.charAt(idx) == t.charAt(i)) {
                idx++;
                if (idx == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
