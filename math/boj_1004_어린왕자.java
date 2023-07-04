package math;

import java.util.*;
import java.io.*;

public class boj_1004_어린왕자 {

    static int x1, y1, x2, y2;
    static int n, ans;

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            n = Integer.parseInt(br.readLine());
            //출발점, 도착점이 해당 원 안에 들어있는지 여부를 파악해서
            //둘 다 원 안에 있음 -> 안세도 됨.
            //둘 다 원 밖에 있음 -> 안세도 됨.
            //둘 중 하나만 원 안에 있음 -> 체크.
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                double d1 = dist(x1, y1, cx, cy);
                double d2 = dist(x2, y2, cx, cy);

                boolean chk1 = !(d1 > r);
                boolean chk2 = !(d2 > r);
                if (chk1 != chk2) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}