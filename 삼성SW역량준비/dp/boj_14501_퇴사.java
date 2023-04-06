package 삼성SW역량준비.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {

    static int N;
    static int[] time, pay;
    static int[] dp; //dp[i]: i번째 날의 최대 이익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        time = new int[N]; //0: 시간, 1: 이익
        pay = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        dp[0] = 0;

        /*
        지금까지 계산한 값과 지금 계산해야할 값 중 더 큰 값이 dp값.
         */
        for (int i = 0; i < N; i++) {
            if (i + time[i] <= N) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
