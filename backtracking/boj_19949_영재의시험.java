package backtracking;

import java.util.*;
import java.io.*;

public class boj_19949_영재의시험 {

    static long ans = 0;
    static int[] answer = new int[10];
    static int[] src = new int[10];

    static void solve(int len) {
        if (len == 10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                //System.out.print(src[i] + " ");
                if (answer[i] == src[i]) {
                    cnt++;
                }
            }
            //System.out.println();

            if (cnt >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (len >= 2) {
                if (src[len - 2] == src[len - 1] && src[len - 2] == i) {
                    continue;
                }
            }

            src[len] = i;
            solve(len + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);
        System.out.println(ans);
    }
}
