package dp;

import java.io.*;

public class boj_25421_조건에맞는정수의개수 {

    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1) {
                    dp[i][j] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 987_654_321;
                } else if (j == 2) {
                    dp[i][j] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % 987_654_321;
                } else if (j == 8) {
                    dp[i][j] = (dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % 987_654_321;
                } else if (j == 9) {
                    dp[i][j] = (dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9]) % 987_654_321;
                } else {
                    dp[i][j] = (dp[i - 1][j - 2] + dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1] + dp[i - 1][j + 2]) % 987_654_321;
                }
            }
        }

        long sum = 0L;
        for (int i = 1; i <= 9; i++) {
            sum += dp[n][i] % 987_654_321;
        }

        System.out.println(sum % 987_654_321);
    }

}
