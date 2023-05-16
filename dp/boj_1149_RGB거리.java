package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149_RGB거리 {

    static int N;
    static int[][] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        home = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            home[i][0] = Integer.parseInt(st.nextToken());
            home[i][1] = Integer.parseInt(st.nextToken());
            home[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i][0] = home[i][0];
                dp[i][1] = home[i][1];
                dp[i][2] = home[i][2];
            } else {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
            }
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}