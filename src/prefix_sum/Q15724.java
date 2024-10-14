import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Q15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long[][] a = new long[h][w];

        for (int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<w; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] s = new long[h+1][w+1];

        for (int i=1; i<= h; i++) {
            for (int j=1; j<=w; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i-1][j-1];
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i< t; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            System.out.println(s[ey][ex] - s[ey][sx-1] - s[sy-1][ex] + s[sy-1][sx-1]);
        }
    }
}
