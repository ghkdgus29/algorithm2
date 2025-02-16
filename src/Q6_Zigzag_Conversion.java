public class Q6_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        boolean reverse = false;
        StringBuilder sb = new StringBuilder();

        if (numRows <= 1) {
            return s;
        }

        for (int idx = 1; idx <= numRows; idx++) {
            int offset = idx - 1;
            int prevIdx = -1;
            boolean flag = true;

            while (offset < s.length()) {
                if (prevIdx != offset) {
                    sb.append(s.charAt(offset));
                }

                prevIdx = offset;
                if (flag) {
                    offset += (numRows - idx) * 2;
                } else {
                    offset += (numRows - (numRows - idx + 1)) * 2;
                }
                flag = !flag;
            }
        }

        return sb.toString();
    }
}
