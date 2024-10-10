import java.util.*;
import java.lang.*;
import java.io.*;

class Q11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long s[] = new long[n+5];
        for (int i=0; i<n; i++) {
            s[i+1] = s[i] + Long.parseLong(st.nextToken());
        }

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(s[end] - s[start-1]);
        }
    }
}
