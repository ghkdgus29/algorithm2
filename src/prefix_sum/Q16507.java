package prefix_sum;

import java.util.*;
import java.lang.*;
import java.io.*;

class Q16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] a = new int[h][w];

        for (int y = 0; y<h; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x <w; x++) {
                a[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] s = new long[h+1][w+1];

        for (int y=1; y<=h; y++) {
            for (int x=1; x<= w; x++) {
                s[y][x] = s[y][x-1] + s[y-1][x] - s[y-1][x-1] + a[y-1][x-1];
            }
        }

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            int cnt = (ey - sy + 1) * (ex - sx + 1);
            
            System.out.println((s[ey][ex] - s[ey][sx-1] - s[sy-1][ex] + s[sy-1][sx-1]) / cnt);
        }
    }
}
