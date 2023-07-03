package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15990_123더하기5 {

    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009; //마지막에 1을 더하는 경우
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009; //마지막에 2를 더하는 경우
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009; //마지막에 3을 더하는 경우
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009);
        }
    }
}