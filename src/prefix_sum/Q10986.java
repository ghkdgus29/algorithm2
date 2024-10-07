import java.util.*;
import java.lang.*;
import java.io.*;

class Q10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] s = new long[n+5];

        for (int i=0; i< n; i++){
            s[i+1] = s[i] + Long.parseLong(st.nextToken());
        }

        Map<Long, Long> dict = new HashMap<>();
        
        for (int i=0; i<n+1; i++) {
            s[i] = s[i] % m;
            if (!dict.containsKey(s[i])) {
                dict.put(s[i], 0L);
            }
            dict.put(s[i], dict.get(s[i]) + 1);
        }

        long ans = 0;
        
        for (long key : dict.keySet()) {
            long cnt = dict.get(key);
            ans += cnt * (cnt-1) / 2;
        }

        System.out.println(ans);
    }
}
