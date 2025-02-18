import java.util.ArrayList;
import java.util.List;

public class Q68_Test_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<Integer>> wordNumbers = new ArrayList<>();
        List<List<Integer>> blanks = new ArrayList<>();

        int acc = 0;
        List<Integer> wordNumber = new ArrayList<>();
        List<Integer> blank = new ArrayList<>();
        for (int i=0; i< words.length; i++) {
            int currentLength = words[i].length();
            if (acc + currentLength > maxWidth) {
                wordNumbers.add(wordNumber);
                wordNumber = new ArrayList<>();

                // set rest blank at the end
                blank.set(blank.size()-1, blank.get(blank.size()-1) + (maxWidth - acc));

                // distribute blank
                if (blank.size() >= 2) {
                    int rest = blank.remove(blank.size() - 1);
                    for (int j = 0; j< rest; j++) {
                        int idx = j % blank.size();
                        blank.set(idx, blank.get(idx) + 1);
                    }
                }
                blanks.add(blank);
                blank = new ArrayList<>();

                acc = 0;
            }
            blank.add(Math.min(1, maxWidth - (acc + currentLength)));
            acc += currentLength + Math.min(1, maxWidth - (acc + currentLength));
            wordNumber.add(i);
        }

        final int END = -1;
        wordNumbers.add(wordNumber);
        if(!blank.isEmpty()) {
            blank.set(blank.size()-1, END);
        }
        blanks.add(blank);

        List<String> ans = new ArrayList<>();
        for (int i=0; i< wordNumbers.size(); i++) {
            StringBuilder sb = new StringBuilder();
            List<Integer> rowWords = wordNumbers.get(i);
            List<Integer> rowBlank = blanks.get(i);
            for (int j = 0; j<rowWords.size(); j++) {
                sb.append( words[rowWords.get(j)]);
                if (rowBlank.size() > j) {
                    if (rowBlank.get(j) == END) {
                        sb.append(" ".repeat(maxWidth - sb.length()));
                    } else {
                        sb.append(" ".repeat(rowBlank.get(j)));
                    }
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
