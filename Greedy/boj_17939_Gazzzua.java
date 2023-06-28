package greedy;

import java.util.*;
import java.io.*;

public class boj_17939_Gazzzua {

    static int N, ans = 0;
    static int[] chart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        chart = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chart[i] = Integer.parseInt(st.nextToken());
        }

        int max = chart[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            max = Math.max(max, chart[i]);

            if (chart[i] < max) {
                ans += (max - chart[i]);
            }
        }

        System.out.println(ans);
    }
}