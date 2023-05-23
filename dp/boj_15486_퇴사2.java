package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15486_퇴사2 {

    static int N;
    static int[][] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        days = new int[N][2]; //0: 걸리는 일, 1: 버는 금액
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1]; //N번째 날의 최대 이익
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (i + days[i][0] <= N) {
                dp[i + days[i][0]] = Math.max(dp[i + days[i][0]], dp[i] + days[i][1]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}