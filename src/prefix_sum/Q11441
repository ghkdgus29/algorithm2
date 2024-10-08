import java.util.*;
import java.lang.*;
import java.io.*;

class Q11441 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long[] s = new long[n + 5];
        for (int i=0; i<n; i++) {
            s[i+1] = s[i] + Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(s[end] - s[start-1]);
        }
        
    }
}
