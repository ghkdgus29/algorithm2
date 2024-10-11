import java.util.*;
import java.lang.*;
import java.io.*;

class Q14925 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] a = new int[h][w];

        for (int y=0; y<h; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x=0; x<w; x++){
                a[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] s = new int[h+1][w+1];
        for (int y=1; y<=h; y++) {
            for (int x=1; x<=w; x++) {
                s[y][x] = s[y-1][x] + s[y][x-1] - s[y-1][x-1] + a[y-1][x-1]; 
            }
        }
        
        int ans = 0;
        for (int y=1; y<=h; y++) {
            for (int x=1; x<=w; x++) {
                int offset = 0;
                while (x + offset <= w && y + offset <= h) {
                    if ( (s[y+offset][x+offset] - s[y-1][x+offset] - s[y+offset][x-1] + s[y-1][x-1]) == 0) {
                        ans = Math.max(ans, offset+1);
                    }
                    offset++;
                }
            }
        }
        System.out.println(ans);
    }
}

