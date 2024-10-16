import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Q16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        Map<Character, int[]> dict = new HashMap<>();
        for(int i=0; i<26; i++) {
            dict.put((char)('a' + i), new int[a.length + 2]);
        }
        for (int i=0; i<26; i++) {
            char key = (char) ('a' + i);
            int[] s = dict.get(key);
            for (int j=0; j<a.length; j++) {
                s[j+1] = s[j] + (a[j] == key ? 1 : 0);  
            }
        }

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;

            int[] s = dict.get(target);
            sb.append(s[end]-s[start] + "\n");
            // System.out.println(s[end] - s[start]);
        }

        System.out.println(sb);

        // k ~ k+1
    }
}
